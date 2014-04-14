<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="/struts-dojo-tags" prefix="sx"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sx:head parseContent="true"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="tblFirstClassAction!save.action" method="post">
		<table>
			<tr><td>ffkId</td><td><input type="text" name="tblFirstClass.ffkId"/><sx:datetimepicker displayFormat="yyyy-MM-dd" name="timer" id="timer"></sx:datetimepicker></td></tr>
			<tr><td>firstKindId</td><td><input type="text" name="tblFirstClass.firstKindId"/></td></tr>
			<tr><td>firstKindName</td><td><input type="text" name="tblFirstClass.firstKindName"/></td></tr>
			<tr><td>firstKindSalaryId</td><td><input type="text" name="tblFirstClass.firstKindSalaryId"/></td></tr>
			<tr><td>firstKindSaleId</td><td><input type="text" name="tblFirstClass.firstKindSaleId"/></td></tr>
			<tr><td><input type="submit" value="提交"/></td></tr>			
		</table>
	</form>
</body>
</html>