package com.hrm.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrm.pojo.TblUser;
import com.hrm.utils.WebUtils;

/**
 * 粗粒度权限管理
 */
public class PermissionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public PermissionFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httqrequest=(HttpServletRequest) request;
		System.out.println("进入权限管理过滤器,请求地址："+ httqrequest.getRequestURI());
		HttpSession session= httqrequest.getSession();
		if(isLogin(httqrequest)){ 
			chain.doFilter(request, response);//what is it,baidu? got it.
		}else{
			HttpServletResponse httpResp= (HttpServletResponse) response;
			System.out.println(getContentPath(httqrequest)+"/login.jsp"); 
			httpResp.sendRedirect(getContentPath(httqrequest)+"/login.jsp");
			
		}
		
	}

	/**
	 * 获得url路径
	 * @param httqrequest 
	 * @return
	 */
	private String getContentPath(HttpServletRequest httqrequest) {
		
		return httqrequest.getContextPath(); 
	}

	/**
	 * 判断是否已经登录	
	 * @param httqrequest 
	 * @param httqrequest 
	 * @return
	 */
	private boolean isLogin(HttpServletRequest httqrequest) {
		TblUser user= WebUtils.getUser(httqrequest); 
		if(user==null){
			System.out.println("用户还没有登录"); 
			return false;
		}else{
			System.out.println("用户已经登录，登录名为:"+user.getUName());
			return true;
		}  
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("========初始化过滤器=========");
	}

}
