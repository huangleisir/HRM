package com.hrm.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.hrm.Dao.QueryResult;
import com.hrm.pojo.TblFirstClass;
import com.hrm.pojo.TblSecondClass;
import com.hrm.pojo.TblThirdClass;
import com.hrm.service.ITblFirstClassService;
import com.hrm.service.ITblSecondClassService;
import com.hrm.service.ITblThirdClassService;
import com.hrm.utils.Pager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Scope("prototype")//单例性
@Controller("TblFirstClassAction")
public class TblFirstClassAction extends ActionSupport implements ModelDriven {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ITblFirstClassService tblFirstClassService;
	@Autowired
	private ITblSecondClassService tblSecondClassService;
	@Autowired
	private ITblThirdClassService tblThirdClassService;
	//一级机构表实体对象
	private TblFirstClass tblFirstClass;
	//二级机构表实体对象
	private TblSecondClass tblSecondClass;
	//三级机构表实体对象
	private TblThirdClass tblThirdClass;
	//表实体对象的集合
	private QueryResult<TblFirstClass> tblFirstClassList;   
    public QueryResult<TblFirstClass> getTblFirstClassList() {
		return tblFirstClassList;
	}
	public void setTblFirstClassList(QueryResult<TblFirstClass> tblFirstClassList) {
		this.tblFirstClassList = tblFirstClassList;
	}
	private Pager<TblFirstClass> page;
    
    public Pager<TblFirstClass> getPage() {
		return page;
	}
    @Autowired
	public void setPage(Pager<TblFirstClass> page) {
		this.page = page;
	}
	//根据ID查找
	public String findById(){
		tblFirstClass=tblFirstClassService.find(tblFirstClass.getFfkId());
		return "find";
	}
	
	//新增
	public String save(){
		tblFirstClassService.save(tblFirstClass);
		return "success";
	}

	//修改
	public String update(){
		tblFirstClassService.update(tblFirstClass);
		return "success";
	}
	public String modify(){
		this.setTblFirstClass(tblFirstClassService.find(tblFirstClass.getFfkId()));
		return "modify";
	}
	//删除
	public String delete(){	
		tblFirstClassService.delete(tblFirstClassService.find(tblFirstClass.getFfkId()));
		return SUCCESS;
	}
	//分页
	/**
	 * spliter method作用：
	 * @return
	 */
	public String spliter(){
		//将当前页的所有记录西安拿到手     pageNo初始值1 pageSize初始值3
		QueryResult<TblFirstClass> result=tblFirstClassService.getScrollData((page.getPageNo()-1)*page.getPageSize(), page.getPageSize());
		/**
		 * 将结果集，总记录数，总页数封装到page当中
		 * 
		 */
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
		tblFirstClassList=tblFirstClassService.getScrollData(-1, -1);
		return "success";
	}
	public TblFirstClass getTblFirstClass() {
		return tblFirstClass;
	}
	public void setTblFirstClass(TblFirstClass tblFirstClass) {
		this.tblFirstClass = tblFirstClass;
	}
	@Override
	public Object getModel() {
		return page;
	}
	public TblSecondClass getTblSecondClass() {
		return tblSecondClass;
	}
	public void setTblSecondClass(TblSecondClass tblSecondClass) {
		this.tblSecondClass = tblSecondClass;
	}
	public TblThirdClass getTblThirdClass() {
		return tblThirdClass;
	}
	public void setTblThirdClass(TblThirdClass tblThirdClass) {
		this.tblThirdClass = tblThirdClass;
	}
}
