<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="tangs" uri="/WEB-INF/pages.tld"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>
	<div class="page_title">职位发布管理  &gt; 职位发布查询 </div>
	<table class="data_list_table">
		<tr>
			<th>机构名称</th>
			<th>招聘人数</th>
			<th>发布时间</th>
			<th>截止时间</th>
			<th>申请该职位</th>
		</tr>
		<s:iterator value="list" status="stat" var="tblPositionRelease">
			<tr>
				<td class="list_data_number"><s:property
						value="#tblPositionRelease.firstKindName" />
				</td>
				<td class="list_data_text"><s:property
						value='#tblPositionRelease.humanAmount' />
				</td>
				<td class="list_data_ltext"><s:property
						value='#tblPositionRelease.registTime' />
				</td>
				<td class="list_data_ltext"><s:property
						value='#tblPositionRelease.deadline' />
				</td>
				<td class="list_data_text"><a href="tblPositionReleaseAction!check.action?tblPositionRelease.maeId=<s:property value='#tblPositionRelease.maeId'/>">申请该职位
				</a>
				</td>
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