package com.hrm.service.impl;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.hrm.Dao.ITblSecondQuestionsDao;
import com.hrm.Dao.QueryResult;
import com.hrm.pojo.TblSecondQuestions;
import com.hrm.service.ITblSecondQuestionsService;
@Scope("prototype")
@Service("TblSecondQuestionsService")
public class TblSecondQuestionsServiceImpl implements ITblSecondQuestionsService {

	@Autowired
	private ITblSecondQuestionsDao tblSecondQuestionsDao;

	@Override
	public long getCount() {
		
		return tblSecondQuestionsDao.getCount();
	}

	@Override
	public void save(TblSecondQuestions entity) {
		tblSecondQuestionsDao.save(entity);

	}

	@Override
	public void update(TblSecondQuestions entity) {
		
		tblSecondQuestionsDao.update(entity);
	}

	@Override
	public void delete(TblSecondQuestions entity) {
		
		tblSecondQuestionsDao.delete(entity);
	}

	@Override
	public TblSecondQuestions find(Serializable entityId) {
		
		return tblSecondQuestionsDao.find(entityId);
	}

	@Override
	public QueryResult<TblSecondQuestions> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams,
			LinkedHashMap<String, String> orderby) {
		
		return tblSecondQuestionsDao.getScrollData(firstindex, maxresult, whereHql, queryParams);
	}

	@Override
	public QueryResult<TblSecondQuestions> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams) {
		
		return tblSecondQuestionsDao.getScrollData(firstindex, maxresult, whereHql, queryParams);
	}

	@Override
	public QueryResult<TblSecondQuestions> getScrollData(int firstindex,
			int maxresult, LinkedHashMap<String, String> orderby) {
		
		return tblSecondQuestionsDao.getScrollData(firstindex, maxresult, orderby);
	}

	@Override
	public QueryResult<TblSecondQuestions> getScrollData(int firstindex,
			int maxresult) {
		
		return tblSecondQuestionsDao.getScrollData(firstindex, maxresult);
	}

	@Override
	public QueryResult<Object> getScrollDataByHql(int firstindex,
			int maxresult, String hql, Object[] queryParams) {
		
		return tblSecondQuestionsDao.getScrollDataByHql(firstindex, maxresult, hql, queryParams);
	}

	@Override
	public List<Object> getDataByHql(String hql, Object[] queryParams) {
		
		return tblSecondQuestionsDao.getDataByHql(hql, queryParams);
	}

	@Override
	public Long getCount(String hql, Object[] queryParams) {
		
		return tblSecondQuestionsDao.getCount(hql, queryParams);
	}

}
