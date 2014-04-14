package com.hrm.action;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.hrm.Dao.QueryResult;
import com.hrm.pojo.TblStandardSalary;
import com.hrm.pojo.TblStandardSalaryDetail;
import com.hrm.pojo.TblStandardSalaryDetail;
import com.hrm.service.ITblStandardSalaryDetailService;
import com.hrm.service.ITblStandardSalaryService;
import com.hrm.utils.Pager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Scope("prototype")
@Controller("TblStandardSalaryDetailAction")
public class TblStandardSalaryDetailAction extends ActionSupport implements ModelDriven{
	/**
	 * 薪酬标准Action
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ITblStandardSalaryDetailService tblStandardSalaryDetailService;
	//表实体对象
	private TblStandardSalaryDetail tblStandardSalaryDetail;
	
	public TblStandardSalaryDetail getTblStandardSalaryDetail() {
		return tblStandardSalaryDetail;
	}
	public void setTblStandardSalaryDetail(TblStandardSalaryDetail tblStandardSalaryDetail) {
		this.tblStandardSalaryDetail = tblStandardSalaryDetail;
	}

	//页数	    
    private Pager<TblStandardSalaryDetail> page;
    LinkedHashMap<String, String> orderby;
	
    public LinkedHashMap<String, String> getOrderby() {
		return orderby;
	}
	public void setOrderby(LinkedHashMap<String, String> orderby) {
		this.orderby = orderby;
	}
	public Pager<TblStandardSalaryDetail> getPage() {
		return page;
	}
    @Autowired
	public void setPage(Pager<TblStandardSalaryDetail> page) {
		this.page = page;
	}
   //sp_check 薪酬设置
    public String sp_check(){
		//LinkedHashMap<"tblStandardSalary.getSsdId()","desc"> orderby;
		//对象ID
	    //String id = (tblStandardSalaryDetail.getSdtId()+"");
		
		QueryResult<TblStandardSalaryDetail> result=tblStandardSalaryDetailService.getScrollData((page.getPageNo()-1)*page.getPageSize(), page.getPageSize());
		//设置分页查询结果集
		page.setList(result.getResultlist());
		//设置总记录
        page.setTotal((int)result.getTotalrecord());
        //orderby LinkedHashMap<要排序的字段, desc/dsc>
        //page.LinkedHashMap<tblStandardSalary.getSsdId(),desc> orderby;
        //page.setOrderby(tblStandardSalary.getSsdId(),"desc/dsc");
        //设置分页总页数
        page.setTotalPage();
		return "sp_check";
		//return "modify";
	} 
      
  /*//查找
  	public String find(){
  		tblStandardSalaryDetail=tblStandardSalaryDetailService.find(1);
  		System.out.println("获取的ID是："+tblStandardSalaryDetail.getSdtId());
  		return "success";
  	}*/
  	
	//根据ID查找
	//根据薪酬名查找
  	public String find(){
  		//name
  		String name = tblStandardSalaryDetail.getStandardName();
  		System.out.println("获取的ID是："+name);
  		String hql = "o.standardName = ?";
  		//String hql = "from TblStandardSalary as o where o.standardName like:name ";
  		//from Subject as s where s.subname like :name and s.subinfo like :info";
  		
  		QueryResult<TblStandardSalaryDetail> rsl=tblStandardSalaryDetailService.getScrollData(-1, -1, hql, new Object[]{name});
  		System.out.println(rsl);
  		page.setList(tblStandardSalaryDetailService.getScrollData(-1, -1, hql, new Object[]{name}).getResultlist());
  	    //设置总记录
        page.setTotal((int)rsl.getTotalrecord());
        //设置分页总页数
        page.setTotalPage();
  		return "find";	
  	}
	
	//新增
	public String save(){
		tblStandardSalaryDetailService.save(tblStandardSalaryDetail);
	     return SUCCESS;
	}
	//修改
	public String update(){
		//System.out.println(tblStandardSalary.getSsdId());
		tblStandardSalaryDetailService.update(tblStandardSalaryDetail);		
		return SUCCESS;
	}
	public String modify(){
		this.setTblStandardSalaryDetail(tblStandardSalaryDetailService.find(tblStandardSalaryDetail.getSdtId()));
		return "modify";
	}
	//删除
	public String delete(){		
		tblStandardSalaryDetailService.delete(tblStandardSalaryDetailService.find(tblStandardSalaryDetail.getSdtId()));
		return SUCCESS;
	}
	//分页
	public String spliter(){
		//LinkedHashMap<"tblStandardSalary.getSsdId()","desc"> orderby;
		//对象ID
	    //String id = (tblStandardSalaryDetail.getSdtId()+"");
		
		QueryResult<TblStandardSalaryDetail> result=tblStandardSalaryDetailService.getScrollData((page.getPageNo()-1)*page.getPageSize(), page.getPageSize());
		//设置分页查询结果集
		page.setList(result.getResultlist());
		//设置总记录
        page.setTotal((int)result.getTotalrecord());
        //orderby LinkedHashMap<要排序的字段, desc/dsc>
        //page.LinkedHashMap<tblStandardSalary.getSsdId(),desc> orderby;
        //page.setOrderby(tblStandardSalary.getSsdId(),"desc/dsc");
        //设置分页总页数
        page.setTotalPage();
		return "spliter";
		//return "modify";
	}	
	
	@Override
	public Object getModel() {
		return page;
	}
}
