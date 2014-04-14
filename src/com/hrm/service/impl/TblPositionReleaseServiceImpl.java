package com.hrm.service.impl;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hrm.Dao.ITblPositionReleaseDao;
import com.hrm.Dao.QueryResult;
import com.hrm.pojo.TblPositionRelease;
import com.hrm.service.ITblPositionReleaseService;
@Scope("prototype")
@Service("TblPositionReleaseService")
public class TblPositionReleaseServiceImpl implements ITblPositionReleaseService {
	
	@Autowired
	private ITblPositionReleaseDao tblPositionReleaseDao;

	@Override
	public long getCount() {
	
		return tblPositionReleaseDao.getCount();
	}

	@Override
	public void save(TblPositionRelease entity) {
		tblPositionReleaseDao.save(entity);

	}

	@Override
	public void update(TblPositionRelease entity) {
	
		tblPositionReleaseDao.update(entity);
	}

	@Override
	public void delete(TblPositionRelease entity) {
	
		tblPositionReleaseDao.delete(entity);
	}

	@Override
	public TblPositionRelease find(Serializable entityId) {
	
		return tblPositionReleaseDao.find(entityId);
	}

	@Override
	public QueryResult<TblPositionRelease> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams,
			LinkedHashMap<String, String> orderby) {
	
		return tblPositionReleaseDao.getScrollData(firstindex, maxresult, whereHql, queryParams, orderby);
	}

	@Override
	public QueryResult<TblPositionRelease> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams) {
	
		return tblPositionReleaseDao.getScrollData(firstindex, maxresult, whereHql, queryParams);
	}

	@Override
	public QueryResult<TblPositionRelease> getScrollData(int firstindex,
			int maxresult, LinkedHashMap<String, String> orderby) {
	
		return tblPositionReleaseDao.getScrollData(firstindex, maxresult, orderby);
	}

	@Override
	public QueryResult<TblPositionRelease> getScrollData(int firstindex,
			int maxresult) {
	
		return tblPositionReleaseDao.getScrollData(firstindex, maxresult);
	}

	@Override
	public QueryResult<Object> getScrollDataByHql(int firstindex,
			int maxresult, String hql, Object[] queryParams) {
	
		return tblPositionReleaseDao.getScrollDataByHql(firstindex, maxresult, hql, queryParams);
	}

	@Override
	public List<Object> getDataByHql(String hql, Object[] queryParams) {
	
		return tblPositionReleaseDao.getDataByHql(hql, queryParams);
	}

	@Override
	public Long getCount(String hql, Object[] queryParams) {
	
		return tblPositionReleaseDao.getCount(hql, queryParams);
	}

}
