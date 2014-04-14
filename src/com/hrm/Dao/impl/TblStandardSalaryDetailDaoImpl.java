package com.hrm.Dao.impl;

import org.springframework.stereotype.Repository;

import com.hrm.Dao.DaoSupport;
import com.hrm.Dao.ITblFirstClassDao;
import com.hrm.Dao.ITblStandardSalaryDao;
import com.hrm.Dao.ITblStandardSalaryDetailDao;
import com.hrm.pojo.TblFirstClass;
import com.hrm.pojo.TblStandardSalary;
import com.hrm.pojo.TblStandardSalaryDetail;
@Repository("TblStandardSalaryDetailDao")
public class TblStandardSalaryDetailDaoImpl extends DaoSupport<TblStandardSalaryDetail> implements ITblStandardSalaryDetailDao
{

}
