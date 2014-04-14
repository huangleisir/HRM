package com.hrm.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.hrm.pojo.TblUser;
import com.hrm.utils.WebUtils;

/**
 * 权限显示标签
 * 
 * @author pengdaofa
 * 
 */
public class PermissionTag extends TagSupport {
	private String includeName;

	public String getIncludeName() {
		return includeName;
	}

	public void setIncludeName(String includeName) {
		this.includeName = includeName;
	}

	@Override
	public int doStartTag() throws JspException {
		boolean flag;
		TblUser user = WebUtils.getUser();
		if (user == null)
			return SKIP_BODY;
		if (user.getUName().indexOf(includeName) >= 0)
			return EVAL_BODY_INCLUDE;
		return SKIP_BODY; 
	}

}
