package com.hrm.service.impl;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.hrm.Dao.ITblPublicAttributeDao;
import com.hrm.Dao.QueryResult;
import com.hrm.pojo.TblPublicAttribute;
import com.hrm.service.ITblPublicAttributeService;
@Scope("prototype")
@Service("TblPublicAttributeService")
public class TblPublicAttributeServiceImpl implements ITblPublicAttributeService {

	@Autowired
	private ITblPublicAttributeDao tblPublicAttributeDao;

	@Override
	public long getCount() {
		
		return tblPublicAttributeDao.getCount();
	}

	@Override
	public void save(TblPublicAttribute entity) {
		tblPublicAttributeDao.save(entity);

	}

	@Override
	public void update(TblPublicAttribute entity) {
		
		tblPublicAttributeDao.update(entity);
	}

	@Override
	public void delete(TblPublicAttribute entity) {
		
		tblPublicAttributeDao.delete(entity);
	}

	@Override
	public TblPublicAttribute find(Serializable entityId) {
		
		return tblPublicAttributeDao.find(entityId);
	}

	@Override
	public QueryResult<TblPublicAttribute> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams,
			LinkedHashMap<String, String> orderby) {
		
		return tblPublicAttributeDao.getScrollData(firstindex, maxresult, whereHql, queryParams);
	}

	@Override
	public QueryResult<TblPublicAttribute> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams) {
		
		return tblPublicAttributeDao.getScrollData(firstindex, maxresult, whereHql, queryParams);
	}

	@Override
	public QueryResult<TblPublicAttribute> getScrollData(int firstindex,
			int maxresult, LinkedHashMap<String, String> orderby) {
		
		return tblPublicAttributeDao.getScrollData(firstindex, maxresult, orderby);
	}

	@Override
	public QueryResult<TblPublicAttribute> getScrollData(int firstindex,
			int maxresult) {
		
		return tblPublicAttributeDao.getScrollData(firstindex, maxresult);
	}

	@Override
	public QueryResult<Object> getScrollDataByHql(int firstindex,
			int maxresult, String hql, Object[] queryParams) {
		
		return tblPublicAttributeDao.getScrollDataByHql(firstindex, maxresult, hql, queryParams);
	}

	@Override
	public List<Object> getDataByHql(String hql, Object[] queryParams) {
		
		return tblPublicAttributeDao.getDataByHql(hql, queryParams);
	}

	@Override
	public Long getCount(String hql, Object[] queryParams) {
		
		return tblPublicAttributeDao.getCount(hql, queryParams);
	}

}
