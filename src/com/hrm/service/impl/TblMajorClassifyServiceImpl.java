package com.hrm.service.impl;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrm.Dao.ITblFirstClassDao;
import com.hrm.Dao.ITblMajorClassifyDao;
import com.hrm.Dao.ITblMajorNameDao;
import com.hrm.Dao.QueryResult;
import com.hrm.pojo.TblFirstClass;
import com.hrm.pojo.TblMajorClassify;
import com.hrm.pojo.TblMajorName;
import com.hrm.service.ITblFirstClassService;
import com.hrm.service.ITblMajorClassifyService;

@Service("TblMajorClassifyService")
public class TblMajorClassifyServiceImpl implements ITblMajorClassifyService {

	@Autowired
	private ITblMajorClassifyDao tblMajorClassifyDao;
	@Autowired
	private ITblMajorNameDao tblMajorNameDao;
	@Override
	public long getCount() {
		
		return tblMajorClassifyDao.getCount();
	}

	@Override
	public void save(TblMajorClassify entity) {
		tblMajorClassifyDao.save(entity);

	}

	@Override
	public void update(TblMajorClassify entity) {
		
		tblMajorClassifyDao.update(entity);
	}

	@Override
	public void delete(TblMajorClassify entity) {
		QueryResult<TblMajorName> resultName=tblMajorNameDao.getScrollData(-1, -1);
		for(int i=0;i<resultName.getResultlist().size();i++){
			if(resultName.getResultlist().get(i).getMajorKindId().equals(entity.getMajorKindId())){
				tblMajorNameDao.delete(resultName.getResultlist().get(i));
			}
		}
		tblMajorClassifyDao.delete(entity);
	}

	@Override
	public TblMajorClassify find(Serializable entityId) {
		
		return tblMajorClassifyDao.find(entityId);
	}

	@Override
	public QueryResult<TblMajorClassify> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams,
			LinkedHashMap<String, String> orderby) {
		
		return tblMajorClassifyDao.getScrollData(firstindex, maxresult, whereHql, queryParams);
	}

	@Override
	public QueryResult<TblMajorClassify> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams) {
		
		return tblMajorClassifyDao.getScrollData(firstindex, maxresult, whereHql, queryParams);
	}

	@Override
	public QueryResult<TblMajorClassify> getScrollData(int firstindex,
			int maxresult, LinkedHashMap<String, String> orderby) {
		
		return tblMajorClassifyDao.getScrollData(firstindex, maxresult, orderby);
	}

	@Override
	public QueryResult<TblMajorClassify> getScrollData(int firstindex,
			int maxresult) {
		
		return tblMajorClassifyDao.getScrollData(firstindex, maxresult);
	}

	@Override
	public QueryResult<Object> getScrollDataByHql(int firstindex,
			int maxresult, String hql, Object[] queryParams) {
		
		return tblMajorClassifyDao.getScrollDataByHql(firstindex, maxresult, hql, queryParams);
	}

	@Override
	public List<Object> getDataByHql(String hql, Object[] queryParams) {
		
		return tblMajorClassifyDao.getDataByHql(hql, queryParams);
	}

	@Override
	public Long getCount(String hql, Object[] queryParams) {
		
		return tblMajorClassifyDao.getCount(hql, queryParams);
	}

}
