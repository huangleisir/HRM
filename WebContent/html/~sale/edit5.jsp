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
<form action="tblMajorClassifyAction!save.action" method="post" onsubmit="return checkXall();">
<div class="button_bar">
	<button class="common_button" onclick="back();">返回</button>
	<button type="submit" class="common_button" onclick="javaScript: return confirm('确定提交吗？') ">提交</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>职位分类编号</th>
			<td>
				<input id="id" name="tblMajorClassify.majorKindId" size="20" onblur="return checkXid();"/><span id="tipid" class="red_star">*</span>
			</td>
		
		<th>职位分类名称</th>
			<td>
				<input id="name" name="tblMajorClassify.majorKindName" size="20" onblur="return checkXname();"/><span id="tipname" class="red_star">*</span>
			</td>
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