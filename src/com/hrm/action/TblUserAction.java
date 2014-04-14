package com.hrm.action;

import java.util.List;
import java.util.Map;








import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hrm.Dao.QueryResult;
import com.hrm.pojo.TblFirstClass;
import com.hrm.pojo.TblUser;
import com.hrm.service.ITblUserService;
import com.hrm.utils.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Scope("prototype")
@Controller("TblUserAction")
public class TblUserAction extends ActionSupport implements ModelDriven{

	private static final long serialVersionUID = 8L;
	@Autowired//因为这个注解的原因下面的getter，setter都不需要了
	private ITblUserService tblUserService;
	//User的实例
	private TblUser tbluser;
	
	private List<TblUser> userList;
	@Autowired  //没有这个注解，page是个空对象
	private Pager<TblUser> page;
	
//	public Pager<TblUser> getPage() {
//		return page;
//	}
//	
//	public void setPage(Pager<TblUser> page) {
//		this.page = page;
//	}
	@Override
	public Object getModel() {
		return page;
	}
	
	
//	public ITblUserService getTblUserService() {
//		return tblUserService;
//	}
//	public void setTblUserService(ITblUserService tblUserService) {
//		this.tblUserService = tblUserService;
//	}
	
	
	public void setUserList(List<TblUser> userList) {
		this.userList = userList;
	}
	
	//查询所有用户，匹配是否存在页面传入的用户   
    //其实应该是先根据用户名查找出该用户的entity，然后比对密码就完事了，这样查询所有用户再来比对很不优化
	public String doLogin(){
		Map<String,Object> session=ActionContext.getContext().getSession();
		QueryResult<TblUser> userlist=tblUserService.getScrollData(-1, -1);
		for(int i=0;i<userlist.getResultlist().size();i++){
			if(userlist.getResultlist().get(i).getUName().equals(tbluser.getUName())&&userlist.getResultlist().get(i)
					.getUPassword().equals(tbluser.getUPassword())){
				tbluser=userlist.getResultlist().get(i);
				session.put("tbluser", tbluser);//在ajax中会调用到这个对象，用data对应
			}
		}
		return SUCCESS;
	}
	//修改密码
	public String updatePassword(){
		Map<String,Object> session=ActionContext.getContext().getSession();
		QueryResult<TblUser> userlist=tblUserService.getScrollData(-1, -1);
		for(int i=0;i<userlist.getResultlist().size();i++){
			if(userlist.getResultlist().get(i).getUName().equals(tbluser.getUName())){
				userlist.getResultlist().get(i).setUPassword(tbluser.getUPassword());
				tblUserService.update(userlist.getResultlist().get(i));
				session.put("tbluser", userlist.getResultlist().get(i));
				return "update";
			}else{
				continue;
			}
		}
		return "error";
	}
	public String logout(){
		Map<String,Object> session=ActionContext.getContext().getSession();
		session.clear();		
		return "logout";
	}

	public TblUser getTbluser() {
		return tbluser;
	}

	public void setTbluser(TblUser tbluser) {
		this.tbluser = tbluser;
	}
	public String findAllUsers () throws Exception{
//		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("utf-8");
		Map<String,Object> session=ActionContext.getContext().getSession();
//		QueryResult<TblUser> userResult = tblUserService.getScrollData(-1, -1);
		
		//将当前页的所有记录西安拿到手     pageNo初始值1 pageSize初始值3
				QueryResult<TblUser> userResult=tblUserService.getScrollData((page.getPageNo()-1)*page.getPageSize(), page.getPageSize());
				
				userList = userResult.getResultlist();
				
				System.out.println("userList"+userList.size());
				/**
				 * 将结果集，总记录数，总页数封装到page当中
				 * 
				 */
				//设置分页查询结果集
				page.setList(userResult.getResultlist());
				
				//设置总记录
		        page.setTotal((int)userResult.getTotalrecord());//在dao查询时，将总条数得到了 qr.setTotalrecord((Long) query.uniqueResult());
		        
		        //设置分页总页数
		        page.setTotalPage();
				
//		
//		System.out.println("userList.size()"+userList.size());
		session.put("userlist", userList);//既然用了strut，还去session里面去向jsp
		
		
//		 session.put("tbluser1", userList.get(0));//将新闻列表集合装入request
//		 session.put("tbluser2", userList.get(1));
//		 session.put("tbluser3", userList.get(2));
//		 session.put("tbluser4", userList.get(3));
//		 session.put("tbluser5", userList.get(4));
		return  "findAllUsers";
	}
	
	/////////////////////////////////////////////////
	public String addUser () throws Exception{
		Map<String,Object> session=ActionContext.getContext().getSession();
		//看看能不能拿到从页面输入的值
		System.out.println("--------tbluser.getUName():--------------"+tbluser.getUName());
		System.out.println("--------tbluser.getUPassword():--------------"+tbluser.getUPassword());
		System.out.println("--------tbluser.getUTrueName():--------------"+tbluser.getUTrueName());
		
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("utf-8");
		tblUserService.save(tbluser);;
	
		System.out.println("=======addUserSuccess===========");
		return  "addUserSuccess";
	}
	
	public String modifyUser() {
		System.out.println("----------modifyUsers---------------");
		
		return "modifyUserSuccess";
	}
	public String deleteUser() throws Exception {
		System.out.println("----------deleteUsers---------------");
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String,Object> session=ActionContext.getContext().getSession();
		request.setCharacterEncoding("utf-8");
		String sid = request.getParameter("id");
		System.out.println("id:"+sid);
		int id = Integer.valueOf(sid);
		tbluser = new TblUser();
		tbluser.setUId(id);
		tblUserService.delete(tbluser);
		
		return "modifyUserSuccess";
	}
}
