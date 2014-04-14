<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-dojo-tags" prefix="rq"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>jb-aptech毕业设计项目</title>
<rq:head parseContent="true"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>

<%-- <script type="text/javascript">

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

<form action="tblStandardSalaryAction!update.action" name="form1" method="post">
<div class="page_title">薪酬标准管理  > 薪酬标准设置复核 </div>
<div class="button_bar">
	<button type="submit" class="common_button" id="btn" >复核通过</button> 
	<!-- <button type="submit" class="common_button" onclick="getValue('tblStandardSalaryAction!delete.action')" >删除复核通过</button> 
	 <input type="button"  name="submit" value="复核通过"  onclick="javascript:document.location.href='html/~pay_norm/check.jsp';"/> -->
	<!-- <button class="common_button" onclick="window.location='~pay_norm/sp_recheck.jsp';">返回</button> -->  
</div>
<table class="query_form_table">
	<tr>
		<th>薪酬标准编号</th>
		<td>
		<input type="hidden" name="tblStandardSalary.ssdId" value="<s:property value="tblStandardSalary.ssdId"/>" valType="OTHER" regString="^[0-9]{1,28}$" msg="<font color=red>*</font>1-28位数字"/>
		<s:property value="tblStandardSalary.standardId"/>
	 <input type="hidden" name="tblStandardSalary.standardId" value="<s:property value="tblStandardSalary.standardId"/>"/> 
		</td>
		<th>薪酬标准名称</th>
		<td>
		<input type="text" name="tblStandardSalary.standardName" value="<s:property value="tblStandardSalary.standardName"/>" valType="required" msg="<font color=red>*</font>不能为空" />
		</td>
		<th>薪酬总额</th>
		<td>
		<input type="text" id="salarySum" name="tblStandardSalary.salarySum" value="<s:property value="tblStandardSalary.salarySum"/>" valType="OTHER" regString="^[0-9\.]*$" msg="<font color=red>*</font>数字/金额"/>
		</td> 
	</tr>
	<tr>
		<th>登记人</th>
		<td>
		<input type="text" name ="tblStandardSalary.register" value="<s:property value="tblStandardSalary.register" />" valType="required" msg="<font color=red>*</font>不能为空"/>
		</td>
		<th>制定人</th>
		<td>
		<input type="text" name="tblStandardSalary.designer" value="<s:property value="tblStandardSalary.designer"/>" valType="required" msg="<font color=red>*</font>不能为空"/>
		</td>
		<th>复核人</th>
		<td><input type="text" name="tblStandardSalary.checker" value="<s:property value="tblStandardSalary.checker"/>" valType="required" msg="<font color=red>*</font>不能为空"/></td>
		<th>复核时间</th>
		<td>
		<rq:datetimepicker id="time"  name="tblStandardSalary.checkTime" ></rq:datetimepicker>
		<!-- <input type="text" name="tblStandardSalary.checkTime" value=""/> -->
		</td>
	</tr>
	
	<tr>
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