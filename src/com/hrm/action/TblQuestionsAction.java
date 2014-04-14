package com.hrm.action;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hrm.Dao.QueryResult;
import com.hrm.action.human.aop.Permission;
import com.hrm.pojo.TblQuestions;
import com.hrm.pojo.TblResume;
import com.hrm.service.ITblQuestionsService;
import com.hrm.service.ITblResumeService;
import com.hrm.utils.Pager;
import com.hrm.utils.StringToTimeStamp;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Scope("prototype")
@Controller("TblQuestionsAction")
public class TblQuestionsAction extends ActionSupport implements ModelDriven<Pager<TblQuestions>>{
	
	@Autowired
	private ITblQuestionsService tblQuestionsService;
	
	private TblQuestions tblQuestions;


	//分页对象
	private Pager<TblQuestions> page;
	
	//职位分类ID,用于简历筛选和查询所用
	private String fqkid;
	
	//处理条件分页查询
	private static String fqk="";
	@Permission(nameInclude = "admin")
	public String save(){
		try {
			tblQuestions.setRegistTime(StringToTimeStamp.parse(tblQuestions.getRegistTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		tblQuestionsService.save(tblQuestions);
		
		return SUCCESS;
	}
	@Permission(nameInclude = "admin")
	public String regist(){
		return "regist";
	}
	
	@Permission(nameInclude = "admin")
	public String spliter(){
		if(fqkid==null||"".equals(fqkid)){}
		else
			fqk=fqkid;
		QueryResult<TblQuestions> result=tblQuestionsService.getScrollData((page.getPageNo()-1)*page.getPageSize(),  page.getPageSize(), "o.firstKindId = ?", new Object[]{fqk});
		
		//设置分页查询结果集
		page.setList(result.getResultlist());
		
		//设置总记录
        page.setTotal((int)result.getTotalrecord());
        
        //设置分页总页数
        page.setTotalPage();
		
		return "spliter";
	}
	@Permission(nameInclude = "admin")
	public String check(){
		
		tblQuestions=tblQuestionsService.find(tblQuestions.getSubId());
		
		return "check";
	}
	@Permission(nameInclude = "admin")
	public String update(){
		
		TblQuestions quest=tblQuestionsService.find(tblQuestions.getSubId());
		
		try {
			BeanUtils.copyProperties(quest, tblQuestions);
			quest.setRegistTime(StringToTimeStamp.parse(tblQuestions.getRegistTime()));
			quest.setChangeTime(StringToTimeStamp.parse(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		tblQuestionsService.update(quest);
		return SUCCESS;
	}
	
	public TblQuestions getTblQuestions() {
		return tblQuestions;
	}

	public void setTblQuestions(TblQuestions tblQuestions) {
		this.tblQuestions = tblQuestions;
	}

	public String getFqkid() {
		return fqkid;
	}

	public void setFqkid(String fqkid) {
		this.fqkid = fqkid;
	}

	@Autowired
	public void setPage(Pager<TblQuestions> page) {
		this.page = page;
	}

	@Override
	public Pager<TblQuestions> getModel() {
		return page;
	}

	
	
	
}
