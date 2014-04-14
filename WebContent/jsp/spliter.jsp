<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tangs" uri="/WEB-INF/pages.tld"%>   
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="tblFirstClassAction!save.action" method="post">
		<table>
			<s:iterator value="list" status="stat" var="tblFirstClass">
	            <tr>   
	                <td>
	               		<a href="tblFirstClassAction!modify.action?tblFirstClass.ffkId=<s:property value='#tblFirstClass.ffkId' />"><s:property value="#tblFirstClass.firstKindName"/></a>
	                 	<a href="tblFirstClassAction!delete.action?tblFirstClass.ffkId=<s:property value='#tblFirstClass.ffkId' />">删除</a>
	                </td>
                    </tr>
	        </s:iterator> 
		</table>
			共 <s:property value="totalPage"/> 页 第 <s:property value="pageNo"/> 页<br><br>   
  			  <tangs:pages pageNo="pageNo" total="totalPage"  styleClass="page" theme="number"/>   
	</form>
</body>
</html>