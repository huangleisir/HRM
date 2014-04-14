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
<script src="html/script/common.js"></script>
<script src="html/script/check.js"></script>
</head>
<body>

<div class="page_title">人力资源&nbsp; &gt; 客户化设置&nbsp; &gt; I级机构设置</div>
<form action="tblFirstClassAction!save.action" method="post" onsubmit="return checkIall();">
<div class="button_bar">
	<!--<button class="common_button" onclick="help('');">帮助</button>
	--><button class="common_button" onclick="back();">返回</button>
	<button type="submit" class="common_button" onclick="javaScript: return confirm('确定提交吗？') ">提交</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>I级机构编号</th>
		<td><input id="tblfir" type="text" name="tblFirstClass.firstKindId" value="<s:property value='tblFirstClass.firstKindId' />" onblur="return checkIId();"/><span id="tipI" class="red_star">*</span></td>
		</tr>
	<tr>
		<th>I级机构名称</th>
		<td><input id="tblfirname" type="text" name="tblFirstClass.firstKindName" value="<s:property value='tblFirstClass.firstKindName' />" onblur="return checkIName()";/><span id="tipIname" class="red_star">*</span></td>
		</tr>	
	<tr>
		<th>薪酬发放责任人编号（多个编号之间请用“半角逗号”加“一个空格”隔开，如“，”）</th>
		<td colspan="3"><textarea id="salary" rows="6" cols="50" name="tblFirstClass.firstKindSalaryId" onblur="return checksalary();"><s:property value='tblFirstClass.firstKindSalaryId' /></textarea><span id="tipsalary" class="red_star">*</span></td>
	</tr>
	<tr>
		<th>销售责任人编号（多个编号之间请用“半角逗号”加“一个空格”隔开，如“，”）</th>
		<td colspan="3"><textarea id="sale" rows="6" cols="50" name="tblFirstClass.firstKindSaleId" onblur="return checksale();"><s:property value='tblFirstClass.firstKindSaleId' /></textarea><span id="tipsale" class="red_star">*</span></td>
	</tr>
	</table>
<br />
</form>
<script>
	setCurTime('t1');
	setCurTime('t2');
</script>
</body>
</html>