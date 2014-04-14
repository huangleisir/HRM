<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-dojo-tags" prefix="sx"%>
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
<sx:head parseContent="true" />
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script src="script/jquery.1.7.2.min.js"></script>
<script type='text/javascript' src="lib/jquery.poshytip.js"></script>
<script type='text/javascript' src='lib/jq.validate.js'></script>
<link rel="stylesheet" type="text/css" href="main.css" />
	<link rel="stylesheet" href="lib/tip-yellowsimple/tip-yellowsimple.css" type="text/css" />
	<style type="text/css">
	.border {
		border:1px solid red;
	}
	td {
		padding:7px;
	}
	#labels {
		text-align:right;
	}
</style>
<script type="text/javascript">
$(function(e) {
	var vali=new Validators();
	$("#btn").bind("click", vali.subByJs);
});
</script>
</head>
<body>
	<div class="page_title">职位发布管理  &gt; 职位发布变更 </div>
	<form action="tblPositionReleaseAction!update.action" method="post">
		<div class="button_bar">
			<input type="submit" class="common_button" value="重新提交" id="btn"> <input
				type="button" class="common_button" value="返回"
				onblur="history.back()" />
		</div>
		<table class="query_form_table">
			<tr>
				<th>I 级机构</th>
				<td><input type="hidden" name="tblPositionRelease.firstKindId"
					value="<s:property value='tblPositionRelease.firstKindId'/>">
					<input type="hidden" name="tblPositionRelease.firstKindName"
					value="<s:property value='tblPositionRelease.firstKindName'/>">
					<s:property value='tblPositionRelease.firstKindName' /></td>
				<th>II 级机构</th>
				<td><input type="hidden" name="tblPositionRelease.secondKindId"
					value="<s:property value='tblPositionRelease.secondKindId'/>">
					<input type="hidden" name="tblPositionRelease.secondKindName"
					value="<s:property value='tblPositionRelease.secondKindName'/>">
					<s:property value='tblPositionRelease.secondKindName' /></td>
				<th>III 级机构</th>
				<td><input type="hidden" name="tblPositionRelease.thirdKindId"
					value="<s:property value='tblPositionRelease.thirdKindId'/>">
					<input type="hidden" name="tblPositionRelease.thirdKindName"
					value="<s:property value='tblPositionRelease.thirdKindName'/>">
					<s:property value='tblPositionRelease.thirdKindName' /></td>
			</tr>
			<tr>
				<th>招聘类型</th>
				<td><select name="tblPositionRelease.engageType">
						<option>社会招聘</option>
						<option>校园招聘</option>
				</select></td>
				<th>职位分类</th>
				<td>
					<input type="hidden" name="tblPositionRelease.majorId"
					value="<s:property value='tblPositionRelease.majorId'/>">
					<input type="hidden" name="tblPositionRelease.majorName"
					value="<s:property value='tblPositionRelease.majorName'/>">
					<input type="hidden" name="tblPositionRelease.majorKindId"
					value="<s:property value='tblPositionRelease.majorKindId'/>">
					<input type="hidden" name="tblPositionRelease.majorKindName"
					value="<s:property value='tblPositionRelease.majorKindName'/>">
					<s:property value='tblPositionRelease.majorKindName' />
				</td>
				<th>变更时间</th>
				<td colspan="3">
				<sx:datetimepicker name="tblPositionRelease.changeTime" displayFormat="yyyy-MM-dd" value="%{'today'}" />
				</td>
			</tr>
			<tr>
				<th>招聘人数</th>
				<td><input name="tblPositionRelease.humanAmount" value="<s:property value='tblPositionRelease.humanAmount'/>" valType="required" msg="<font color=red>*</font>必须为数字且不能为空"/></td>
				<th>截止日期</th>
				<td colspan="3">
				<sx:datetimepicker name="tblPositionRelease.deadline" displayFormat="yyyy-MM-dd"/>
				</td>
				<th></th>
				<td></td>
			</tr>
			<tr>
				<th>变更人</th>
				<td><input name="tblPositionRelease.changer" value="<s:property value='tblPositionRelease.changer'/>" valType="required" msg="<font color=red>*</font>变更人不能为空"/></td>
				<th></th>
				<td><input type="hidden" name="tblPositionRelease.maeId" value="<s:property value='tblPositionRelease.maeId'/>"></td>
				<th></th>
				<td><input type="hidden" name="tblPositionRelease.registTime" value="<s:property value='tblPositionRelease.registTime'/>">
					<input type="hidden" name="tblPositionRelease.register" value="<s:property value='tblPositionRelease.register'/>">
				</td>
			</tr>
			<tr>
				<th>职位描述</th>
				<td colspan="5">
				<textarea rows="6" cols="50" name="tblPositionRelease.majorDescribe" valType="required" msg="<font color=red>*</font>不能为空"><s:property value='tblPositionRelease.majorDescribe'/></textarea>
				</td>
			</tr>
			<tr>
				<th>招聘要求</th>
				<td colspan="5"><textarea rows="6" cols="50" name="tblPositionRelease.engageRequired" valType="required" msg="<font color=red>*</font>不能为空"><s:property value='tblPositionRelease.engageRequired'/></textarea>
				</td>
			</tr>

		</table>
	</form>
	<script>
		setCurTime('t1');
		setCurTime('t2');
		setCurTime('t3');
	</script>
</body>
</html>