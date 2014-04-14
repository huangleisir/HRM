package com.hrm.action;

import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.hrm.Dao.QueryResult;
import com.hrm.action.human.aop.Permission;
import com.hrm.pojo.TblInterview;
import com.hrm.pojo.TblResume;
import com.hrm.service.ITblInterviewService;
import com.hrm.service.ITblResumeService;
import com.hrm.utils.Pager;
import com.hrm.utils.StringToTimeStamp;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Scope("prototype")
@Controller("TblInterviewAction")
public class TblInterviewAction extends ActionSupport implements ModelDriven<Pager<TblResume>>{
	
	@Autowired
	private ITblInterviewService tblInterviewService;
	@Autowired
	private ITblResumeService tblreResumeService;
	
	//分页对象
	private Pager<TblResume> page;
	private TblInterview interview;
	private TblResume resume;
	
	//区分查询条件标志
	private int queid;
	
	//职位分类ID,用于简历筛选和查询所用
	private String mjkid;
	
	//处理条件分页查询
	private static String mjk="";
	
	private int op;
	
	//save
	@Permission(nameInclude = "admin")
	public String save(){
		
		//更新面试表时同步更新对应的简历表
		this.setResume((TblResume)(tblreResumeService.getDataByHql("from TblResume where resId = ?", new Object[]{interview.getResumeId()}).get(0)));
		//更新简历状态(已面试)
		resume.setInterviewStatus(1);
		//更新简历表面试次数
		resume.setTestAmount(interview.getInterviewAmount());
		//更新面试人
		resume.setPassRegister(interview.getRegister());
		try {
			resume.setHumanBirthday(StringToTimeStamp.parse(resume.getHumanBirthday()));
			resume.setRegistTime(StringToTimeStamp.parse(resume.getRegistTime()));
			resume.setCheckTime(StringToTimeStamp.parse(resume.getCheckTime()));
			resume.setPassCheckTime(StringToTimeStamp.parse(resume.getPassCheckTime()));
			resume.setTestCheckTime(StringToTimeStamp.parse(resume.getTestCheckTime()));
			
			//设置面试表面试状态为已面试
			interview.setInterviewStatus(1);
			interview.setCheckTime(StringToTimeStamp.parse(interview.getCheckTime()));
			interview.setRegisterTime(StringToTimeStamp.parse(interview.getRegisterTime()));
			resume.setPassRegistTime(interview.getRegisterTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//保存结果到面试表
		tblInterviewService.save(interview);
		tblreResumeService.update(resume);
		return SUCCESS;
	}
	
	//query
	@Permission(nameInclude = "admin")
	public String findById(){
		this.setInterview(tblInterviewService.find(interview.getEinId()));
		return SUCCESS;
	}
	
	//筛选(过滤结果)
	//筛选(按id查询 1面试筛选,2,推荐录用)
	@Permission(nameInclude = "admin")
	public String check(){
		if(queid==1)	{	
			resume=tblreResumeService.find(resume.getResId());
			this.setInterview((TblInterview)(tblInterviewService.getDataByHql("from TblInterview where resumeId = ?", new Object[]{resume.getResId()}).get(0)));
			return "registCheck";
		}
		if(queid==2){
			resume=tblreResumeService.find(resume.getResId());
			this.setInterview((TblInterview)(tblInterviewService.getDataByHql("from TblInterview where resumeId = ?", new Object[]{resume.getResId()}).get(0)));
			return "passCheck";
		}
		resume=tblreResumeService.find(resume.getResId());
		return "check";
	}
	
	//已面试的简历查询结果
	@Permission(nameInclude = "admin")
	public String registedSpliter(){
		if(mjkid==null||"".equals(mjkid)){}
		else
			mjk=mjkid;
		QueryResult<TblResume> result=tblreResumeService.getScrollData((page.getPageNo()-1)*page.getPageSize(),  page.getPageSize(), "o.interviewStatus = 1 and o.passCheckStatus < 1 and o.humanMajorKindId = ?", new Object[]{mjk});
		
		//设置分页查询结果集
		page.setList(result.getResultlist());
		
		//设置总记录
        page.setTotal((int)result.getTotalrecord());
        
        //设置分页总页数
        page.setTotalPage();
		return "registedSpliter";
	}
	
	//已推荐录用的简历查询结果
	@Permission(nameInclude = "admin")
	public String passCheckSpliter(){
		QueryResult<TblResume> result=tblreResumeService.getScrollData((page.getPageNo()-1)*page.getPageSize(),  page.getPageSize(), "o.passCheckStatus = 1",null);
		
		//设置分页查询结果集
		page.setList(result.getResultlist());
		
		//设置总记录
        page.setTotal((int)result.getTotalrecord());
        
        //设置分页总页数
        page.setTotalPage();
		return "passCheckSpliter";
		
	}
	
	//已通过推荐(建议)的简历查询结果
	@Permission(nameInclude = "superadmin")
	public String pass(){
		QueryResult<TblResume> result=tblreResumeService.getScrollData((page.getPageNo()-1)*page.getPageSize(),  page.getPageSize(), "o.passCheckStatus = 2",null);
		
		//设置分页查询结果集
		page.setList(result.getResultlist());
		
		//设置总记录
        page.setTotal((int)result.getTotalrecord());
        
        //设置分页总页数
        page.setTotalPage();
		return "passSpliter";
	}
	
	//录用查询
	@Permission(nameInclude = "superadmin")
	public String passResult(){
		QueryResult<TblResume> result=tblreResumeService.getScrollData((page.getPageNo()-1)*page.getPageSize(),  page.getPageSize(), "o.passCheckStatus = 3",null);
		
		//设置分页查询结果集
		page.setList(result.getResultlist());
		
		//设置总记录
        page.setTotal((int)result.getTotalrecord());
        
        //设置分页总页数
        page.setTotalPage();
		return "passResult";
	}
	
	//面试筛选
	@Permission(nameInclude = "admin")
	public String update(){
		this.setResume((TblResume)(tblreResumeService.getDataByHql("from TblResume where resId = ?", new Object[]{interview.getResumeId()}).get(0)));
		TblInterview iview=(TblInterview)(tblreResumeService.getDataByHql("from TblInterview where resumeId = ?", new Object[]{interview.getResumeId()}).get(0));
	
		switch (op) {
		case 1://建议录用
			//更新简历状态为建议录用
			resume.setPassCheckStatus(1);
			break;
		case 2://建议面试
			resume.setInterviewStatus(0);
			break;
		case 3://建议笔试
			break;
		case 4://删除
			resume.setInterviewStatus(-1);
			resume.setPassCheckStatus(-1);
			resume.setCheckStatus(-1);
			break;
		}
		
		
		//更新面试筛选人
		resume.setPassChecker(interview.getChecker());
		try {
			//转换数据时间
			resume.setHumanBirthday(StringToTimeStamp.parse(resume.getHumanBirthday()));
			resume.setRegistTime(StringToTimeStamp.parse(resume.getRegistTime()));
			resume.setCheckTime(StringToTimeStamp.parse(resume.getCheckTime()));
			resume.setTestCheckTime(StringToTimeStamp.parse(resume.getTestCheckTime()));
			resume.setPassRegistTime(StringToTimeStamp.parse(resume.getPassRegistTime()));
		
			//更新面试表筛选时间/筛选人/录用申请审核意见
			iview.setCheckTime(StringToTimeStamp.parse(interview.getCheckTime()));
			iview.setChecker(interview.getChecker());
			iview.setCheckStatus(1);
			iview.setCheckComment(interview.getCheckComment());
			
			//转换数据时间
			iview.setRegisterTime(StringToTimeStamp.parse(iview.getRegisterTime()));
			
			//更新简历表面试通过时间/录用申请审核意见
			resume.setPassCheckTime(iview.getCheckTime());
			resume.setPassCheckcomment(iview.getCheckComment());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		tblreResumeService.update(resume);
		tblInterviewService.update(iview);
		
		return SUCCESS;
	}
	
	//录用申请
	@Permission(nameInclude = "admin")
	public String passUpdate(){
		TblResume res=(TblResume)(tblreResumeService.getDataByHql("from TblResume where resId = ?", new Object[]{interview.getResumeId()}).get(0));
		TblInterview iview=(TblInterview)(tblreResumeService.getDataByHql("from TblInterview where resumeId = ?", new Object[]{interview.getResumeId()}).get(0));
	
		//更新简历状态为建议录用-审核
		res.setPassCheckStatus(2);
	
		try {
			//转换数据时间
			res.setHumanBirthday(StringToTimeStamp.parse(res.getHumanBirthday()));
			res.setRegistTime(StringToTimeStamp.parse(res.getRegistTime()));
			res.setCheckTime(StringToTimeStamp.parse(res.getCheckTime()));
			res.setTestCheckTime(StringToTimeStamp.parse(res.getTestCheckTime()));
			res.setPassRegistTime(StringToTimeStamp.parse(res.getPassRegistTime()));
			res.setPassCheckTime(StringToTimeStamp.parse(new Date()));
		
			//更新面试表筛选时间/筛选人/录用申请审核意见
			iview.setCheckTime(StringToTimeStamp.parse(iview.getCheckTime()));
			iview.setCheckStatus(2);
			
			//转换数据时间
			iview.setRegisterTime(StringToTimeStamp.parse(iview.getRegisterTime()));
			
			//更新简历表面试通过时间/录用申请审核意见
			res.setPassPasscomment(resume.getPassPasscomment());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		tblreResumeService.update(res);
		tblInterviewService.update(iview);
		
		return "success1";
	}
	
	//录用审批
	@Permission(nameInclude = "superadmin")
	public String passCheck(){
		TblResume res=(TblResume)(tblreResumeService.getDataByHql("from TblResume where resId = ?", new Object[]{resume.getResId()}).get(0));
		//更新简历状态为审核通过
		res.setPassCheckStatus(3);
		try {
			res.setHumanBirthday(StringToTimeStamp.parse(res.getHumanBirthday()));
			res.setRegistTime(StringToTimeStamp.parse(res.getRegistTime()));
			res.setCheckTime(StringToTimeStamp.parse(res.getCheckTime()));
			res.setTestCheckTime(StringToTimeStamp.parse(res.getTestCheckTime()));
			res.setPassRegistTime(StringToTimeStamp.parse(res.getPassRegistTime()));
			res.setPassCheckTime(StringToTimeStamp.parse(res.getPassCheckTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		tblreResumeService.update(res);		
		return "pass";
	}
	
	
	public TblInterview getInterview() {
		return interview;
	}

	public void setInterview(TblInterview interview) {
		this.interview = interview;
	}

	public TblResume getResume() {
		return resume;
	}

	public void setResume(TblResume resume) {
		this.resume = resume;
	}
	@Autowired
	public void setPage(Pager<TblResume> page) {
		this.page = page;
	}

	@Override
	public Pager<TblResume> getModel() {
		return page;
	}
	
	public String getMjkid() {
		return mjkid;
	}

	public void setMjkid(String mjkid) {
		this.mjkid = mjkid;
	}

	public int getQueid() {
		return queid;
	}

	public void setQueid(int queid) {
		this.queid = queid;
	}

	public int getOp() {
		return op;
	}

	public void setOp(int op) {
		this.op = op;
	}

	
	
	
}
