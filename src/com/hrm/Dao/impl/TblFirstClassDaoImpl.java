package com.hrm.Dao.impl;
import org.springframework.stereotype.Repository;

import com.hrm.Dao.DaoSupport;
import com.hrm.Dao.ITblFirstClassDao;
import com.hrm.pojo.TblFirstClass;
@Repository("TblFirstClassDao")
public class TblFirstClassDaoImpl extends DaoSupport<TblFirstClass> implements
		ITblFirstClassDao {

}
