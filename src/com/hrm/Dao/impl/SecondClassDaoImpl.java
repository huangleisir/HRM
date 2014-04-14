package com.hrm.Dao.impl;
import org.springframework.stereotype.Repository;

import com.hrm.Dao.DaoSupport;
import com.hrm.Dao.ITblFirstClassDao;
import com.hrm.Dao.SecondClassDao;
import com.hrm.pojo.TblFirstClass;
import com.hrm.pojo.TblSecondClass;
@Repository("SecondClassDaoImpl")
public class SecondClassDaoImpl extends DaoSupport<TblSecondClass> implements
SecondClassDao {

}
