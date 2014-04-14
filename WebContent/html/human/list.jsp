<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>显示列表</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/jquery.1.7.2.min.js"></script>
</head>
<body>
	<div class="page_title">人力资源&nbsp; &gt; 人力资源档案登记复核</div>
	<table class="data_list_table">
		<tr>
			<th>档案编号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>I级机构</th>
			<th>II级机构</th>
			<th>III级机构</th>
			<th>职称</th>
			<th>复核</th>
		</tr>
		<tr>
			<td class="list_data_number">HF01010101</td>
			<td class="list_data_text">XIAOQIANG</td>
			<td class="list_data_text">男</td>
			<td class="list_data_text">集团</td>
			<td class="list_data_ltext">公司</td>
			<td class="list_data_text">部门</td>
			<td class="list_data_text">工程师</td>
			<td class="list_data_op"><a href="recheck.html">复核</a></td>
		</tr>
		<s:iterator value="humanList" var="human">
			<tr>
				<td class="list_data_number"><s:property value="#human.humanId" /></td>
				<td class="list_data_text"><s:property value="#human.humanName" /></td>
				<td class="list_data_text"><s:property value="#human.humanSex" /></td>
				<td class="list_data_text"><s:property value="#human.firstKindName" /></td>
				<td class="list_data_ltext"><s:property value="#human.secondKindName" /></td>
				<td class="list_data_text"><s:property value="#human.thirdKindName" /></td>
				<td class="list_data_text"><s:property value="#human.humanMajorKindName" /></td>
				<td class="list_data_op"><a href="recheck.html">复核</a></td>
			</tr>
		</s:iterator>

		<tr>
			<th colspan="7" class="pager">
				<div class="pager">
					共59条记录 每页<input value="10" size="2" />条 第<input value="1" size="2" />页/共5页
					<a href="#">第一页</a> <a href="#">上一页</a> <a href="#">下一页</a> <a
						href="#">最后一页</a> 转到<input value="1" size="2" />页
					<button width="20" onclick="reload();">GO</button>
				</div>
			</th>
		</tr>
	</table>
</body>
</html>