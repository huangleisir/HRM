package com.hrm.Dao;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;


public interface DAO<T> {
	/**
	 * 获取记录总数
	 * @param entityClass 实体类
	 * @return
	 */
	public long getCount();

	
	/**
	 * 保存实体
	 * @param entity 实体id
	 */
	public void save(T entity);
	/**
	 * 更新实体
	 * @param entity 实体id
	 */
	public void update(T entity);
	/**
	 * 删除实体
	 * @param entityClass 实体类
	 * @param entityids 实体id数组
	 */
	public void delete(T entity); 
	/**
	 * 获取实体
	 * @param <T>
	 * @param entityClass 实体类
	 * @param entityId 实体id
	 * @return
	 */
	public T find(Serializable entityId);
	
	/**
	 * 
	 * @param firstindex 开始索引0开始,传入-1则全部查询
	 * @param maxresult  最大获取数,传入-1则全部查询
	 * @param whereHql  条件语句，不需要加where ，别名为o
	 * @param queryParams hql参数
	 * @param orderby LinkedHashMap<要排序的字段, desc/dsc>
	 * @return
	 */
	public QueryResult<T> getScrollData(int firstindex, int maxresult, String whereHql, Object[] queryParams,LinkedHashMap<String, String> orderby);
	
	public QueryResult<T> getScrollData(int firstindex, int maxresult, String whereHql, Object[] queryParams);
	
	public QueryResult<T> getScrollData(int firstindex, int maxresult, LinkedHashMap<String, String> orderby);
	
	public QueryResult<T> getScrollData(int firstindex, int maxresult);
	
	public QueryResult<T> getScrollData() ;
	
	/**
	 * 把hql语句的结果包装到QueryResult<Object>对象中
	 * @param firstindex 开始索引0开始,传入-1则全部查询
	 * @param maxresult 最大获取数,传入-1则全部查询
	 * @param hql hql语句
	 * @param queryParams 参数
	 * @return
	 */
	public QueryResult<Object> getScrollDataByHql(int firstindex, int maxresult, String hql, Object[] queryParams);
	
	/**
	 * 
	 * @param hql hql语句
	 * @param queryParams 参数
	 * @return
	 */
	public List<Object> getDataByHql(String hql, Object[] queryParams);
	
	/**
	 * 
	 * @param hql hql语句
	 * @param queryParams 参数
	 * @return 返回该hql语句有多少条
	 */
	public Long getCount(String hql, Object[] queryParams); 
	
	
	
	
	
}
