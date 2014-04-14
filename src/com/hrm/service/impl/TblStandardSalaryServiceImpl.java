package com.hrm.service.impl;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrm.Dao.QueryResult;
import com.hrm.Dao.ITblStandardSalaryDao;
import com.hrm.pojo.TblStandardSalary;
import com.hrm.service.ITblStandardSalaryService;
/**
 * 
	 * 文件名：薪酬标准Service实现
	 * 日期：2013.11.5
	 * 版权：xxx
	 * 开发者：许生云
 */
@Service("TblStandardSalaryService")
public class TblStandardSalaryServiceImpl implements ITblStandardSalaryService{
	@Autowired
	private ITblStandardSalaryDao tblStandardSalaryDao;
/*
 * 获取总记录数
 * @see com.hrm.service.TblStandardSalaryService#getCount()
 */
	@Override
	public long getCount() {
		return tblStandardSalaryDao.getCount();
	}
	/*
	 * 添加
	 * @see com.hrm.service.TblStandardSalaryService#getCount()
	 */
	@Override
	public void save(TblStandardSalary entity) {
		tblStandardSalaryDao.save(entity);
	}
	/*
	 * 更新
	 * @see com.hrm.service.TblStandardSalaryService#getCount()
	 */
	@Override
	public void update(TblStandardSalary entity) {
		tblStandardSalaryDao.update(entity);
		
	}
	/*
	 * 删除
	 * @see com.hrm.service.TblStandardSalaryService#getCount()
	 */
	@Override
	public void delete(TblStandardSalary entity) {
		
		tblStandardSalaryDao.delete(entity);
		
	}
	/*
	 * 查询
	 * @see com.hrm.service.TblStandardSalaryService#getCount()
	 */
	@Override
	public TblStandardSalary find(Serializable entityId) {
		
		return tblStandardSalaryDao.find(entityId);
	}
	/*
	 * 根据条件查询
	 * @see com.hrm.service.TblStandardSalaryService#getCount()
	 */
	@Override
	public QueryResult<TblStandardSalary> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams,
			LinkedHashMap<String, String> orderby) {
		
		return tblStandardSalaryDao.getScrollData(firstindex, maxresult, whereHql, queryParams,orderby);
	}
	/*
	 * 根据条件查询
	 * @see com.hrm.service.TblStandardSalaryService#getCount()
	 */
	@Override
	public QueryResult<TblStandardSalary> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams) {
		// TODO Auto-generated method stub
		return tblStandardSalaryDao.getScrollData(firstindex, maxresult, whereHql, queryParams);
	}
	/*
	 * 根据条件查询
	 * @see com.hrm.service.TblStandardSalaryService#getCount()
	 */
	@Override
	public QueryResult<TblStandardSalary> getScrollData(int firstindex,
			int maxresult, LinkedHashMap<String, String> orderby) {
		return tblStandardSalaryDao.getScrollData(firstindex, maxresult,orderby);
	}
	/*
	 * 根据条件查询
	 * @see com.hrm.service.TblStandardSalaryService#getCount()
	 */
	@Override
	public QueryResult<TblStandardSalary> getScrollData(int firstindex,
			int maxresult) {
		return tblStandardSalaryDao.getScrollData(firstindex, maxresult);
	}
	/*
	 * 根据条件查询
	 * @see com.hrm.service.TblStandardSalaryService#getCount()
	 */
	@Override
	public QueryResult<Object> getScrollDataByHql(int firstindex,
			int maxresult, String hql, Object[] queryParams) {
		// TODO Auto-generated method stub
		return tblStandardSalaryDao.getScrollDataByHql(firstindex, maxresult, hql, queryParams);
	}
	/*
	 * 查询结果给集合
	 * @see com.hrm.service.TblStandardSalaryService#getCount()
	 */
	@Override
	public List<Object> getDataByHql(String hql, Object[] queryParams) {
		// TODO Auto-generated method stub
		return tblStandardSalaryDao.getDataByHql(hql, queryParams);
	}
	/*
	 * 查询多少条
	 * @see com.hrm.service.TblStandardSalaryService#getCount()
	 */
	@Override
	public Long getCount(String hql, Object[] queryParams) {
		// TODO Auto-generated method stub
		return tblStandardSalaryDao.getCount(hql, queryParams);
	}

}
