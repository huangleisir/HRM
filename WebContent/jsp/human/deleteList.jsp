<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="hrm" uri="/www.crm.com"%>
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
	<s:url var="actionUrl" action="findDeleteList" namespace="/human" />
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
			<th>状态</th>
			<th>删除</th>
			<th>回复</th>
			<th>永久删除</th>
		</tr>
		<s:iterator value="humanList" var="human">
			<tr>
				<td class="list_data_number"><s:property value="#human.humanId" /></td>
				<td class="list_data_text"><s:property value="#human.humanName" /></td>
				<td class="list_data_text"><s:property value="#human.humanSex==1?'男':'女'" /></td>
				<td class="list_data_text"><s:property value="#human.checkStatus==1?'正常':'删除'" /></td> 
				<td class="list_data_op">
					<s:if test="#human.checkStatus==1">
						<s:url var="doDeleteUrl" action="delete" namespace="/human">
						<s:param name="hufId" value="#human.hufId"></s:param>
					</s:url> 
					<a onclick="return confirm('确定删除吗？');" href="<s:property value="#doDeleteUrl"/>">删除</a>
					</s:if>
					
				</td> 
				<td class="list_data_op">
					<s:if test="#human.checkStatus==2">
						<s:url var="doReDeleteUrl" action="reDelete" namespace="/human">
							<s:param name="hufId" value="#human.hufId"></s:param>
						</s:url> 
						<a onclick="return confirm('确定恢复吗？');" href="<s:property value="#doReDeleteUrl"/>">恢复</a>
					</s:if>
				</td> 
				<td class="list_data_op">
					<s:if test="#human.checkStatus==2">
						<s:url var="doForeverDeleteUrl" action="deleteForever" namespace="/human">
						<s:param name="hufId" value="#human.hufId"></s:param>
					</s:url>
					<hrm:permission includeName="delete">
					<a onclick="return confirm('确定永久删除吗？');" href="<s:property value="#doForeverDeleteUrl"/>">永久删除</a>
					</hrm:permission>
					</s:if> 
					
				</td> 
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