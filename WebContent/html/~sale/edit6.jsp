<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tangs" uri="/WEB-INF/pages.tld"%>   
<%@ taglib prefix="s" uri="/struts-tags" %>
<%    
String path = request.getContextPath();    
// 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是 http://localhost:8080/MyApp/）:    
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";    
%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="html/css/style.css" rel="stylesheet" type="text/css">
<script src="html/script/check.js"></script>
<script src="html/script/common.js"></script>
</head>
<body>

<div class="page_title">人力资源&nbsp; &gt; 客户化设置&nbsp; &gt; 职位分类设置</div>
<form action="tblPublicAttributeAction!save.action" method="post" onsubmit="return checkXIall();">
<div class="button_bar">
	<button type="submit" class="common_button" onclick="javaScript: return confirm('确定提交吗？') ">提交</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>属性种类</th>
		<td>
		<input id="id" name="tblPublicAttribute.attributeKind" size="20" onblur="return checkXIid();"/><span id="tipid" class="red_star">*</span>
		</td>
	<tr>
		<th>属性名称</th>
		<td>
		<input id="name" name="tblPublicAttribute.attributeName" size="20" onblur="return checkXIname();"/><span id="tipname" class="red_star">*</span>
		</td>
	
</table>
<br />
</form>
<script>
	setCurTime('t1');
	setCurTime('t2');
</script>
</body>
</html>