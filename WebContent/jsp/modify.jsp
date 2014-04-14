<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="tblFirstClassAction!update.action" method="post">
	<table>
		<tr>
			<td>ffk_id</td><td>ffk_name</td>
		</tr>
			<tr>
				<td>
					<input type="text" name="tblFirstClass.ffkId" value="<s:property value="tblFirstClass.ffkId"/>"/>
					<input type="text" name="tblFirstClass.firstKindName" value="<s:property value="tblFirstClass.firstKindName"/>"/>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"/></td>
			</tr>
	</table>
	</form>
</body>
</html>