package com.hrm.action;

import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hrm.Dao.QueryResult;
import com.hrm.action.human.aop.Permission;
import com.hrm.pojo.TblResume;
import com.hrm.service.ITblResumeService;
import com.hrm.utils.Pager;
import com.hrm.utils.StringToTimeStamp;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Scope("prototype")
@Controller("TblResumeAction")
public class TblResumeAction extends ActionSupport implements ModelDriven<Pager<TblResume>>{
	
	@Autowired
	private ITblResumeService tblResumeService;
	//表实体
	private TblResume res;
	//分页对象
	private Pager<TblResume> page;
	
	private int query;

	//职位分类ID,用于简历筛选和查询所用
	private String mjkid;
	
	//处理条件分页查询
	private static String mjk="";
	
	public String save(){
		try {
			//新增简历设置面试状态为0(未面试)
			res.setCheckStatus(0);
			res.setInterviewStatus(0);
			res.setPassCheckStatus(0);
			res.setTestAmount(0);
			res.setHumanBirthday(StringToTimeStamp.parse(res.getHumanBirthday()));
			res.setRegistTime(StringToTimeStamp.parse(res.getRegistTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		tblResumeService.save(res);
		
		return SUCCESS;
	}
	
	//简历筛选分页处理
	@Permission(nameInclude = "admin")
	public String spliter(){
		if(mjkid==null||"".equals(mjkid)){}
		else
			mjk=mjkid;
		QueryResult<TblResume> result=tblResumeService.getScrollData((page.getPageNo()-1)*page.getPageSize(),  page.getPageSize(), "o.interviewStatus =0 and o.checkStatus =0 and o.humanMajorKindId = ?", new Object[]{mjk});
		
		//设置分页查询结果集
		page.setList(result.getResultlist());
		
		//设置总记录
        page.setTotal((int)result.getTotalrecord());
        
        //设置分页总页数
        page.setTotalPage();
		return "spliter";
	}

	//简历筛选分页处理
	@Permission(nameInclude = "admin")
	public String valid(){
		if(mjkid==null||"".equals(mjkid)){}
		else
			mjk=mjkid;
		QueryResult<TblResume> result=tblResumeService.getScrollData((page.getPageNo()-1)*page.getPageSize(),  page.getPageSize(), "o.interviewStatus !=-1 and o.checkStatus !=-1 and o.passCheckStatus!=-1 and o.humanMajorKindId = ?", new Object[]{mjk});
		
		//设置分页查询结果集
		page.setList(result.getResultlist());
		
		//设置总记录
        page.setTotal((int)result.getTotalrecord());
        
        //设置分页总页数
        page.setTotalPage();
		return "valid";
	}
	
	
	
	//被推荐面试的简历查询结果(面试登记)
	@Permission(nameInclude = "admin")
	public String validSpliter(){
		if(mjkid==null||"".equals(mjkid)){}
		else
			mjk=mjkid;
		QueryResult<TblResume> result=tblResumeService.getScrollData((page.getPageNo()-1)*page.getPageSize(),  page.getPageSize(), "o.checkStatus = 1 and o.interviewStatus !=1 and o.humanMajorKindId = ?", new Object[]{mjk});
		
		//设置分页查询结果集
		page.setList(result.getResultlist());
		
		//设置总记录
        page.setTotal((int)result.getTotalrecord());
        
        //设置分页总页数
        page.setTotalPage();
		return "validSpliter";
	}
	
	//筛选(按id查询)
	@Permission(nameInclude = "admin")
	public String check(){
		
		/*if(res.getCheckStatus()==1)	{	
			res=tblResumeService.find(res.getResId());
			return "interview";
		}
		if(res.getCheckStatus()==2)	{	
			res=tblResumeService.find(res.getResId());
			return "registCheck";
		}*/
		if(query==1){
			res=tblResumeService.find(res.getResId());
			return "interview";
		}
		
		res=tblResumeService.find(res.getResId());
		return "check";
	}
	//更新
	@Permission(nameInclude = "admin")
	public String update(){
		TblResume entity=tblResumeService.find(res.getResId());
		try {
			res.setPassCheckStatus(entity.getPassCheckStatus());
			res.setHumanMajorId(entity.getHumanMajorId());
			res.setHumanMajorName(entity.getHumanMajorName());
			res.setTestAmount(entity.getTestAmount());
			res.setHumanBirthday(StringToTimeStamp.parse(res.getHumanBirthday()));
			res.setRegistTime(StringToTimeStamp.parse(res.getRegistTime()));
			res.setCheckTime(StringToTimeStamp.parse(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		tblResumeService.update(res);
		
		return SUCCESS;
	}
	
	
	public TblResume getRes() {
		return res;
	}

	public void setRes(TblResume res) {
		this.res = res;
	}


	@Override
	public Pager<TblResume> getModel() {
		return page;
	}

	public Pager<TblResume> getPage() {
		return page;
	}

	@Autowired
	public void setPage(Pager<TblResume> page) {
		this.page = page;
	}

	public String getMjkid() {
		return mjkid;
	}

	public void setMjkid(String mjkid) {
		this.mjkid = mjkid;
	}

	public int getQuery() {
		return query;
	}

	public void setQuery(int query) {
		this.query = query;
	}
	
	
}
