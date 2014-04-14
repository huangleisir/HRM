<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tangs" uri="/WEB-INF/pages.tld"%>   
<%@ taglib prefix="s" uri="/struts-tags" %>
<%    
String path = request.getContextPath();    
// 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是 http://localhost:8080/MyApp/）:    
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";    
%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="html/css/style.css" rel="stylesheet" type="text/css">
<script src="html/script/common.js"></script>
</head>
<body>

<div class="page_title">人力资源&nbsp; &gt; 客户化设置&nbsp; &gt; 职位分类设置</div>
<div class="button_bar">
	<!--<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="reload();">查询</button> 
	--><button class="common_button" onclick="to('html/~sale/edit6.jsp');">添加</button>  
	</div>
<!--<table class="query_form_table">
	<tr>
		<th>客户名称</th>
		<td><input /></td>
		<th>概要</th>
		<td><input /></td>
		<th>联系人</th>
		<td>
			<input name="T1" size="20" />
		</td>
	</tr>
	</table>
-->
<table class="data_list_table">
	<tr>
		<th>属性种类</th>
		<th>属性名称</th>
		<th>操作</th>
	</tr>
	<s:iterator value="list" status="stat" var="tblPublicAttribute">
	<tr>
		<td class="list_data_number"><s:property value='#tblPublicAttribute.attributeKind' /></td>
		<td class="list_data_number"><s:property value='#tblPublicAttribute.attributeName' /></td>
		<td class="list_data_op">
			<!--<img onclick="to('dispatch.html');" title="指派" src="images/bt_linkman.gif" class="op_button" />
			<img onclick="to('edit3.html');" title="编辑" src="images/bt_edit.gif" class="op_button" />-->
			<img onclick="to('tblPublicAttributeAction!delete.action?tblPublicAttribute.pbcId='+<s:property value='#tblPublicAttribute.pbcId' />);" title="删除" src="images/bt_del.gif" class="op_button" />
			
		</td>
	</tr>
	</s:iterator>
	<tr>
		<th colspan="7" class="pager">
<div class="pager">
	共 <s:property value="totalPage"/> 页 第 <s:property value="pageNo"/> 页   
  			  <tangs:pages pageNo="pageNo" total="totalPage"  styleClass="page" theme="number"/>
</div>
		</th>
	</tr>
</table>
</body>
</html>