<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

用户管理（复用分页模块）
<table style="border:1px solid red;">
	<tr  >
	 	<td width="120px">
	 	UserID
	 	</td>
	 	<td  width="120px">
	 	用名
	 	</td>
	 	<td  width="120px">
	 	用户真名
	 	</td>
	 	<td  width="140px">
	 	用户密码
	 	</td  >
	 	<td colspan="2"  width="240px"><center>管理用户信息</center></td>
	 	
	
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

<!-- <a href="tblUserAction!addUser.action">增加用户</a> -->
 <a href="html/register.html">增加用户</a>
<a href="html/updatepassword.jsp"   >修改本用户密码  </a>


<table class="data_list_table">
	<tr>
		<th>I级机构编号</th>
		<th>I级机构名称</th>
		<th>薪酬发放责任人编号</th>
		<th>销售责任人编号</th>
		<th>操作</th>
	</tr>
	<s:iterator value="list" status="stat" var="tblFirstClass">
	<tr>
		<td class="list_data_number"><s:property value='#tblFirstClass.firstKindId' /></td>
		<td class="list_data_text"><s:property value='#tblFirstClass.firstKindName' /></td>
		<td class="list_data_ltext"><s:property value='#tblFirstClass.firstKindSalaryId' /></td>
		<td class="list_data_text"><s:property value='#tblFirstClass.firstKindSaleId' /></td>
		<td class="list_data_op">
			<!--<img onclick="to('dispatch.html');" title="指派" src="../images/bt_linkman.gif" class="op_button" />
			--><img onclick="to('tblFirstClassAction!findById.action?tblFirstClass.ffkId='+<s:property value='#tblFirstClass.ffkId' />);" title="编辑" src="images/bt_edit.gif" class="op_button" />
			<img onclick="to('tblFirstClassAction!delete.action?tblFirstClass.ffkId='+<s:property value='#tblFirstClass.ffkId' />);" title="删除" src="images/bt_del.gif" class="op_button" />
			
		</td>
	</tr>
	</s:iterator>
	<tr>
		<th colspan="5" class="pager">
<div class="pager">
	共 <s:property value="totalPage"/> 页 第 <s:property value="pageNo"/> 页   
  			  <tangs:pages pageNo="pageNo" total="totalPage"  styleClass="page" theme="number"/>
</div>
		</th>
	</tr>
</table>


<s:debug></s:debug>    
</body>
</html>