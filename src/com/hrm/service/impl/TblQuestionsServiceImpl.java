package com.hrm.service.impl;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.hrm.Dao.ITblQuestionsDao;
import com.hrm.Dao.QueryResult;
import com.hrm.pojo.TblQuestions;
import com.hrm.service.ITblQuestionsService;
@Scope("prototype")
@Service("TblQuestionsService")
public class TblQuestionsServiceImpl implements ITblQuestionsService {

	@Autowired
	private ITblQuestionsDao tblQuestionsDao;

	@Override
	public long getCount() {
		
		return tblQuestionsDao.getCount();
	}

	@Override
	public void save(TblQuestions entity) {
		tblQuestionsDao.save(entity);

	}

	@Override
	public void update(TblQuestions entity) {
		
		tblQuestionsDao.update(entity);
	}

	@Override
	public void delete(TblQuestions entity) {
		
		tblQuestionsDao.delete(entity);
	}

	@Override
	public TblQuestions find(Serializable entityId) {
		
		return tblQuestionsDao.find(entityId);
	}

	@Override
	public QueryResult<TblQuestions> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams,
			LinkedHashMap<String, String> orderby) {
		
		return tblQuestionsDao.getScrollData(firstindex, maxresult, whereHql, queryParams);
	}

	@Override
	public QueryResult<TblQuestions> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams) {
		
		return tblQuestionsDao.getScrollData(firstindex, maxresult, whereHql, queryParams);
	}

	@Override
	public QueryResult<TblQuestions> getScrollData(int firstindex,
			int maxresult, LinkedHashMap<String, String> orderby) {
		
		return tblQuestionsDao.getScrollData(firstindex, maxresult, orderby);
	}

	@Override
	public QueryResult<TblQuestions> getScrollData(int firstindex,
			int maxresult) {
		
		return tblQuestionsDao.getScrollData(firstindex, maxresult);
	}

	@Override
	public QueryResult<Object> getScrollDataByHql(int firstindex,
			int maxresult, String hql, Object[] queryParams) {
		
		return tblQuestionsDao.getScrollDataByHql(firstindex, maxresult, hql, queryParams);
	}

	@Override
	public List<Object> getDataByHql(String hql, Object[] queryParams) {
		
		return tblQuestionsDao.getDataByHql(hql, queryParams);
	}

	@Override
	public Long getCount(String hql, Object[] queryParams) {
		
		return tblQuestionsDao.getCount(hql, queryParams);
	}

}
