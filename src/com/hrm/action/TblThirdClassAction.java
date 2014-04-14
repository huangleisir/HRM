package com.hrm.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.hrm.Dao.QueryResult;
import com.hrm.action.human.aop.Permission;
import com.hrm.pojo.TblFirstClass;
import com.hrm.pojo.TblThirdClass;
import com.hrm.service.ITblFirstClassService;
import com.hrm.service.ITblThirdClassService;
import com.hrm.utils.Pager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Scope("prototype")
@Controller("TblThirdClassAction")
public class TblThirdClassAction extends ActionSupport implements ModelDriven {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	@Autowired
	private ITblThirdClassService tblThirdClassService;
	//表实体对象
	private TblThirdClass tblThirdClass;  
	//实现分页
	private Pager<TblThirdClass> page;
    
    public Pager<TblThirdClass> getPage() {
		return page;
	}
    @Autowired
	public void setPage(Pager<TblThirdClass> page) {
		this.page = page;
	}
	//根据ID查找
	@Permission(nameInclude = "admin")
	public String findById(){
		tblThirdClass=tblThirdClassService.find(tblThirdClass.getFtkId());
		return "find";
	}
	
	//新增
	@Permission(nameInclude = "admin")
	public String save(){
		tblThirdClassService.save(tblThirdClass);
		return "success";
	}

	//修改
	@Permission(nameInclude = "admin")
	public String update(){
		tblThirdClassService.update(tblThirdClass);		
		return SUCCESS;
	}
	@Permission(nameInclude = "admin")
	public String modify(){
		this.setTblThirdClass(tblThirdClassService.find(tblThirdClass.getFtkId()));
		return "modify";
	}
	//删除
	@Permission(nameInclude = "admin")
	public String delete(){		
		tblThirdClassService.delete(tblThirdClassService.find(tblThirdClass.getFtkId()));
		return SUCCESS;
	}
	//分页
	@Permission(nameInclude = "admin")
	public String spliter(){
		QueryResult<TblThirdClass> result=tblThirdClassService.getScrollData((page.getPageNo()-1)*page.getPageSize(), page.getPageSize());
		
		//设置分页查询结果集
		page.setList(result.getResultlist());
		
		//设置总记录
        page.setTotal((int)result.getTotalrecord());
        
        //设置分页总页数
        page.setTotalPage();
		return "spliter";
	}
	public TblThirdClass getTblThirdClass() {
		return tblThirdClass;
	}
	public void setTblThirdClass(TblThirdClass tblThirdClass) {
		this.tblThirdClass = tblThirdClass;
	}
	@Override
	public Object getModel() {
		return page;
	}
}
