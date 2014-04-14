package com.hrm.Dao.impl;

import org.springframework.stereotype.Repository;

import com.hrm.Dao.DaoSupport;
import com.hrm.Dao.HumanDao;
import com.hrm.pojo.TblHuman;
@Repository("HumanDaoImpl")
public class HumanDaoImpl extends DaoSupport<TblHuman> implements HumanDao {
}
