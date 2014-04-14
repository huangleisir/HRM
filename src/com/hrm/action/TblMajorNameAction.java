package com.hrm.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.hrm.Dao.QueryResult;
import com.hrm.action.human.aop.Permission;
import com.hrm.pojo.TblFirstClass;
import com.hrm.pojo.TblMajorName;
import com.hrm.pojo.TblSecondClass;
import com.hrm.pojo.TblThirdClass;
import com.hrm.service.ITblFirstClassService;
import com.hrm.service.ITblMajorNameService;
import com.hrm.service.ITblSecondClassService;
import com.hrm.service.ITblThirdClassService;
import com.hrm.utils.Pager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("TblMajorNameAction")
public class TblMajorNameAction extends ActionSupport implements ModelDriven {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	@Autowired
	private ITblMajorNameService tblMajorNameService;
	//一级机构表实体对象
	private TblMajorName tblMajorName;
	//表实体对象的集合
	private QueryResult<TblMajorName> tblMajorNameList;   
	private Pager<TblMajorName> page;
    
    public Pager<TblMajorName> getPage() {
		return page;
	}
    @Autowired
	public void setPage(Pager<TblMajorName> page) {
		this.page = page;
	}
	//根据ID查找
	@Permission(nameInclude = "admin")
	public String findById(){
		tblMajorName=tblMajorNameService.find(tblMajorName.getMakId());
		return "find";
	}
	
	//新增
	@Permission(nameInclude = "admin")
	public String save(){
		tblMajorNameService.save(tblMajorName);
		return "success";
	}

	//修改
	@Permission(nameInclude = "admin")
	public String update(){
		tblMajorNameService.update(tblMajorName);
		return SUCCESS;
	}
	@Permission(nameInclude = "admin")
	public String modify(){
		this.setTblMajorName(tblMajorNameService.find(tblMajorName.getMakId()));
		return "modify";
	}
	//删除
	@Permission(nameInclude = "admin")
	public String delete(){	
		TblMajorName f=tblMajorNameService.find(tblMajorName.getMakId());
		tblMajorNameService.delete(tblMajorNameService.find(tblMajorName.getMakId()));
		return SUCCESS;
	}
	//分页
	@Permission(nameInclude = "admin")
	public String spliter(){
		QueryResult<TblMajorName> result=tblMajorNameService.getScrollData((page.getPageNo()-1)*page.getPageSize(), page.getPageSize());
		
		//设置分页查询结果集
		page.setList(result.getResultlist());
		
		//设置总记录
        page.setTotal((int)result.getTotalrecord());
        
        //设置分页总页数
        page.setTotalPage();
		return "spliter";
	}
	//查找所有
	
	@Permission(nameInclude = "admin")
	public String findAll(){
		setTblMajorNameList(tblMajorNameService.getScrollData(-1, -1));
		return "success";
	}
	@Override
	public Object getModel() {
		return page;
	}
	public TblMajorName getTblMajorName() {
		return tblMajorName;
	}
	public void setTblMajorName(TblMajorName tblMajorName) {
		this.tblMajorName = tblMajorName;
	}
	public QueryResult<TblMajorName> getTblMajorNameList() {
		return tblMajorNameList;
	}
	public void setTblMajorNameList(QueryResult<TblMajorName> tblMajorNameList) {
		this.tblMajorNameList = tblMajorNameList;
	}

}
