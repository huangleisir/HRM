package com.hrm.service.impl;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrm.Dao.ITblFirstClassDao;
import com.hrm.Dao.ITblSecondClassDao;
import com.hrm.Dao.ITblThirdClassDao;
import com.hrm.Dao.QueryResult;
import com.hrm.pojo.TblFirstClass;
import com.hrm.pojo.TblSecondClass;
import com.hrm.pojo.TblThirdClass;
import com.hrm.service.ITblSecondClassService;
@Service("TblSecondClassService")
public class TblSecondClassServiceImpl implements ITblSecondClassService {

	@Autowired
	private ITblSecondClassDao tblSecondClassDao;
	@Autowired
	private ITblThirdClassDao tblThirdClassDao;
	@Override
	public long getCount() {
		// TODO Auto-generated method stub
		return tblSecondClassDao.getCount();
	}

	@Override
	public void save(TblSecondClass entity) {
		// TODO Auto-generated method stub
		tblSecondClassDao.save(entity);
	}

	@Override
	public void update(TblSecondClass entity) {
		//三级表级联修改
		QueryResult<TblThirdClass> resultIII=tblThirdClassDao.getScrollData(-1, -1);
		for(int i=0;i<resultIII.getResultlist().size();i++){
			if(resultIII.getResultlist().get(i).getSecondKindId()==null){
				continue;
			}
			if(resultIII.getResultlist().get(i).getSecondKindId().equals(entity.getSecondKindId())){
				resultIII.getResultlist().get(i).setSecondKindName(entity.getSecondKindName());
				tblThirdClassDao.update(resultIII.getResultlist().get(i));
			}
		}
		tblSecondClassDao.update(entity);
	}

	@Override
	public void delete(TblSecondClass entity) {
		//三级表级联删除
				QueryResult<TblThirdClass> resultIII=tblThirdClassDao.getScrollData(-1, -1);
				for(int i=0;i<resultIII.getResultlist().size();i++){
					if(resultIII.getResultlist().get(i).getSecondKindId()==null){
						continue;
					}
					if(resultIII.getResultlist().get(i).getSecondKindId().equals(entity.getSecondKindId())){
						tblThirdClassDao.delete(resultIII.getResultlist().get(i));
					}
				}
		tblSecondClassDao.delete(entity);
	}

	@Override
	public TblSecondClass find(Serializable entityId) {
		// TODO Auto-generated method stub
		return tblSecondClassDao.find(entityId);
	}

	@Override
	public QueryResult<TblSecondClass> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams,
			LinkedHashMap<String, String> orderby) {
		// TODO Auto-generated method stub
		return tblSecondClassDao.getScrollData(firstindex, maxresult, whereHql, queryParams);
	}

	@Override
	public QueryResult<TblSecondClass> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams) {
		// TODO Auto-generated method stub
		return tblSecondClassDao.getScrollData(firstindex, maxresult, whereHql, queryParams);
	}

	@Override
	public QueryResult<TblSecondClass> getScrollData(int firstindex,
			int maxresult, LinkedHashMap<String, String> orderby) {
		// TODO Auto-generated method stub
		return tblSecondClassDao.getScrollData(firstindex, maxresult, orderby);
	}

	@Override
	public QueryResult<TblSecondClass> getScrollData(int firstindex,
			int maxresult) {
		// TODO Auto-generated method stub
		return tblSecondClassDao.getScrollData(firstindex, maxresult);
	}

	@Override
	public QueryResult<Object> getScrollDataByHql(int firstindex,
			int maxresult, String hql, Object[] queryParams) {
		// TODO Auto-generated method stub
		return tblSecondClassDao.getScrollDataByHql(firstindex, maxresult, hql, queryParams);
	}

	@Override
	public List<Object> getDataByHql(String hql, Object[] queryParams) {
		// TODO Auto-generated method stub
		return tblSecondClassDao.getDataByHql(hql, queryParams);
	}

	@Override
	public Long getCount(String hql, Object[] queryParams) {
		// TODO Auto-generated method stub
		return tblSecondClassDao.getCount(hql, queryParams);
	}

}
