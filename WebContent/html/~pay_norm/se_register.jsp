<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<script src="../../script/common.js"></script>
<%-- <script language="javascript">
function getValue(url){
	
	document.form1.onsubmit;
	document.form1.action=url; 
	//document.form1.action="doUpdate.jsp"; // 提交的路径 这里是一个Servlet的名称
	//判断是否提交数据
	if(confirm("确定要提交吗？"))
	{
	return true;
	}
	else
	{
	return false;
	}
}
</script> --%>
<!-- 小组验证方法 -->
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
jQuery(function($) {
	var vali=new Validators();
	$("#btn").bind("click", vali.subByJs);
});
</script>
</head>
<body>
<%
String standardId = request.getParameter("tblStandardSalary.standardId");
String standardName = request.getParameter("tblStandardSalary.standardName");
String itemId = request.getParameter("tblStandardSalaryDetail.itemId");
String itemName = request.getParameter("tblStandardSalaryDetail.itemName");
String sdtId = request.getParameter("tblStandardSalaryDetail.sdtId");
String salarySum = request.getParameter("tblStandardSalary.salarySum");

%>
<form action="" name="form1" method="post">
<div class="page_title">薪酬标准管理  > 薪酬复核 </div>
<div class="button_bar">
	<button type="submit" class="common_button" id="btn" >薪酬设置复核通过</button> 
	<!-- 
	<button type="submit" class="common_button" onclick="getValue('tblStandardSalaryDetailAction!delete.action')" >删除复核通过</button> 
	<input type="button"  name="submit" value="复核通过"  onclick="javascript:document.location.href='html/~pay_norm/check.jsp';"/> -->
	<!-- <button class="common_button" onclick="window.location='setup.jsp';">返回</button>  --> 
</div>
<table class="query_form_table">
	<tr>
		<tr>
	    <th>薪酬编号</th>
		<td>
		<input type="hidden" name="tblStandardSalary.ssdId" value="<s:property value="tblStandardSalary.ssdId"/>" valType="OTHER" regString="^[0-9]{1,28}$" msg="<font color=red>*</font>1-28位数字" />
 		<input type="text" name="tblStandardSalaryDetail.sdtId" value="<%=sdtId%>" valType="OTHER" regString="^[0-9]{1,28}$" msg="<font color=red>*</font>1-28位数字"/></td>
		<th>薪酬项目编号</th>
		<td><input type="text" name="tblStandardSalaryDetail.itemId" value="<%=itemId%>" valType="OTHER" regString="^[0-9]{1,28}$" msg="<font color=red>*</font>1-28位数字"/></td>
		<th>薪酬项目</th>
		<td><input type="text" name="tblStandardSalaryDetail.itemName" value="<%=itemName%>" valType="required" msg="<font color=red>*</font>不能为空"/></td>
		<th>薪酬标准编号</th>
		<td>
		<input type="text" name="tblStandardSalary.standardId" value="<s:property value="tblStandardSalary.standardId"/>" valType="OTHER" regString="^[0-9]{1,28}$" msg="<font color=red>*</font>1-28位数字" />
		<input type="text" name="tblStandardSalary.standardId" value="<%=standardId %>"/>
		</td>
		<th>薪酬标准名称</th>
		<td>
		<input type="text" name="tblStandardSalary.standardName" value="<s:property value="tblStandardSalary.standardName"/>"valType="required" msg="<font color=red>*</font>不能为空" />
		<input type="text" name="tblStandardSalary.standardName" value="<%=standardName %>"/>
		</td>
		<th>薪酬总额</th>
		<td>
		<input type="text" name="tblStandardSalary.salarySum" value="<s:property value="tblStandardSalary.salarySum"/>" valType="OTHER" regString="^[0-9\.]*$" msg="<font color=red>*</font>数字/金额"/>
		<input type="text" name="tblStandardSalary.salarySum" value="<%=salarySum %>"  />
		</td> 
		
	</tr>
		
<s:iterator value="list" status="stat" var="tblStandardSalary">
	<tr>	
		<th>复核人</th>
		<td><input type="text" name="tblStandardSalary.checker" value="#tblStandardSalary.checker" valType="required" msg="<font color=red>*</font>不能为空" /></td>
	</tr>
</s:iterator>
	<tr>
	    <th>复核时间</th>
		<td>
		<rq:datetimepicker id="time"  name="tblStandardSalary.registTime" ></rq:datetimepicker>
		</td>
		<th>复核意见</th>
		<td colspan="5"><textarea rows="6" cols="50" valType="required" msg="<font color=red>*</font>不能为空" ></textarea></td>
	</tr>

</table>

<script>
	setCurTime('t1');
	setCurTime('t2');
	setCurTime('t3');
</script>
</form>
</body>
</html>