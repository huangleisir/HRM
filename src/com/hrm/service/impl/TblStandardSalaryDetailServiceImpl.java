package com.hrm.service.impl;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrm.Dao.QueryResult;
import com.hrm.Dao.ITblStandardSalaryDetailDao;
import com.hrm.pojo.TblStandardSalaryDetail;
import com.hrm.pojo.TblStandardSalaryDetail;
import com.hrm.service.ITblStandardSalaryDetailService;
import com.hrm.service.ITblStandardSalaryService;
/**
 * 
	 * 文件名：薪酬标准Service实现
	 * 日期：2013.11.5
	 * 版权：xxx
	 * 开发者：许生云
 */
@Service("TblStandardSalaryDetailService")
public class TblStandardSalaryDetailServiceImpl implements ITblStandardSalaryDetailService{
	@Autowired
	private ITblStandardSalaryDetailDao tblStandardSalaryDetailDao;
/*
 * 获取总记录数
 * @see com.hrm.service.TblStandardSalaryService#getCount()
 */
	@Override
	public long getCount() {
		return tblStandardSalaryDetailDao.getCount();
	}
	/*
	 * 添加
	 * @see com.hrm.service.TblStandardSalaryService#getCount()
	 */
	@Override
	public void save(TblStandardSalaryDetail entity) {
		tblStandardSalaryDetailDao.save(entity);
	}
	/*
	 * 更新
	 * @see com.hrm.service.TblStandardSalaryService#getCount()
	 */
	@Override
	public void update(TblStandardSalaryDetail entity) {
		tblStandardSalaryDetailDao.update(entity);
		
	}
	/*
	 * 删除
	 * @see com.hrm.service.TblStandardSalaryService#getCount()
	 */
	@Override
	public void delete(TblStandardSalaryDetail entity) {
		tblStandardSalaryDetailDao.delete(entity);
		
	}
	/*
	 * 查询
	 * @see com.hrm.service.TblStandardSalaryService#getCount()
	 */
	@Override
	public TblStandardSalaryDetail find(Serializable entityId) {
		
		return tblStandardSalaryDetailDao.find(entityId);
	}
	/*
	 * 根据条件查询
	 * @see com.hrm.service.TblStandardSalaryService#getCount()
	 */
	@Override
	public QueryResult<TblStandardSalaryDetail> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams,
			LinkedHashMap<String, String> orderby) {
		
		return tblStandardSalaryDetailDao.getScrollData(firstindex, maxresult, whereHql, queryParams,orderby);
	}
	/*
	 * 根据条件查询
	 * @see com.hrm.service.TblStandardSalaryService#getCount()
	 */
	@Override
	public QueryResult<TblStandardSalaryDetail> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams) {
		// TODO Auto-generated method stub
		return tblStandardSalaryDetailDao.getScrollData(firstindex, maxresult, whereHql, queryParams);
	}
	/*
	 * 根据条件查询
	 * @see com.hrm.service.TblStandardSalaryService#getCount()
	 */
	@Override
	public QueryResult<TblStandardSalaryDetail> getScrollData(int firstindex,
			int maxresult, LinkedHashMap<String, String> orderby) {
		return tblStandardSalaryDetailDao.getScrollData(firstindex, maxresult,orderby);
	}
	/*
	 * 根据条件查询
	 * @see com.hrm.service.TblStandardSalaryService#getCount()
	 */
	@Override
	public QueryResult<TblStandardSalaryDetail> getScrollData(int firstindex,
			int maxresult) {
		return tblStandardSalaryDetailDao.getScrollData(firstindex, maxresult);
	}
	/*
	 * 根据条件查询
	 * @see com.hrm.service.TblStandardSalaryService#getCount()
	 */
	@Override
	public QueryResult<Object> getScrollDataByHql(int firstindex,
			int maxresult, String hql, Object[] queryParams) {
		// TODO Auto-generated method stub
		return tblStandardSalaryDetailDao.getScrollDataByHql(firstindex, maxresult, hql, queryParams);
	}
	/*
	 * 查询结果给集合
	 * @see com.hrm.service.TblStandardSalaryService#getCount()
	 */
	@Override
	public List<Object> getDataByHql(String hql, Object[] queryParams) {
		// TODO Auto-generated method stub
		return tblStandardSalaryDetailDao.getDataByHql(hql, queryParams);
	}
	/*
	 * 查询多少条
	 * @see com.hrm.service.TblStandardSalaryService#getCount()
	 */
	@Override
	public Long getCount(String hql, Object[] queryParams) {
		// TODO Auto-generated method stub
		return tblStandardSalaryDetailDao.getCount(hql, queryParams);
	}

}
