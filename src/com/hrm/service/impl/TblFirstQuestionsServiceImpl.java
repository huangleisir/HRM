package com.hrm.service.impl;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.hrm.Dao.ITblFirstQuestionsDao;
import com.hrm.Dao.QueryResult;
import com.hrm.pojo.TblFirstQuestions;
import com.hrm.service.ITblFirstQuestionsService;
@Scope("prototype")
@Service("TblFirstQuestionsService")
public class TblFirstQuestionsServiceImpl implements ITblFirstQuestionsService {

	@Autowired
	private ITblFirstQuestionsDao tblFirstQuestionsDao;

	@Override
	public long getCount() {
		
		return tblFirstQuestionsDao.getCount();
	}

	@Override
	public void save(TblFirstQuestions entity) {
		tblFirstQuestionsDao.save(entity);

	}

	@Override
	public void update(TblFirstQuestions entity) {
		
		tblFirstQuestionsDao.update(entity);
	}

	@Override
	public void delete(TblFirstQuestions entity) {
		
		tblFirstQuestionsDao.delete(entity);
	}

	@Override
	public TblFirstQuestions find(Serializable entityId) {
		
		return tblFirstQuestionsDao.find(entityId);
	}

	@Override
	public QueryResult<TblFirstQuestions> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams,
			LinkedHashMap<String, String> orderby) {
		
		return tblFirstQuestionsDao.getScrollData(firstindex, maxresult, whereHql, queryParams);
	}

	@Override
	public QueryResult<TblFirstQuestions> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams) {
		
		return tblFirstQuestionsDao.getScrollData(firstindex, maxresult, whereHql, queryParams);
	}

	@Override
	public QueryResult<TblFirstQuestions> getScrollData(int firstindex,
			int maxresult, LinkedHashMap<String, String> orderby) {
		
		return tblFirstQuestionsDao.getScrollData(firstindex, maxresult, orderby);
	}

	@Override
	public QueryResult<TblFirstQuestions> getScrollData(int firstindex,
			int maxresult) {
		
		return tblFirstQuestionsDao.getScrollData(firstindex, maxresult);
	}

	@Override
	public QueryResult<Object> getScrollDataByHql(int firstindex,
			int maxresult, String hql, Object[] queryParams) {
		
		return tblFirstQuestionsDao.getScrollDataByHql(firstindex, maxresult, hql, queryParams);
	}

	@Override
	public List<Object> getDataByHql(String hql, Object[] queryParams) {
		
		return tblFirstQuestionsDao.getDataByHql(hql, queryParams);
	}

	@Override
	public Long getCount(String hql, Object[] queryParams) {
		
		return tblFirstQuestionsDao.getCount(hql, queryParams);
	}

}
