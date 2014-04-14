package com.hrm.Dao.impl;
import org.springframework.stereotype.Repository;

import com.hrm.Dao.DaoSupport;
import com.hrm.Dao.ITblPositionReleaseDao;
import com.hrm.pojo.TblPositionRelease;

@Repository("TblPositionReleaseDao")
public class TblPositionReleaseDaoImpl extends DaoSupport< TblPositionRelease> implements
		ITblPositionReleaseDao {
}
