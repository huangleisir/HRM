<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="tangs" uri="/WEB-INF/pages.tld"%>   
<%@ taglib prefix="s" uri="/struts-tags" %>
<%    
String path = request.getContextPath();    
// 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是 http://localhost:8080/MyApp/）:    
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";    
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<title>修改密码</title>
</head>
<body>
<form action="tblUserAction!updatePassword.action" method="post">
用户名：<input name="tbluser.UName" readonly="readonly" value="<s:property value='#session.tbluser.UName' />" valType="required" msg="<font color=red>*</font>不能为空"/><br/>
旧密码：<input value="<s:property value='#session.tbluser.UPassword' />" valType="required" msg="<font color=red>*</font>不能为空"/><br/>
新密码：<input name="tbluser.UPassword" valType="required" msg="<font color=red>*</font>录用申请审核意见不能为空"/><br/>
<input type="submit" name="" value="提交"/>    <input type="button" name="" value="返回" onclick="window.location.href='mywork.htm'" />

</form>
</body>
</html>