package com.hrm.service.impl;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hrm.Dao.ITblInterviewDao;
import com.hrm.Dao.QueryResult;
import com.hrm.pojo.TblInterview;
import com.hrm.service.ITblInterviewService;
@Scope("prototype")
@Service("TblInterviewService")
public class TblInterviewServiceImpl implements ITblInterviewService {

	@Autowired
	private ITblInterviewDao tblInterviewDao;

	@Override
	public long getCount() {
		
		return tblInterviewDao.getCount();
	}

	@Override
	public void save(TblInterview entity) {
		tblInterviewDao.save(entity);

	}

	@Override
	public void update(TblInterview entity) {
		
		tblInterviewDao.update(entity);
	}

	@Override
	public void delete(TblInterview entity) {
		
		tblInterviewDao.delete(entity);
	}

	@Override
	public TblInterview find(Serializable entityId) {
		
		return tblInterviewDao.find(entityId);
	}

	@Override
	public QueryResult<TblInterview> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams,
			LinkedHashMap<String, String> orderby) {
		
		return tblInterviewDao.getScrollData(firstindex, maxresult, whereHql, queryParams);
	}

	@Override
	public QueryResult<TblInterview> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams) {
		
		return tblInterviewDao.getScrollData(firstindex, maxresult, whereHql, queryParams);
	}

	@Override
	public QueryResult<TblInterview> getScrollData(int firstindex,
			int maxresult, LinkedHashMap<String, String> orderby) {
		
		return tblInterviewDao.getScrollData(firstindex, maxresult, orderby);
	}

	@Override
	public QueryResult<TblInterview> getScrollData(int firstindex,
			int maxresult) {
		
		return tblInterviewDao.getScrollData(firstindex, maxresult);
	}

	@Override
	public QueryResult<Object> getScrollDataByHql(int firstindex,
			int maxresult, String hql, Object[] queryParams) {
		
		return tblInterviewDao.getScrollDataByHql(firstindex, maxresult, hql, queryParams);
	}

	@Override
	public List<Object> getDataByHql(String hql, Object[] queryParams) {
		
		return tblInterviewDao.getDataByHql(hql, queryParams);
	}

	@Override
	public Long getCount(String hql, Object[] queryParams) {
		
		return tblInterviewDao.getCount(hql, queryParams);
	}

}
