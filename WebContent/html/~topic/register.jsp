<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-dojo-tags" prefix="sx"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="hrm" uri="/www.crm.com"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<sx:head parseContent="true" />
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
 $(function() {

	//绑定试题种类
	$.getJSON("bindQustionAction!bindFirst.action", function(data) {
		//必须用eval把字符串转换成json   
		//data.firstKind为json对象中firstKind数组
		var fqkinds = eval(data.firstQust);
		//设置一级机构的select 的size为数组长度
		//$("#mjkind").attr("size", mjkinds.length);
		// 遍历firstKind数组
		for ( var i = 0; i <fqkinds.length; i++) {
			// json对象中的一个元素            
			var mjkind = fqkinds[i];
			// 创建一个option             
			var option = document.createElement("option");
			$(option).attr("value", mjkind.firstKindId);
			$(option).html(mjkind.firstKindName);
			//添加到select下
			document.getElementById("fq").appendChild(option);
		}
	});
	var vali=new Validators();
	$("#btn").bind("click", vali.subByJs);
 });
	function getSecond(obj) {
		$("#sq > option").remove();
		var fqid = $(obj).val();
		$.getJSON("bindQustionAction!bindSecond.action?fqid="+fqid, function(data) {
			//必须用eval把字符串转换成json   
			//data.secondKind为json对象中secondKind数组
			var fskinds = eval(data.secondQuest);
			//设置一级机构的select 的size为数组长度
			
				//$("#fsk").attr("size", fskinds.length);
			// 遍历firstKind数组
			for ( var i = 0; i < fskinds.length; i++) {
				// json对象中的一个元素            
				var fskind = fskinds[i];
				// 创建一个option             
				var option = document.createElement("option");
				$(option).attr("value", fskind.secondKindId);
				$(option).html(fskind.secondKindName);
				//添加到select下
				document.getElementById("sq").appendChild(option);
			}
		});
		$("#fqname").val($("#fq option:selected").html());
	}
	function get_sqname(){
		$("#sqname").val($("#sq option:selected").html());
	}
</script>
</head>
<body>
<div class="page_title">招聘考试题库管理  &gt; 试题登记 </div>
<form action="tblQuestionsAction!save.action" method="post">
<div class="button_bar">
	<input type="submit" class="common_button" value="提交" id="btn"> 
	<input type="reset" class="common_button" value="返回">
</div>
<table class="query_form_table">
	<tr>
		<th>登记人</th>
		<td><input name="tblQuestions.register" valType="required" msg="<font color=red>*</font>登记人不能为空"/></td>
		<th>登记时间</th>
		<td><sx:datetimepicker name="tblQuestions.registTime" displayFormat="yyyy-MM-dd" /></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<th>试题I级分类</th>
		<td>
			<input type="hidden" name="tblQuestions.firstKindName" id="fqname">
			<select id="fq" onclick="getSecond(this)" name="tblQuestions.firstKindId">
			</select>
		</td>
		<th>试题II级分类</th>
		<td>
			<input type="hidden" name="tblQuestions.secondKindName" id="sqname">
			<select id="sq"  name="tblQuestions.secondKindId" onclick="get_sqname()">
			</select>
			</td>
		<td></td>
		<td></td>
	</tr>
	
	<tr>
		<th>题干</th>
		<td colspan="5"><textarea rows="6" cols="50" name="tblQuestions.content" valType="required" msg="<font color=red>*</font>不能为空"></textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>答案a</th>
		<td colspan="5"><textarea rows="6" cols="50" name="tblQuestions.keyA" valType="required" msg="<font color=red>*</font>不能为空"></textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>答案b</th>
		<td colspan="5"><textarea rows="6" cols="50" name="tblQuestions.keyB" valType="required" msg="<font color=red>*</font>不能为空"></textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>答案c</th>
		<td colspan="5"><textarea rows="6" cols="50" name="tblQuestions.keyC" valType="required" msg="<font color=red>*</font>不能为空"></textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>答案d</th>
		<td colspan="5"><textarea rows="6" cols="50" name="tblQuestions.keyD" valType="required" msg="<font color=red>*</font>不能为空"></textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>答案e</th>
		<td colspan="5"><textarea rows="6" cols="50" name="tblQuestions.keyE"></textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>正确答案</th>
		<td><input name="tblQuestions.correctKey" valType="required" msg="<font color=red>*</font>不能为空"/></td>
		<th>试题出处</th>
		<td><input name="tblQuestions.derivation" valType="required" msg="<font color=red>*</font>不能为空"/></td>
		<th></th>
		<td></td>
	</tr>
</table>
</form>
</body>
</html>