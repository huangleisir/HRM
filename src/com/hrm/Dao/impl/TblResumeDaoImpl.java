package com.hrm.Dao.impl;
import org.springframework.stereotype.Repository;

import com.hrm.Dao.DaoSupport;
import com.hrm.Dao.ITblResumeDao;
import com.hrm.pojo.TblResume;
@Repository("TblResumeDao")
public class TblResumeDaoImpl extends DaoSupport<TblResume> implements
		ITblResumeDao {

}
