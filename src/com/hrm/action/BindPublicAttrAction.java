package com.hrm.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hrm.pojo.TblPublicAttribute;
import com.hrm.service.ITblPublicAttributeService;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("BindPublicAttrAction")
public class BindPublicAttrAction extends ActionSupport {
	
	@Autowired
	private ITblPublicAttributeService tblPublicAttributeService;
	
	private TblPublicAttribute tblPublicAttribute;
	
	private List<TblPublicAttribute> attrList;
	
	public String bind(){
		
		attrList=tblPublicAttributeService.getScrollData(-1, -1).getResultlist();
		
		return SUCCESS;
	}


	public TblPublicAttribute getTblPublicAttribute() {
		return tblPublicAttribute;
	}


	public void setTblPublicAttribute(TblPublicAttribute tblPublicAttribute) {
		this.tblPublicAttribute = tblPublicAttribute;
	}


	public List<TblPublicAttribute> getAttrList() {
		return attrList;
	}


	public void setAttrList(List<TblPublicAttribute> attrList) {
		this.attrList = attrList;
	}
	
}
