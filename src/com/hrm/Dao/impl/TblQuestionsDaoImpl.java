package com.hrm.Dao.impl;
import org.springframework.stereotype.Repository;

import com.hrm.Dao.DaoSupport;
import com.hrm.Dao.ITblQuestionsDao;
import com.hrm.pojo.TblQuestions;
@Repository("TblQuestionsDao")
public class TblQuestionsDaoImpl extends DaoSupport<TblQuestions> implements
		ITblQuestionsDao {

}
