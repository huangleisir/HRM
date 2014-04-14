<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="tangs" uri="/WEB-INF/pages.tld"%>   
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>
<div class="page_title">录用管理  &gt; 推荐简历查询结果 </div>
<table class="data_list_table">
	<tr>
		<th>姓名</th>
		<th>职位分类</th>
		<th>职位类别</th>
		<th>申请录用</th>
	</tr>
	<s:iterator value="list" status="stat" var="resume">
	<tr>
		<td class="list_data_text"><s:property value='#resume.humanName' /></td>
		<td class="list_data_text"><s:property value='#resume.humaMajorKindName' /></td>
		<td class="list_data_text"><s:property value='#resume.humanMajorName' /></td>
		<td class="list_data_text"><a href="tblInterviewAction!check.action?queid=2&resume.resId=<s:property value='#resume.resId'/>">申请</a></td>
	</tr>
	</s:iterator>
	<tr>
		<th colspan="7" class="pager">
			<div >
				共 <s:property value="totalPage"/> 页 第 <s:property value="pageNo"/> 页<br><br>   
  			 	<tangs:pages pageNo="pageNo" total="totalPage"  styleClass="pager" theme="number"/>
			</div>
		</th>
	</tr>
</table>
</body>
</html>