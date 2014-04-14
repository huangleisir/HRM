package com.hrm.service.impl;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hrm.Dao.ITblMajorNameDao;
import com.hrm.Dao.QueryResult;
import com.hrm.pojo.TblMajorName;
import com.hrm.service.ITblMajorNameService;
@Scope("prototype")
@Service("TblMajorNameService")
public class TblMajorNameServiceImpl implements ITblMajorNameService {

	@Autowired
	private ITblMajorNameDao tblMajorNameDao;
	@Override
	public long getCount() {
		
		return tblMajorNameDao.getCount();
	}

	@Override
	public void save(TblMajorName entity) {
		
		tblMajorNameDao.save(entity);
	}

	@Override
	public void update(TblMajorName entity) {
		tblMajorNameDao.update(entity);

	}

	@Override
	public void delete(TblMajorName entity) {
		
		tblMajorNameDao.delete(entity);
	}

	@Override
	public TblMajorName find(Serializable entityId) {
		
		return tblMajorNameDao.find(entityId);
	}

	@Override
	public QueryResult<TblMajorName> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams,
			LinkedHashMap<String, String> orderby) {
		
		return tblMajorNameDao.getScrollData(firstindex, maxresult, whereHql, queryParams, orderby);
	}

	@Override
	public QueryResult<TblMajorName> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams) {
		
		return tblMajorNameDao.getScrollData(firstindex, maxresult, whereHql, queryParams);
	}

	@Override
	public QueryResult<TblMajorName> getScrollData(int firstindex,
			int maxresult, LinkedHashMap<String, String> orderby) {
		
		return tblMajorNameDao.getScrollData(firstindex, maxresult, orderby);
	}

	@Override
	public QueryResult<TblMajorName> getScrollData(int firstindex,
			int maxresult) {
		
		return tblMajorNameDao.getScrollData(firstindex, maxresult);
	}

	@Override
	public QueryResult<Object> getScrollDataByHql(int firstindex,
			int maxresult, String hql, Object[] queryParams) {
		
		return tblMajorNameDao.getScrollDataByHql(firstindex, maxresult, hql, queryParams);
	}

	@Override
	public List<Object> getDataByHql(String hql, Object[] queryParams) {
		
		return tblMajorNameDao.getDataByHql(hql, queryParams);
	}

	@Override
	public Long getCount(String hql, Object[] queryParams) {
		
		return tblMajorNameDao.getCount(hql, queryParams);
	}

}
