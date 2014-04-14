package com.hrm.action;

import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.hrm.pojo.TblFirstClass;
import com.hrm.pojo.TblFirstQuestions;
import com.hrm.pojo.TblMajorClassify;
import com.hrm.pojo.TblMajorName;
import com.hrm.pojo.TblSecondClass;
import com.hrm.pojo.TblSecondQuestions;
import com.hrm.pojo.TblThirdClass;
import com.hrm.service.ITblFirstClassService;
import com.hrm.service.ITblFirstQuestionsService;
import com.hrm.service.ITblMajorClassifyService;
import com.hrm.service.ITblMajorNameService;
import com.hrm.service.ITblSecondClassService;
import com.hrm.service.ITblSecondQuestionsService;
import com.hrm.service.ITblThirdClassService;
import com.opensymphony.xwork2.ActionSupport;
@Scope("prototype")
@Controller("BindQustionAction")
public class BindQustionAction extends ActionSupport {
	@Autowired
	private ITblFirstQuestionsService tblFirstQuestionsService;
	@Autowired
	private ITblSecondQuestionsService tblSecondQuestionsService;
	
	private String firstQust;
	private String secondQuest;
	
	private String fqid;
	
	public String bindFirst(){
		
		List<TblFirstQuestions> fqlist=tblFirstQuestionsService.getScrollData(-1, -1).getResultlist();
		JSONArray arr=JSONArray.fromObject(fqlist);
		this.setFirstQust(arr.toString());
		return SUCCESS;
	}
	public String bindSecond(){
		List<TblSecondQuestions> fkList=tblSecondQuestionsService.getScrollData(-1, -1, "o.firstKindId = ?", new Object[]{fqid}).getResultlist();
		JSONArray jsonFklist=JSONArray.fromObject(fkList);
		secondQuest=jsonFklist.toString();
		return SUCCESS;
	}
	
	
	public String getFirstQust() {
		return firstQust;
	}

	public void setFirstQust(String firstQust) {
		this.firstQust = firstQust;
	}

	public String getSecondQuest() {
		return secondQuest;
	}

	public void setSecondQuest(String secondQuest) {
		this.secondQuest = secondQuest;
	}
	public String getFqid() {
		return fqid;
	}
	public void setFqid(String fqid) {
		this.fqid = fqid;
	}
	
	
	
}
