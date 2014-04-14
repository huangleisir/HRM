//package com.hrm.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hrm.Dao.ITblUserDao;
import com.hrm.Dao.QueryResult;
import com.hrm.Dao.impl.TblUserDaoImpl;
import com.hrm.action.TblUserAction;
import com.hrm.pojo.TblUser;
import com.hrm.service.ITblUserService;
import com.hrm.service.impl.TblUserServiceImpl;


public class Test {
	
	public static void main(String[] args) throws Exception {
		
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		
			SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
			
			TblUserAction tblUserAction = (TblUserAction)context.getBean("TblUserAction");
			
			ITblUserService  tblUserService  =  (TblUserServiceImpl) context.getBean("TblUserService");
			
			ITblUserDao  tblUserDao  =  (TblUserDaoImpl) context.getBean("TblUserDao");
			
			System.out.println("-------------"+sessionFactory);
			System.out.println("-------------"+tblUserAction);
			System.out.println("-------------"+sessionFactory);
//			QueryResult<TblUser> userlist= tblUserService.login();
			QueryResult<TblUser> userResult = tblUserService.getScrollData(1, 3);
			List<TblUser> list = userResult.getResultlist();
//			List<TblUser> list = tblUserAction.findAllUsers();
			System.out.println("--------list.size()-----------"+list.size());
			for (TblUser user2 : list) {
				System.out.println(user2.getUName()+user2.getUPassword()+user2.getUTrueName());
			}
			
			TblUser tbluser = new TblUser();
			tbluser.setUId(8);
//			tblUserService.delete(tbluser);
//		jdbc.driver_class=com.mysql.jdbc.Driver
//				jdbc.connection.url=jdbc:mysql://localhost:3306/newsview
//				jdbc.connection.username= root
//				jdbc.connection.password= 666666
			
//			Class.forName("com.mysql.jdbc.Driver");
//		Connection	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newsdb", "root", "666666");
//		System.out.println(con);
//		String sql = "select * from tbl_user";
//		PreparedStatement ps =con.prepareStatement(sql);
//	 ResultSet	rs = ps.executeQuery(sql);
//	 while(rs.next()){
//			String sid = rs.getString(2);
//			System.out.println(sid);
//		}
//	 rs.close();
//	 ps.close();
//	 con.close();
		
		
	}

}

