<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tangs" uri="/WEB-INF/pages.tld"%>   
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%    
String path = request.getContextPath();    
// 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是 http://localhost:8080/MyApp/）:    
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";    
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="html/css/style.css" rel="stylesheet" type="text/css">
<script src="html/script/common.js"></script>
</head>
<body>

<div class="page_title">人力资源&nbsp; &gt; 客户化设置&nbsp; &gt; I级机构设置</div>
<div class="button_bar">
	<!--<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="reload();">查询</button> 
<input class="common_button" type="reset" value="清除"/>
	--><button class="common_button" onclick="to('html/~sale/edit.jsp');">添加</button>  
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
  			  <tangs:pages pageNo="pageNo" total="totalPage"  styleClass="page" theme="text"/>
</div>
		</th>
	</tr>
</table>
<s:debug/>
<s:property value="page"/>
<br/>
共<s:property value="page.total"/>条记录
共 <s:property value="page.totalPage"/> 页 第 <s:property value="page.pageNo"/> 页
<br/>
 自定义标签<tangs:pages pageNo="pageNo" total="totalPage"  styleClass="page" theme="number"/>
</body>
</html>