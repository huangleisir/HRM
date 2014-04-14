<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="tangs" uri="/WEB-INF/pages.tld"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="html/css/style.css" rel="stylesheet" type="text/css">
<script src="html/script/common.js"></script>
<title>Insert title here</title>
</head>
<body>

<div class="page_title">人力资源&nbsp; &gt; 用户管理</div>
<div class="button_bar">
	<!-- <button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="reload();">查询</button> 
<input class="common_button" type="reset" value="清除"/>
	-->
	<button class="common_button" onclick="to('html/userAdd.jsp');">添加</button>  
	</div>
<table class="data_list_table">
	<tr  >
	 	<th width="120px">
	 	UserID
	 	</th>
	 	<th  width="120px">
	 	用名
	 	</th>
	 	<th  width="120px">
	 	用户真名
	 	</th>
	 	<th  width="140px">
	 	用户密码
	 	</th  >
	 	<th colspan="2"  width="240px"><center>管理用户信息</center></th>
	 	
	
	</tr>
		<s:iterator var="userIterator" value="#session.userlist" status="status" >
	<tr style="border:1px solid red;">
		<td ><s:property value='UId' /></td>
		<td ><s:property value='UName' /></td>
		<td ><s:property value='UTrueName' /></td>
		<td ><s:property value='UPassword' /></td>
		<td ><s:a href="html/updatepassword.jsp" ><center>修改</center></s:a></td>
<%-- 		<td ><s:a href="tblUserAction!modifyUser.action?id=%{UId}" ><center>修改</center></s:a></td> --%>
		<td ><s:a href="tblUserAction!deleteUser.action?id=%{UId}" >删除</s:a></td>
		
	</tr>
		</s:iterator>
</table>
<div>共 <s:property value="totalPage"/> 页 第 <s:property value="pageNo"/> 页   
  			  <tangs:pages pageNo="pageNo" total="totalPage"  styleClass="page" theme="text"/></div>

<!-- <a href="tblUserAction!addUser.action">增加用户</a> -->
 <a href="html/register.html">增加用户</a>
<a href="html/updatepassword.jsp"   >修改本用户密码  </a>



<!-- <table > -->
<!-- <center>用户列表 </center> -->
<!-- 	<tr> -->
<!-- 	 	<td> -->
<!-- 	 	UserID -->
<!-- 	 	</td> -->
<!-- 	 	<td> -->
<!-- 	 	用名 -->
<!-- 	 	</td> -->
<!-- 	 	<td> -->
<!-- 	 	用户真名 -->
<!-- 	 	</td> -->
<!-- 	 	<td> -->
<!-- 	 	用户密码 -->
<!-- 	 	</td> -->
<!-- 	 	<td> -->
<!-- 	 	管理员操作 -->
<!-- 	 	</td> -->
	
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 	 	<td> -->
<!-- 	 	<s:property value="#session.tbluser1.UId"/> -->
<!-- 	 	</td> -->
<!-- 	 	<td> -->
<!-- 	 	<s:property value="#session.tbluser1.UName"/> -->
<!-- 	 	</td> -->
<!-- 	 	<td> -->
<!-- 	 	<s:property value="#session.tbluser1.UTrueName"/> -->
<!-- 	 	</td> -->
<!-- 	 	<td> -->
<!-- 	 	<s:property value="#session.tbluser1.UPassword"/> -->
<!-- 	 	</td> -->
<!-- 	 	<td> -->
<!-- 	 	<a href="tblUserAction!modifyUser.action">修改</a> <a href="#">删除</a>超链接中要带参数，这里用ajax封装比较好 -->
<!-- 	 	</td> -->
	
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 	 	<td> -->
<%-- 	 	<s:property value="#session.tbluser2.UId"/> --%>
<!-- 	 	</td> -->
<!-- 	 	<td> -->
<%-- 	 	<s:property value="#session.tbluser2.UName"/> --%>
<!-- 	 	</td> -->
<!-- 	 	<td> -->
<%-- 	 	<s:property value="#session.tbluser2.UTrueName"/> --%>
<!-- 	 	</td> -->
<!-- 	 	<td> -->
<%-- 	 	<s:property value="#session.tbluser2.UPassword"/> --%>
<!-- 	 	</td> -->
<!-- 	 	<td> -->
<!-- 	 	<a href="#">修改</a> <a href="#">删除</a> -->
<!-- 	 	</td> -->
	
<!-- 	</tr> -->
	
<!-- 	<tr> -->
<!-- 	 	<td> -->
<%-- 	 	<s:property value="#session.tbluser3.UId"/> --%>
<!-- 	 	</td> -->
<!-- 	 	<td> -->
<%-- 	 	<s:property value="#session.tbluser3.UName"/> --%>
<!-- 	 	</td> -->
<!-- 	 	<td> -->
<%-- 	 	<s:property value="#session.tbluser3.UTrueName"/> --%>
<!-- 	 	</td> -->
<!-- 	 	<td> -->
<%-- 	 	<s:property value="#session.tbluser3.UPassword"/> --%>
<!-- 	 	</td> -->
<!-- 	 	<td> -->
<!-- 	 	<a href="#">修改</a> <a href="#">删除</a> -->
<!-- 	 	</td> -->
	
<!-- 	</tr> -->
	
<!-- 	<tr> -->
<!-- 	 	<td> -->
<%-- 	 	<s:property value="#session.tbluser4.UId"/> --%>
<!-- 	 	</td> -->
<!-- 	 	<td> -->
<%-- 	 	<s:property value="#session.tbluser4.UName"/> --%>
<!-- 	 	</td> -->
<!-- 	 	<td> -->
<%-- 	 	<s:property value="#session.tbluser4.UTrueName"/> --%>
<!-- 	 	</td> -->
<!-- 	 	<td> -->
<%-- 	 	<s:property value="#session.tbluser4.UPassword"/> --%>
<!-- 	 	</td> -->
<!-- 	 	<td> -->
<!-- 	 	<a href="#">修改</a> <a href="#">删除</a> -->
<!-- 	 	</td> -->
	
<!-- 	</tr> -->
	
<!-- 	<tr> -->
<!-- 	 	<td> -->
<%-- 	 	<s:property value="#session.tbluser5.UId"/> --%>
<!-- 	 	</td> -->
<!-- 	 	<td> -->
<%-- 	 	<s:property value="#session.tbluser5.UName"/> --%>
<!-- 	 	</td> -->
<!-- 	 	<td> -->
<%-- 	 	<s:property value="#session.tbluser5.UTrueName"/> --%>
<!-- 	 	</td> -->
<!-- 	 	<td> -->
<%-- 	 	<s:property value="#session.tbluser5.UPassword"/> --%>
<!-- 	 	</td> -->
<!-- 	 	<td> -->
<!-- 	 	<a href="#">修改</a> <a href="#">删除</a> -->
<!-- 	 	</td> -->
	
<!-- 	</tr> -->
	
<%-- 	<s:iterator value="userList" status="stat" var="userIterator"> --%>
<!-- 	<tr> -->
<%-- 		<td ><s:property value='#userIterator.UId' /></td> --%>
<%-- 		<td ><s:property value='#userIterator.UName' /></td> --%>
<%-- 		<td ><s:property value='#userIterator.UTrueName' /></td> --%>
<%-- 		<td ><s:property value='#userIterator.UPassword' /></td> --%>
		
<!-- 	</tr> -->
<%-- 	</s:iterator> --%>
	
	


<!-- </table> -->
<s:debug></s:debug>    
</body>
</html>