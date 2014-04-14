<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tangs" uri="/WEB-INF/pages.tld"%>   
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href=" <%=basePath%>">
<script src="html/script/check.js"></script>
<script src="script/jquery.1.7.2.min.js"></script>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body >
<table WIDTH=800 BORDER=0 CELLPADDING=0 CELLSPACING=0>
 	<tr><td><img src="images/login/login_01.jpg" /></td></tr>
</table>
</body>
</html>