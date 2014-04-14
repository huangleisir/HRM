<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script src="script/jquery.min.js"></script>
<script src="script/KindSelectFill.js"></script>
</head>
<body>

	<div class="page_title">人力资源&nbsp; &gt; 人力资源档案登记查询</div>
	<s:url var="actionUrl" action="findCheckList" namespace="/human" />
	<form action="<s:property value="#actionUrl"/>">
		<div class="button_bar">
			<input type="submit" class="common_button" value="搜索" />
		</div>

		<table class="data_list_table">
			<tr>
				<th>请选择员工所在I级机构</th>
				<td><select id="firstKindId" name="firstKindId" size="4">
				</select></td>
			</tr>
			<tr>
				<th>请选择员工所在II级机构</th>
				<td><select id="secondKindId" name="secondKindId" size="4">
						<option value="1">请先选择I级机构</option>
				</select></td>
			</tr>
		</table>
	</form>
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
		<s:iterator value="humanList" var="human">
			<tr>
				<td class="list_data_number"><s:property value="#human.humanId" /></td>
				<td class="list_data_text"><s:property value="#human.humanName" /></td>
				<td class="list_data_text"><s:if test="#human.humanSex==1">男</s:if>
					<s:else>女</s:else> <%--  <s:property value="#human.humanSex" /> --%>
				</td>
				<td class="list_data_text"><s:property
						value="#human.firstKindName" /></td>
				<td class="list_data_ltext"><s:property
						value="#human.secondKindName" /></td>
				<td class="list_data_text"><s:property
						value="#human.thirdKindName" /></td>
				<td class="list_data_text"><s:property
						value="#human.humanMajorKindName" /></td>
				<td class="list_data_op"><s:url var="docheckUrl" action="edit"
						namespace="/human">
						<s:param name="hufId" value="#human.hufId"></s:param>
					</s:url> <a href="<s:property value="#docheckUrl"/>&type=check">复核</a></td>
			</tr>
		</s:iterator>

		<tr>
			<th colspan="7" class="pager">
					<div class="pager">
						共<s:property value="totle"/>条记录 每页<input name="pageSize" value="5" size="2" />条 第<s:property value="pageIndex"/>
						页/共<s:property value="totlePage"/>页 
						<a href="<s:property value="#actionUrl+'?pageIndex=1'+'&firstKindId='+model.firstKindId+'&secondKindId='+model.secondKindId"/>">第一页</a> 
						<a href="<s:property value="#actionUrl+'?pageIndex='+prePageIndex+'&firstKindId='+model.firstKindId+'&secondKindId='+model.secondKindId"/>">上一页</a> 
						<a href="<s:property value="#actionUrl+'?pageIndex='+nextPageIndex+'&firstKindId='+model.firstKindId+'&secondKindId='+model.secondKindId"/>">下一页</a> 
						<a href="<s:property value="#actionUrl+'?pageIndex='+totlePage+'&firstKindId='+model.firstKindId+'&secondKindId='+model.secondKindId"/>"">最后一页</a> 
					</div>
			</th>
		</tr>
	</table>

</body>
</html>
<s:debug></s:debug>