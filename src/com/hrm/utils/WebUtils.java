package com.hrm.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hrm.pojo.TblUser;

public class WebUtils {
    /**
     * 获取session中的User对象
     * @param httqrequest
     * @return
     */
	public static TblUser getUser(HttpServletRequest httqrequest) {
		HttpSession session= httqrequest.getSession();
		//session.setAttribute("user",new TblUser(0, "delete", "", ""));
		TblUser user= (TblUser) session.getAttribute("tbluser"); 
		return user;
	}
	
	/**
     * 获取session中的User对象
     * @param httqrequest
     * @return
     */
	public static TblUser getUser() {
		TblUser user= getUser(ServletActionContext.getRequest());
		return user;
	}

}
