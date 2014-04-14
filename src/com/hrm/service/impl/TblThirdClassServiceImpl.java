package com.hrm.service.impl;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hrm.Dao.ITblThirdClassDao;
import com.hrm.Dao.QueryResult;
import com.hrm.pojo.TblThirdClass;
import com.hrm.service.ITblThirdClassService;
@Scope("prototype")
@Service("TblThirdClassService")
public class TblThirdClassServiceImpl implements ITblThirdClassService {

	@Autowired
	private ITblThirdClassDao tblThirdClassDao;
	@Override
	public long getCount() {
		
		return tblThirdClassDao.getCount();
	}

	@Override
	public void save(TblThirdClass entity) {
		
		tblThirdClassDao.save(entity);
	}

	@Override
	public void update(TblThirdClass entity) {
		
		tblThirdClassDao.update(entity);
	}

	@Override
	public void delete(TblThirdClass entity) {
		
		tblThirdClassDao.delete(entity);
	}

	@Override
	public TblThirdClass find(Serializable entityId) {
		
		return tblThirdClassDao.find(entityId);
	}

	@Override
	public QueryResult<TblThirdClass> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams,
			LinkedHashMap<String, String> orderby) {
		
		return tblThirdClassDao.getScrollData(firstindex, maxresult, whereHql, queryParams, orderby);
	}

	@Override
	public QueryResult<TblThirdClass> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams) {
		
		return tblThirdClassDao.getScrollData(firstindex, maxresult, whereHql, queryParams);
	}

	@Override
	public QueryResult<TblThirdClass> getScrollData(int firstindex,
			int maxresult, LinkedHashMap<String, String> orderby) {
		
		return tblThirdClassDao.getScrollData(firstindex, maxresult, orderby);
	}

	@Override
	public QueryResult<TblThirdClass> getScrollData(int firstindex,
			int maxresult) {
		
		return tblThirdClassDao.getScrollData(firstindex, maxresult);
	}

	@Override
	public QueryResult<Object> getScrollDataByHql(int firstindex,
			int maxresult, String hql, Object[] queryParams) {
		
		return tblThirdClassDao.getScrollDataByHql(firstindex, maxresult, hql, queryParams);
	}

	@Override
	public List<Object> getDataByHql(String hql, Object[] queryParams) {
		
		return tblThirdClassDao.getDataByHql(hql, queryParams);
	}

	@Override
	public Long getCount(String hql, Object[] queryParams) {
		
		return tblThirdClassDao.getCount(hql, queryParams);
	}

}
