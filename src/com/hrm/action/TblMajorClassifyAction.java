package com.hrm.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.hrm.Dao.QueryResult;
import com.hrm.pojo.TblMajorClassify;
import com.hrm.service.ITblMajorClassifyService;
import com.hrm.service.ITblMajorNameService;
import com.hrm.utils.Pager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Scope("prototype")
@Controller("TblMajorClassifyAction")
public class TblMajorClassifyAction extends ActionSupport implements ModelDriven {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;
	@Autowired
	private ITblMajorClassifyService tblMajorClassifyService;
	@Autowired
	private ITblMajorNameService tblMajorNameService;
	//一级机构表实体对象
	private TblMajorClassify tblMajorClassify;
	public TblMajorClassify getTblMajorClassify() {
		return tblMajorClassify;
	}
	public void setTblMajorClassify(TblMajorClassify tblMajorClassify) {
		this.tblMajorClassify = tblMajorClassify;
	}
	//表实体对象的集合
	private QueryResult<TblMajorClassify> tblMajorClassifyList;   
	private Pager<TblMajorClassify> page;
    
    public Pager<TblMajorClassify> getPage() {
		return page;
	}
    @Autowired
	public void setPage(Pager<TblMajorClassify> page) {
		this.page = page;
	}
	//根据ID查找
	public String findById(){
		tblMajorClassify=tblMajorClassifyService.find(tblMajorClassify.getMfkId());
		return "find";
	}
	//新增
	public String save(){
		tblMajorClassifyService.save(tblMajorClassify);
		return "success";
	}

	//修改
	public String update(){
		tblMajorClassifyService.update(tblMajorClassify);
		return SUCCESS;
	}
	public String modify(){
		this.setTblMajorClassify(tblMajorClassifyService.find(tblMajorClassify.getMfkId()));
		return "modify";
	}
	//删除
	public String delete(){	
		tblMajorClassifyService.delete(tblMajorClassifyService.find(tblMajorClassify.getMfkId()));
		return SUCCESS;
	}
	//分页
	public String spliter(){
		QueryResult<TblMajorClassify> result=tblMajorClassifyService.getScrollData((page.getPageNo()-1)*page.getPageSize(), page.getPageSize());
		
		//设置分页查询结果集
		page.setList(result.getResultlist());
		
		//设置总记录
        page.setTotal((int)result.getTotalrecord());
        
        //设置分页总页数
        page.setTotalPage();
		return "spliter";
	}
	//查找所有
	public String findAll(){
		setTblMajorClassifyList(tblMajorClassifyService.getScrollData(-1, -1));
		return "success";
	}
	@Override
	public Object getModel() {
		return page;
	}
	public QueryResult<TblMajorClassify> getTblMajorClassifyList() {
		return tblMajorClassifyList;
	}
	public void setTblMajorClassifyList(QueryResult<TblMajorClassify> tblMajorClassifyList) {
		this.tblMajorClassifyList = tblMajorClassifyList;
	}
	

}
