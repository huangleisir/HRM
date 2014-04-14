package com.hrm.action.human;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hrm.action.human.aop.Permission;
import com.hrm.pojo.TblHuman;
import com.hrm.service.HumanServer;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("HumanAddAction")
@Scope("prototype")                 //you could baidu "ModelDriven" and know more specification
public class HumanAddAction extends ActionSupport implements ModelDriven<TblHuman> ,SessionAware { 
	private Map<String, Object> sessionMap;
	private TblHuman tblHuman = new TblHuman(); // modelDriven记录页面数据
	@Resource(name = "HumanServerImpl")
	private HumanServer humanServer; // 注入业务对象

	/* 保存 */
	@Permission(nameInclude = "admin")
	public String doSave() {
		System.out.println("dosave");
		return SUCCESS;
	}

	@Override
	public TblHuman getModel() {
		return tblHuman;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		sessionMap=map;
		
		for(String key:sessionMap.keySet())
		System.out.println(key +" " +map.get(key));  
	}

}
