package com.hrm.Dao.impl;
import org.springframework.stereotype.Repository;

import com.hrm.Dao.DaoSupport;
import com.hrm.Dao.ITblFirstClassDao;
import com.hrm.Dao.ThirdClassDao;
import com.hrm.pojo.TblFirstClass;
import com.hrm.pojo.TblThirdClass;
@Repository("ThirdClassDaoImpl")
public class ThirdClassDaoImpl extends DaoSupport<TblThirdClass> implements
ThirdClassDao {

}
