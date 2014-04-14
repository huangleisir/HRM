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
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="html/css/style.css" rel="stylesheet" type="text/css">
<script src="script/jquery.1.7.2.min.js"></script>
<script src="html/script/check.js"></script>
<script src="html/script/common.js"></script>
<script type="text/javascript">
$(function($){
	/* $("input[name='tblSecondClass.secondKindId']").bind("blur",function(){ */
    	$.ajax({
    		url:"FirstClassAction!findAll.action",
    		type:"post",
    		
    		success:function(data){
    			var list=data.resultlist;
    			/* $.each(list, function(i,n){
    				alert(n.firstKindName);
    			}); */
    			var sI=$("select[name='tblSecondClass.firstKindId']");
    			$.each(list, function(i,n){
    				sI.append("<option value="+n.firstKindId+" id="+n.firstKindName+">"+n.firstKindId+"</option>");
    			});
    			
    		}
    	});
	/* });  */
    });
    
$(function($){
	 $("select[name='tblSecondClass.firstKindId']").bind("change",function(){
		 var v=$("select[name='tblSecondClass.firstKindId']").find('option:selected').attr('id');
		 $("input[name='tblSecondClass.firstKindName']").val(v);
	 }); 
    });
</script>

</head>
<body>

<div class="page_title">人力资源&nbsp; &gt; 客户化设置&nbsp; &gt; II级机构设置</div>
<form action="tblSecondClassAction!save.action" method="post" onsubmit="return checkIIall();">
<div class="button_bar">
	<button class="common_button" onclick="back();">返回</button>
	<button type="submit" class="common_button" onclick="javaScript: return confirm('确定提交吗？') ">提交</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>I级机构编号</th>
		<td>
		<select name="tblSecondClass.firstKindId">
		<option>请选择</option>
		</select>
		</td>
	</tr>
	<tr>
		<th>I级机构名称</th>
		<td><input readonly="readonly" name="tblSecondClass.firstKindName" value=""/></td>
	</tr>
	<tr>
		<th>II级机构编号</th>
		<td><input id="id" name="tblSecondClass.secondKindId" value="" onblur="checkIIid();"/><span id="tipid" class="red_star">*</span></td>
	</tr>
	<tr>
		<th>II级机构名称</th>
		<td><input id="name" name="tblSecondClass.secondKindName" value="" onblur="checkIIname();"/><span id="tipname" class="red_star">*</span></td>
	</tr>	
	<tr>
		<th>薪酬发放责任人编号（多个编号之间请用“半角逗号”加“一个空格”隔开，如“，”）</th>
		<td colspan="3"><textarea id="salary"  name="tblSecondClass.secondSalaryId" rows="6" cols="50" name="S1" onblur="checkIIsalary();">...</textarea><span id="tipsalary" class="red_star">*</span></td>
	</tr>
	<tr>
		<th>销售责任人编号（多个编号之间请用“半角逗号”加“一个空格”隔开，如“，”）</th>
		<td colspan="3"><textarea id="sale"  name="tblSecondClass.secondSaleId" rows="6" cols="50" name="S1" onblur="checkIIsale();" >...</textarea><span id="tipsale" class="red_star">*</span></td>
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