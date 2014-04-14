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
import com.hrm.service.ITblFirstClassService;

@Service("TblFirstClassService")
public class TblFirstClassServiceImpl implements ITblFirstClassService {

	@Autowired
	private ITblFirstClassDao tblFirstClassDao;
	@Autowired
	private ITblSecondClassDao tblSecondClassDao;
	@Autowired
	private ITblThirdClassDao tblThirdClassDao;
	@Override
	public long getCount() {
		
		return tblFirstClassDao.getCount();
	}

	@Override
	public void save(TblFirstClass entity) {
		tblFirstClassDao.save(entity);

	}

	@Override
	public void update(TblFirstClass entity) {
		/*//级联二级表修改
				QueryResult<TblSecondClass> result=tblSecondClassService.getScrollData(-1, -1);
				for (int i=0;i<result.getResultlist().size();i++){
					//找到二级机构表中与改对象一级机构编号相同的语句，修改其名称为该对象名称
					if(result.getResultlist().get(i).getFirstKindId()==null){
						continue;
					}
					if(tblFirstClass.getFirstKindId().equals(result.getResultlist().get(i).getFirstKindId())){
						result.getResultlist().get(i).setFirstKindName(tblFirstClass.getFirstKindName());
						tblSecondClassService.update(result.getResultlist().get(i));
					}
				}
				//级联三级表修改
				QueryResult<TblThirdClass> resultIII=tblThirdClassService.getScrollData(-1, -1);
				for (int i=0;i<resultIII.getResultlist().size();i++){
					//找到三级机构表中与改对象一级机构编号相同的语句，修改其名称为该对象名称
					System.out.println(resultIII.getResultlist().get(i).getFirstKindId());
					if(resultIII.getResultlist().get(i).getFirstKindId()==null){
						
						continue;
					}
					if(resultIII.getResultlist().get(i).getFirstKindId().equals(tblFirstClass.getFirstKindId())){
						resultIII.getResultlist().get(i).setFirstKindName(tblFirstClass.getFirstKindName());
						tblThirdClassService.update(resultIII.getResultlist().get(i));
					}
				}*/
		//级联二级表修改
		/*   20140409
		  QueryResult<TblSecondClass> result=tblSecondClassDao.getScrollData(-1, -1);
		 
		for (int i=0;i<result.getResultlist().size();i++){
			//找到二级机构表中与改对象一级机构编号相同的语句，修改其名称为该对象名称
			if(result.getResultlist().get(i).getFirstKindId()==null){
				continue;
			}
			if(entity.getFirstKindId().equals(result.getResultlist().get(i).getFirstKindId())){
				result.getResultlist().get(i).setFirstKindName(entity.getFirstKindName());
				tblSecondClassDao.update(result.getResultlist().get(i));
			}
		}
		//级联三级表修改
		QueryResult<TblThirdClass> resultIII=tblThirdClassDao.getScrollData(-1, -1);
		for (int i=0;i<resultIII.getResultlist().size();i++){
			//找到三级机构表中与改对象一级机构编号相同的语句，修改其名称为该对象名称
			System.out.println(resultIII.getResultlist().get(i).getFirstKindId());
			if(resultIII.getResultlist().get(i).getFirstKindId()==null){
				
				continue;
			}
			if(resultIII.getResultlist().get(i).getFirstKindId().equals(entity.getFirstKindId())){
				resultIII.getResultlist().get(i).setFirstKindName(entity.getFirstKindName());
				tblThirdClassDao.update(resultIII.getResultlist().get(i));
			}
		}
		
		*/
		tblFirstClassDao.update(entity);
	}

	@Override
	public void delete(TblFirstClass entity) {
		TblFirstClass f=tblFirstClassDao.find(entity.getFfkId());
		//级联二级表删除
		QueryResult<TblSecondClass> result=tblSecondClassDao.getScrollData(-1, -1);
		for (int i=0;i<result.getResultlist().size();i++){
			//找到二级机构表中与改对象一级机构编号相同的语句，将其id,名称赋null
			if(result.getResultlist().get(i).getFirstKindId()==null){
				continue;
			}
			if(result.getResultlist().get(i).getFirstKindId().equals(f.getFirstKindId())){
				result.getResultlist().get(i).setFirstKindId(null);
				result.getResultlist().get(i).setFirstKindName(null);
				tblSecondClassDao.delete(result.getResultlist().get(i));
			}
		}
		//级联三级表删除
		QueryResult<TblThirdClass> resultIII=tblThirdClassDao.getScrollData(-1, -1);
		for (int i=0;i<resultIII.getResultlist().size();i++){
			//找到三级机构表中与改对象一级机构编号相同的语句，将其id,名称赋null
			if(resultIII.getResultlist().get(i).getFirstKindId()==null){
				continue;
			}
			if(resultIII.getResultlist().get(i).getFirstKindId().equals(f.getFirstKindId())){
				resultIII.getResultlist().get(i).setFirstKindName(null);
				resultIII.getResultlist().get(i).setFirstKindId(null);
				tblThirdClassDao.delete(resultIII.getResultlist().get(i));
			}
		}		
		tblFirstClassDao.delete(tblFirstClassDao.find(entity.getFfkId()));
	}

	@Override
	public TblFirstClass find(Serializable entityId) {
		
		return tblFirstClassDao.find(entityId);
	}

	@Override
	public QueryResult<TblFirstClass> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams,
			LinkedHashMap<String, String> orderby) {
		
		return tblFirstClassDao.getScrollData(firstindex, maxresult, whereHql, queryParams);
	}

	@Override
	public QueryResult<TblFirstClass> getScrollData(int firstindex,
			int maxresult, String whereHql, Object[] queryParams) {
		
		return tblFirstClassDao.getScrollData(firstindex, maxresult, whereHql, queryParams);
	}

	@Override
	public QueryResult<TblFirstClass> getScrollData(int firstindex,
			int maxresult, LinkedHashMap<String, String> orderby) {
		
		return tblFirstClassDao.getScrollData(firstindex, maxresult, orderby);
	}

	@Override
	public QueryResult<TblFirstClass> getScrollData(int firstindex,
			int maxresult) {
		
		return tblFirstClassDao.getScrollData(firstindex, maxresult);
	}

	@Override
	public QueryResult<Object> getScrollDataByHql(int firstindex,
			int maxresult, String hql, Object[] queryParams) {
		
		return tblFirstClassDao.getScrollDataByHql(firstindex, maxresult, hql, queryParams);
	}

	@Override
	public List<Object> getDataByHql(String hql, Object[] queryParams) {
		return tblFirstClassDao.getDataByHql(hql, queryParams);
	}

	@Override
	public Long getCount(String hql, Object[] queryParams) {
		
		return tblFirstClassDao.getCount(hql, queryParams);
	}

}
