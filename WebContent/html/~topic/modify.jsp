<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
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
	var vali=new Validators();
	$("#btn").bind("click", vali.subByJs);
});
</script>
</head>
<body>
<div class="page_title">招聘考试题库管理  &gt; 试题更新</div>
<form action="tblQuestionsAction!update.action" method="post">
<div class="button_bar">
			<input  type="submit"  value="提交" class="common_button" id="btn"/>
			<input  type="button" onclick="history.back()" value="返回" class="common_button"/>
</div>
<table class="query_form_table">
	<tr>
		<th>登记人</th>
		<td><input disabled value="<s:property value='tblQuestions.register'/>" name="tblQuestions.register"/>
			<input type="hidden" value="<s:property value='tblQuestions.subId'/>" name="tblQuestions.subId"/>
		</td>
		<th>登记时间</th>
		<td><input disabled value="<s:property value='tblQuestions.registTime'/>" name="tblQuestions.registTime"/></td>
		<th></th>
		<td></td>
	</tr>
	<tr>
		<th>试题I级分类</th>
		<td><input disabled value="<s:property value='tblQuestions.firstKindName'/>" name="tblQuestions.firstKindName"/>
			<input type="hidden" value="<s:property value='tblQuestions.firstKindId'/>" name="tblQuestions.firstKindId"/>
			<input type="hidden" value="<s:property value='tblQuestions.firstKindName'/>" name="tblQuestions.firstKindName"/>
		</td>
		<th>试题II级分类</th>
		<td><input disabled value="<s:property value='tblQuestions.secondKindName'/>" name="tblQuestions.secondKindName"/>
			<input type="hidden" value="<s:property value='tblQuestions.secondKindId'/>" name="tblQuestions.secondKindId"/>
			<input type="hidden" value="<s:property value='tblQuestions.secondKindName'/>" name="tblQuestions.secondKindName"/>
		</td>
		<th></th>
		<td></td>
	</tr>
	
	<tr>
		<th>题干</th>
		<td colspan="5"><textarea rows="6" cols="50" name="tblQuestions.content" valType="required" msg="<font color=red>*</font>不能为空"><s:property value='tblQuestions.content'/></textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>答案a</th>
		<td colspan="5"><textarea rows="6" cols="50" name="tblQuestions.keyA" valType="required" msg="<font color=red>*</font>不能为空"><s:property value='tblQuestions.keyA'/></textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>答案b</th>
		<td colspan="5"><textarea rows="6" cols="50" name="tblQuestions.keyB" valType="required" msg="<font color=red>*</font>不能为空"><s:property value='tblQuestions.keyB'/></textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>答案c</th>
		<td colspan="5"><textarea rows="6" cols="50" name="tblQuestions.keyC" valType="required" msg="<font color=red>*</font>不能为空"><s:property value='tblQuestions.keyC'/></textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>答案d</th>
		<td colspan="5"><textarea rows="6" cols="50" name="tblQuestions.keyD" valType="required" msg="<font color=red>*</font>不能为空"><s:property value='tblQuestions.keyD'/></textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>答案e</th>
		<td colspan="5"><textarea rows="6" cols="50" name="tblQuestions.keyE"><s:property value='tblQuestions.keyE'/></textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>正确答案</th>
		<td><input  value="<s:property value='tblQuestions.correctKey'/>" name="tblQuestions.correctKey" valType="required" msg="<font color=red>*</font>不能为空"/></td>
		<th>试题出处</th>
		<td><input  value="<s:property value='tblQuestions.derivation'/>" name="tblQuestions.derivation" valType="required" msg="<font color=red>*</font>不能为空"/></td>
		<th></th>
		<td></td>
	</tr>
	<tr>
		<th>修改人</th>
		<td><input name="tblQuestions.changer" valType="required" msg="<font color=red>*</font>修改人不能为空"/></td>
		<th></th>
		<td></td>
		<th></th>
		<td></td>
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