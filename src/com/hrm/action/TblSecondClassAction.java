package com.hrm.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Controller;

import com.hrm.Dao.QueryResult;
import com.hrm.pojo.TblSecondClass;
import com.hrm.pojo.TblThirdClass;
import com.hrm.service.ITblSecondClassService;
import com.hrm.service.ITblThirdClassService;
import com.hrm.utils.Pager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Scope("prototype")
@Controller("TblSecondClassAction")
public class TblSecondClassAction extends ActionSupport implements ModelDriven{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	@Autowired
	private ITblSecondClassService tblSecondClassService;
	@Autowired
	private ITblThirdClassService tblThirdClassService;
	//二级机构表表实体对象
	private TblSecondClass tblSecondClass;
	//三级机构表表实体对象
		private TblThirdClass tblThirdClass;
	//实体对象的集合
	private QueryResult<TblSecondClass> tblSecondClassList;
    private Pager<TblSecondClass> page;
    
    public Pager<TblSecondClass> getPage() {
		return page;
	}
    @Autowired
	public void setPage(Pager<TblSecondClass> page) {
		this.page = page;
	}
	//根据ID查找
	public String findById(){
		tblSecondClass=tblSecondClassService.find(tblSecondClass.getFskId());
		return "find";
	}
	//查找所有
	public String findAll(){
		tblSecondClassList=tblSecondClassService.getScrollData(-1, -1);
		return "success";
	}
	//新增
	public String save(){
		tblSecondClassService.save(tblSecondClass);
		return "success";
	}

	//修改
	public String update(){
		tblSecondClassService.update(tblSecondClass);		
		return SUCCESS;
	}
	public String modify(){
		this.setTblSecondClass(tblSecondClassService.find(tblSecondClass.getFskId()));
		return "modify";
	}
	//删除
	public String delete(){	
		tblSecondClassService.delete(tblSecondClassService.find(tblSecondClass.getFskId()));
		return SUCCESS;
	}
	//分页
	public String spliter(){
		QueryResult<TblSecondClass> result=tblSecondClassService.getScrollData((page.getPageNo()-1)*page.getPageSize(), page.getPageSize());
		
		//设置分页查询结果集
		page.setList(result.getResultlist());
		
		//设置总记录
        page.setTotal((int)result.getTotalrecord());
        
        //设置分页总页数
        page.setTotalPage();
		return "spliter";
	}	
	public TblSecondClass getTblSecondClass() {
		return tblSecondClass;
	}
	public void setTblSecondClass(TblSecondClass tblSecondClass) {
		this.tblSecondClass = tblSecondClass;
	}
	@Override
	public Object getModel() {
		return page;
	}
	public QueryResult<TblSecondClass> getTblSecondClassList() {
		return tblSecondClassList;
	}
	public void setTblSecondClassList(QueryResult<TblSecondClass> tblSecondClassList) {
		this.tblSecondClassList = tblSecondClassList;
	}
	public TblThirdClass getTblThirdClass() {
		return tblThirdClass;
	}
	public void setTblThirdClass(TblThirdClass tblThirdClass) {
		this.tblThirdClass = tblThirdClass;
	}
	

}
