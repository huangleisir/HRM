package com.hrm.action;

import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.hrm.pojo.TblFirstClass;
import com.hrm.pojo.TblMajorClassify;
import com.hrm.pojo.TblMajorName;
import com.hrm.pojo.TblSecondClass;
import com.hrm.pojo.TblThirdClass;
import com.hrm.service.ITblFirstClassService;
import com.hrm.service.ITblMajorClassifyService;
import com.hrm.service.ITblMajorNameService;
import com.hrm.service.ITblSecondClassService;
import com.hrm.service.ITblThirdClassService;
import com.opensymphony.xwork2.ActionSupport;
@Scope("prototype")
@Controller("BindAction")
public class BindAction extends ActionSupport {

	@Autowired
	private ITblThirdClassService tblThirdClassService;
	@Autowired
	private ITblSecondClassService tblSecondClassService;
	@Autowired
	private ITblFirstClassService tblFirstClassService;
	@Autowired
	private ITblMajorClassifyService tblMajorClassifyService;
	@Autowired
	private ITblMajorNameService tblMajorNameService;
	
	private String firstKind;
	private String secondKind;
	private String thirdKind;
	private String majorKind;
	private String majorName;
	
	//接收页面传送的一级机构ID
	private String ffkid;
	//接收页面传送的二级机构ID
	private String fskid;
	//接收页面传送的职位类别id
	private String mjkId;
	
	
	public String bindFirst(){
		
		List<TblFirstClass> fkList=tblFirstClassService.getScrollData(-1, -1).getResultlist();
		JSONArray jsonFklist=JSONArray.fromObject(fkList);
		firstKind=jsonFklist.toString();
		return SUCCESS;
	}
	
	public String bindSecond(){
		List<TblSecondClass> fkList=tblSecondClassService.getScrollData(-1, -1, "o.firstKindId = ?", new Object[]{ffkid}).getResultlist();
		JSONArray jsonFklist=JSONArray.fromObject(fkList);
		secondKind=jsonFklist.toString();
		return SUCCESS;
	}
	
	public String bindThird(){
		List<TblThirdClass> fkList=tblThirdClassService.getScrollData(-1, -1,"o.firstKindId =? and o.secondKindId = ?",new Object[]{ffkid,fskid} ).getResultlist();
		JSONArray jsonFklist=JSONArray.fromObject(fkList);
		thirdKind=jsonFklist.toString();
		return SUCCESS;
	}
	
	public String bindMajorKind(){
		List<TblMajorClassify> mcList=tblMajorClassifyService.getScrollData(-1, -1).getResultlist();
		JSONArray jsonMclist=JSONArray.fromObject(mcList);
		majorKind=jsonMclist.toString();
		return SUCCESS;
	}
	public String bindMajorName(){
		List<TblMajorName> mjnlist=tblMajorNameService.getScrollData(-1, -1, "o.majorKindId = ?", new Object[]{mjkId}).getResultlist();
		JSONArray jsonMjnlist=JSONArray.fromObject(mjnlist);
		majorName=jsonMjnlist.toString();
		return SUCCESS;
	}

	public String getFirstKind() {
		return firstKind;
	}

	public void setFirstKind(String firstKind) {
		this.firstKind = firstKind;
	}

	public String getSecondKind() {
		return secondKind;
	}

	public void setSecondKind(String secondKind) {
		this.secondKind = secondKind;
	}

	public String getThirdKind() {
		return thirdKind;
	}

	public void setThirdKind(String thirdKind) {
		this.thirdKind = thirdKind;
	}

	public String getFfkid() {
		return ffkid;
	}

	public void setFfkid(String ffkid) {
		this.ffkid = ffkid;
	}

	public String getFskid() {
		return fskid;
	}

	public void setFskid(String fskid) {
		this.fskid = fskid;
	}

	public String getMajorKind() {
		return majorKind;
	}

	public void setMajorKind(String majorKind) {
		this.majorKind = majorKind;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getMjkId() {
		return mjkId;
	}

	public void setMjkId(String mjkId) {
		this.mjkId = mjkId;
	}
	
}
