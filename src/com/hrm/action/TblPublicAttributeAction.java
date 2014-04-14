package com.hrm.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.hrm.Dao.QueryResult;
import com.hrm.action.human.aop.Permission;
import com.hrm.pojo.TblFirstClass;
import com.hrm.pojo.TblPublicAttribute;
import com.hrm.pojo.TblSecondClass;
import com.hrm.pojo.TblThirdClass;
import com.hrm.service.ITblFirstClassService;
import com.hrm.service.ITblPublicAttributeService;
import com.hrm.service.ITblSecondClassService;
import com.hrm.service.ITblThirdClassService;
import com.hrm.utils.Pager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("TblPublicAttributeAction")
public class TblPublicAttributeAction extends ActionSupport implements ModelDriven {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	@Autowired
	private ITblPublicAttributeService tblPublicAttributeService;
	//一级机构表实体对象
	private TblPublicAttribute tblPublicAttribute;
	private Pager<TblPublicAttribute> page;
    
    public Pager<TblPublicAttribute> getPage() {
		return page;
	}
    @Autowired
	public void setPage(Pager<TblPublicAttribute> page) {
		this.page = page;
	}
	//根据ID查找
	@Permission(nameInclude = "admin")
	public String findById(){
		tblPublicAttribute=tblPublicAttributeService.find(tblPublicAttribute.getPbcId());
		return "find";
	}
	
	//新增
	@Permission(nameInclude = "admin")
	public String save(){
		tblPublicAttributeService.save(tblPublicAttribute);
		return "success";
	}

	//修改
	@Permission(nameInclude = "admin")
	public String update(){
		tblPublicAttributeService.update(tblPublicAttribute);
		return SUCCESS;
	}
	@Permission(nameInclude = "admin")
	public String modify(){
		this.setTblPublicAttribute(tblPublicAttributeService.find(tblPublicAttribute.getPbcId()));
		return "modify";
	}
	//删除
	@Permission(nameInclude = "admin")
	public String delete(){	
		TblPublicAttribute f=tblPublicAttributeService.find(tblPublicAttribute.getPbcId());		
		tblPublicAttributeService.delete(tblPublicAttributeService.find(tblPublicAttribute.getPbcId()));
		return SUCCESS;
	}
	//分页
	@Permission(nameInclude = "admin")
	public String spliter(){
		QueryResult<TblPublicAttribute> result=tblPublicAttributeService.getScrollData((page.getPageNo()-1)*page.getPageSize(), page.getPageSize());
		
		//设置分页查询结果集
		page.setList(result.getResultlist());
		
		//设置总记录
        page.setTotal((int)result.getTotalrecord());
        
        //设置分页总页数
        page.setTotalPage();
		return "spliter";
	}
	@Override
	public Object getModel() {
		return page;
	}
	public TblPublicAttribute getTblPublicAttribute() {
		return tblPublicAttribute;
	}
	public void setTblPublicAttribute(TblPublicAttribute tblPublicAttribute) {
		this.tblPublicAttribute = tblPublicAttribute;
	}
}
