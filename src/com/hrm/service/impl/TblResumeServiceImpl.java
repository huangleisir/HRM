package com.hrm.service.impl;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hrm.Dao.ITblResumeDao;
import com.hrm.Dao.QueryResult;
import com.hrm.pojo.TblResume;
import com.hrm.service.ITblResumeService;
@Scope("prototype")
@Service("TblResumeService")
public class TblResumeServiceImpl implements ITblResumeService {

	@Autowired
	private ITblResumeDao tblResumeDao;

	@Override
	public long getCount() {
		
		return tblResumeDao.getCount();
	}

	@Override
	public void save(TblResume entity) {
		tblResumeDao.save(entity);

	}

	@Override
	public void update(TblResume entity) {
		
		tblResumeDao.update(entity);
	}

	@Override
	public void delete(TblResume entity) {
		
		tblResumeDao.delete(entity);
	}

	@Override
	public TblResume find(Serializable entityId) {
		
		return tblResumeDao.find(entityId);
	}

	@Override
	public QueryResult<TblResume> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams,
			LinkedHashMap<String, String> orderby) {
		
		return tblResumeDao.getScrollData(firstindex, maxresult, whereHql, queryParams);
	}

	@Override
	public QueryResult<TblResume> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams) {
		
		return tblResumeDao.getScrollData(firstindex, maxresult, whereHql, queryParams);
	}

	@Override
	public QueryResult<TblResume> getScrollData(int firstindex,
			int maxresult, LinkedHashMap<String, String> orderby) {
		
		return tblResumeDao.getScrollData(firstindex, maxresult, orderby);
	}

	@Override
	public QueryResult<TblResume> getScrollData(int firstindex,
			int maxresult) {
		
		return tblResumeDao.getScrollData(firstindex, maxresult);
	}

	@Override
	public QueryResult<Object> getScrollDataByHql(int firstindex,
			int maxresult, String hql, Object[] queryParams) {
		
		return tblResumeDao.getScrollDataByHql(firstindex, maxresult, hql, queryParams);
	}

	@Override
	public List<Object> getDataByHql(String hql, Object[] queryParams) {
		return tblResumeDao.getDataByHql(hql, queryParams);
	}

	@Override
	public Long getCount(String hql, Object[] queryParams) {
		
		return tblResumeDao.getCount(hql, queryParams);
	}

}
