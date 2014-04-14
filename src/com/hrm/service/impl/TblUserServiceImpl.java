package com.hrm.service.impl;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrm.Dao.ITblUserDao;
import com.hrm.Dao.QueryResult;
import com.hrm.pojo.TblUser;
import com.hrm.service.ITblUserService;
@Service("TblUserService")
public class TblUserServiceImpl implements ITblUserService {
//是不是用注解@Autowired过就不用setter，getter吧
	@Autowired
	private ITblUserDao tblUserDao;
	@Override
	public long getCount() {
		// TODO Auto-generated method stub
		return tblUserDao.getCount();
	}

	@Override
	public void save(TblUser entity) {
		// TODO Auto-generated method stub
		tblUserDao.save(entity);
	}

	@Override
	public void update(TblUser entity) {
		// TODO Auto-generated method stub
		tblUserDao.update(entity);
	}

	@Override
	public void delete(TblUser entity) {
		// TODO Auto-generated method stub
		tblUserDao.delete(entity);
	}

	@Override
	public TblUser find(Serializable entityId) {
		// TODO Auto-generated method stub
		return tblUserDao.find(entityId);
	}

	@Override
	public QueryResult<TblUser> getScrollData(int firstindex, int maxresult,
			String whereHql, Object[] queryParams,
			LinkedHashMap<String, String> orderby) {
		// TODO Auto-generated method stub
		return tblUserDao.getScrollData(firstindex, maxresult, whereHql, queryParams, orderby);
	}

	@Override
	public QueryResult<TblUser> getScrollData(int firstindex, int maxresult,
			String whereHql, Object[] queryParams) {
		// TODO Auto-generated method stub
		return tblUserDao.getScrollData(firstindex, maxresult, whereHql, queryParams);
	}

	@Override
	public QueryResult<TblUser> getScrollData(int firstindex, int maxresult,
			LinkedHashMap<String, String> orderby) {
		// TODO Auto-generated method stub
		return tblUserDao.getScrollData(firstindex, maxresult, orderby);
	}

	@Override
	public QueryResult<TblUser> getScrollData(int firstindex, int maxresult) {
		// TODO Auto-generated method stub
		return tblUserDao.getScrollData(firstindex, maxresult);
	}

	@Override
	public QueryResult<Object> getScrollDataByHql(int firstindex,
			int maxresult, String hql, Object[] queryParams) {
		// TODO Auto-generated method stub
		return tblUserDao.getScrollDataByHql(firstindex, maxresult, hql, queryParams);
	}

	@Override
	public List<Object> getDataByHql(String hql, Object[] queryParams) {
		// TODO Auto-generated method stub
		return tblUserDao.getDataByHql(hql, queryParams);
	}

	@Override
	public Long getCount(String hql, Object[] queryParams) {
		// TODO Auto-generated method stub
		return tblUserDao.getCount(hql, queryParams);
	}

}
