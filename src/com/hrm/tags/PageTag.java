package com.hrm.tags;

/*  
 * To change this template, choose Tools | Templates  
 * and open the template in the editor.  
 */

import java.io.UnsupportedEncodingException;

import com.opensymphony.xwork2.util.ValueStack;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

/**
 * 分页标签
 * 
 * @author tangs
 */
public class PageTag extends ComponentTagSupport {

	private String pageNo;
	private String total;
	private String styleClass;
	private String theme;
	private String includes;

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getIncludes() {
		return includes;
	}

	public void setIncludes(String includes) {
		this.includes = includes;
	}

	@Override
	public Component getBean(ValueStack arg0, HttpServletRequest arg1,
			HttpServletResponse arg2) {
		try {
			arg1.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		arg2.setCharacterEncoding("UTF-8");
		return new Pages(arg0, arg1);
	}

	protected void populateParams() {
		super.populateParams();

		Pages pages = (Pages) component;
		pages.setPageNo(pageNo);
		pages.setIncludes(includes);
		pages.setTotal(total);
		pages.setStyleClass(styleClass);
		pages.setTheme(theme);

	}
}
