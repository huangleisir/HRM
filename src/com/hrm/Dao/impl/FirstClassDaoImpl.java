package com.hrm.Dao.impl;
import org.springframework.stereotype.Repository;

import com.hrm.Dao.DaoSupport;
import com.hrm.Dao.FirstClassDao;
import com.hrm.Dao.ITblFirstClassDao;
import com.hrm.pojo.TblFirstClass;
@Repository("FirstClassDaoImpl")
public class FirstClassDaoImpl extends DaoSupport<TblFirstClass> implements
FirstClassDao {

}
