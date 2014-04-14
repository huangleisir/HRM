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

<%-- function getValue(){
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
	
function number(id)
{
	//判断是否是数字id="standardId"
	var sId = document.getElementById(id).value;
	               //document.getElementById("standardId").value;
	if(!isNaN(sId)){
		//alert("是数字");
		}else{
		alert("不是数字");
		clrtext(id);
	}

}
function clrtext(id)
{
	if (document.getElementById(id)!=null)
	{
		document.getElementById(id).value=""
	}
}
</script> --%>
</head>
<body>
<%
String standardId = request.getParameter("standardId");
String standardName = request.getParameter("standardName");
String sdtId = request.getParameter("sdtId");
String itemId = request.getParameter("itemId");
String itemName = request.getParameter("itemName");
String salarySum = request.getParameter("salarySum");
%>
<form action="tblStandardSalaryDetailAction!save.action" name="form" method="post">
<div class="page_title">薪酬标准管理  > 薪酬设置 </div>
<div class="button_bar">
		<button type="submit"  class="common_button" id="btn" >提交</button>
</div>
<table class="query_form_table">
	<tr>
		<th>薪酬项目编号</th>
		<td><input type="text" id="itemId" name="tblStandardSalaryDetail.itemId" valType="OTHER" regString="^[0-9]{1,28}$" msg="<font color=red>*</font>1-28位数字" /> </td>
		<th>薪酬项目</th>
		<td><input type="text" name="tblStandardSalaryDetail.itemName" valType="required" msg="<font color=red>*</font>不能为空" /></td>
		<th>薪酬标准编号</th>
		<td>
		<input type="text" id="itemId" name="tblStandardSalaryDetail.standardId" value="<s:property value="tblStandardSalary.standardId"/>" valType="OTHER" regString="^[0-9]{1,28}$" msg="<font color=red>*</font>1-28位数字"/>
		</td>
		<th>薪酬标准名称</th>
		<td>
		<input type="text" name="tblStandardSalaryDetail.standardName" value="<s:property value="tblStandardSalary.standardName"/>" valType="required" msg="<font color=red>*</font>不能为空"/>
		</td>
		<th>薪酬总额</th>
		<td>
		<input type="text" name="tblStandardSalaryDetail.salary" value="<s:property value="tblStandardSalary.salarySum"/>" valType="OTHER" regString="^[0-9\.]*$" msg="<font color=red>*</font>数字/金额" />
		</td> 
		
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