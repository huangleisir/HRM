package com.hrm.Dao;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Entity;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.hrm.utils.GenericsUtils;


public abstract class DaoSupport<T> implements DAO<T> {
	protected Class<T> entityClass = GenericsUtils.getSuperClassGenricType(this
			.getClass());
	@Autowired
	protected HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void delete(T entityids) {
		hibernateTemplate.delete(entityids);
	}

	public T find(Serializable entityId) {
		if (entityId == null)
			throw new RuntimeException(this.entityClass.getName()
					+ ":传入的实体id不能为空");
		return (T) hibernateTemplate.get(this.entityClass, entityId);
	}

	public void save(T entity) {
		hibernateTemplate.save(entity);
	}

	public long getCount() {
		final Msg msg=new Msg();
		
		Object o = hibernateTemplate.executeFind(new HibernateCallback() {
			 public List<T> doInHibernate(Session session) throws HibernateException, SQLException {
			Long result=(Long) session.createQuery(
						"select count(*) from " + getEntityName(entityClass)
								+ " o").uniqueResult();
			msg.setL(result);
				return null;
			}
		});
		
		 return msg.getL();
	}
	
	@Override
	public void update(T entity) {
		
//		hibernateTemplate.merge(entity);
		hibernateTemplate.update(entity);
	}
	
	@Override
	public QueryResult<T> getScrollData(int firstindex, int maxresult,
			LinkedHashMap<String, String> orderby) {
		return getScrollData(firstindex, maxresult, null, null, orderby);
	}
	
	
	@Override
	public QueryResult<T> getScrollData(int firstindex, int maxresult,
			String wherejpql, Object[] queryParams) {
		return getScrollData(firstindex, maxresult, wherejpql, queryParams,
				null);
	}
	
	
	@Override
	public QueryResult<T> getScrollData(int firstindex, int maxresult) {
		return getScrollData(firstindex, maxresult, null, null, null);
	}
	
	
	@Override
	public QueryResult<T> getScrollData() {
		return getScrollData(-1, -1);
	}
	/**
	 * param firstindex first record
	 * param maxresult num of records
	 * wherejpql 筛选条件（t.age>25）
	 */
	@Override
	public QueryResult<T> getScrollData(final int firstindex,final int maxresult,
			final String wherejpql,final Object[] queryParams,final
			LinkedHashMap<String, String> orderby) {
		/**
		QueryResult qr = new QueryResult<T>();
		String entityname = getEntityName(this.entityClass);
		Query query = getSession().createQuery("from "
				+ entityname
				+ " o "
				+ (wherejpql == null || "".equals(wherejpql.trim()) ? ""
						: "where " + wherejpql) + buildOrderby(orderby));
		setQueryParams(query, queryParams);
		if (firstindex != -1 && maxresult != -1)
			query.setFirstResult(firstindex).setMaxResults(maxresult);
		qr.setResultlist(query.list());
		query = getSession().createQuery("select count(*) from "
				+ entityname
				+ " o "
				+ (wherejpql == null || "".equals(wherejpql.trim()) ? ""
						: "where " + wherejpql));
		setQueryParams(query, queryParams);
		qr.setTotalrecord((Long) query.uniqueResult());
		return qr;
		*/
		final QueryResult qr = new QueryResult<T>();
		Object o = hibernateTemplate.executeFind(new HibernateCallback() {
			public List<T> doInHibernate(Session session) throws HibernateException, SQLException {
				
				Transaction	tx = session.beginTransaction();
				
				String entityname = getEntityName(entityClass);
				Query query = session.createQuery("from "
						+ entityname
						+ " o "
						+ (wherejpql == null || "".equals(wherejpql.trim()) ? ""
								: "where " + wherejpql) + buildOrderby(orderby));
				setQueryParams(query, queryParams);
				if (firstindex != -1 && maxresult != -1)
					query.setFirstResult(firstindex).setMaxResults(maxresult);
				List list= query.list();
				qr.setResultlist(list);
				query = session.createQuery("select count(*) from "
						+ entityname
						+ " o "
						+ (wherejpql == null || "".equals(wherejpql.trim()) ? ""
								: "where " + wherejpql));
				setQueryParams(query, queryParams);
				qr.setTotalrecord((Long) query.uniqueResult());
				
				//下面这三句非必须？   另外很奇怪 这里没有用事务里没有用事务来控制
				
				tx.commit();
				
				session.flush();
				session.clear();
				session.close();
				
				
				return null;
			}
		});
		
		
		return qr;
	}
	
	
	
	
	public List<Object> getDataByHql(final int firstindex,final int maxresult,final String hql,final
			Object[] queryParams) {
		/*Query query = getSession().createQuery(hql);
		setQueryParams(query, queryParams);
		if (firstindex != -1 && maxresult != -1)
			query.setFirstResult(firstindex).setMaxResults(maxresult);
		return query.list();*/
		
		Object o = hibernateTemplate.executeFind(new HibernateCallback() {
			public List<T> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				setQueryParams(query, queryParams);
				if (firstindex != -1 && maxresult != -1)
					query.setFirstResult(firstindex).setMaxResults(maxresult);
				return query.list();
			}
		});
		return (List<Object>)o;
	}

	@Override
	public QueryResult<Object> getScrollDataByHql(int firstindex,
			int maxresult, String hql, Object[] queryParams) {
		QueryResult<Object> qr = new QueryResult<Object>();
		qr.setResultlist(getDataByHql(firstindex, maxresult, hql, queryParams));
		qr.setTotalrecord(getCount(hql, queryParams)); 
		return qr;
	}

	@Override
	public List<Object> getDataByHql(String hql, Object[] queryParams) {
		return getDataByHql(-1, -1, hql, queryParams);
	}

	@Override
	public Long getCount(String hql, Object[] queryParams) {
		String countHql=pase2countHql(hql);
		return (Long) getDataByHql(countHql,queryParams).get(0); 
	}

	/**
	 * 把查询的属性替换成count（*）
	 * @param hql
	 * @return
	 */
	private String pase2countHql(String hql) {
		String nHql=hql;
		if(hql.trim().startsWith("select")){
			nHql=hql.substring(hql.indexOf("from"));
		}
		nHql="select count(*) "+nHql; 
		return nHql; 
	}

	protected static void setQueryParams(Query query, Object[] queryParams) {
		if (queryParams != null && queryParams.length > 0) {
			for (int i = 0; i < queryParams.length; i++) {
				query.setParameter(i, queryParams[i]);
			}
		}
	}

	/**
	 * 组装order by语句
	 * 
	 * @param orderby
	 * @return
	 */
	protected static String buildOrderby(LinkedHashMap<String, String> orderby) {
		StringBuffer orderbyql = new StringBuffer("");
		if (orderby != null && orderby.size() > 0) {
			orderbyql.append(" order by ");
			for (String key : orderby.keySet()) {
				System.out.println(key+" key:column name  ********* value:asc or desc    "+orderby.get(key));
				orderbyql.append("o.").append(key).append(" ")
						.append(orderby.get(key)).append(",");
			}
			orderbyql.deleteCharAt(orderbyql.length() - 1);//删除最后一个逗号
		}
		return orderbyql.toString();
	}

	/**
	 * 获取实体的名称
	 * 
	 * @param <E>
	 * @param clazz
	 *            实体类
	 * @return
	 */
	protected static <E> String getEntityName(Class<E> clazz) {
		String entityname = clazz.getSimpleName();
		Entity entity = clazz.getAnnotation(Entity.class);
		if (entity != null && entity.name() != null
				&& !"".equals(entity.name())) {
			entityname = entity.name();
		}
		return entityname;
	}
	
	class Msg{
		private Long l;
        
		public Msg(Long l) {
			super();
			this.l = l;
		}
		public Msg() {
		}

		public Long getL() {
			return l;
		}

		public void setL(Long l) {
			this.l = l;
		}
		
	}
}


