<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- 绝对路径的公共方法 -->
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-dojo-tags" prefix="rq"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>jb-aptech毕业设计项目</title>
<rq:head parseContent="true"/>
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

function yanzhen(){	
	
	   //var name = document.getElementById("name").value;
	   var testdate= dojo.widget.byId("time").getValue();     
	   /* if(name==null||name=="")
		   {
		   alert("请示入名称！");
		   return false;
		   } */
	    if(testdate==null||testdate=="")
		 {
		   alert("请输入时间！");
		   return false;
		 }
	   //alert(testdate);
	}
</script>
</head>
<body>     
<form action="tblStandardSalaryAction!save.action" name="form1" method="post">
<div class="page_title">薪酬标准管理  > 薪酬标准登记 </div>
<div class="button_bar">
<input type="reset" name="reset" value="清空" class="common_button" >

<input type="submit" class="common_button" id="btn"  value="提交" onClick="return yanzhen()"/>
<!-- 	
<button type="submit" class="common_button" onclick="getValue('tblStandardSalaryAction!update.action')" >登记复核通过</button> 
<button type="submit" name="common_button" onClick="checkit()">复核</button>  --> 
</div>
<table class="query_form_table">
	<tr>
		<th>薪酬标准编号</th>
<!-- <a href="../../tblStandardSalaryAction!modify.action?tblStandardSalary.ssdId=value='#tblStandardSalary.ssdId="<input type="text" name="tblStandardSalary.ssdId" />" /></a> -->
 		<td><input type="text" id="standardId" name="tblStandardSalary.standardId" valType="OTHER" regString="^[0-9]{1,28}$" msg="<font color=red>*</font>1-28位数字" /></td> 
		<th>薪酬标准名称</th>
		<td><input type="text" name="tblStandardSalary.standardName" valType="required" msg="<font color=red>*</font>不能为空"  /></td>
		<th>薪酬总额</th>
		<td>
		<input type="text" id="salarySum" name="tblStandardSalary.salarySum" valType="OTHER" regString="^[0-9\.]*$" msg="<font color=red>*</font>数字/金额" />
		</td>
	</tr>
	<tr>
		
		<th>制定人</th>
		<td><input type="text" name="tblStandardSalary.designer" valType="required" msg="<font color=red>*</font>不能为空" /></td>
		<th>登记人</th>
		<td><input type="text" name="tblStandardSalary.register" valType="required" msg="<font color=red>*</font>不能为空" /></td>
		<th>登记时间</th>
		<td>
		<!-- 日期标签 label="生日" -->
	   <rq:datetimepicker id="time"  name="tblStandardSalary.registTime"  ></rq:datetimepicker>
		 <!-- <input type="text" name="tblStandardSalary.registTime" value="" /> -->
	    </td>
	  
	</tr>
	
	<tr>
		<th>备注</th>
		<td colspan="5"><textarea rows="6" cols="50" name="tblStandardSalary.remark" valType="required" msg="<font color=red>*</font>不能为空"></textarea></td>
	</tr>

</table>
</form>
<!-- <script>
	setCurTime('t1');
	setCurTime('t2');
	//setCurTime('t3');
</script> -->
</body>
</html>