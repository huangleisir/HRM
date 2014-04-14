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
<script src="script/jquery.1.7.2.min.js"></script>
<script type="text/javascript">
$(function($){
	/* $("input[name='tblSecondClass.secondKindId']").bind("blur",function(){ */
    	$.ajax({
    		url:"MajorClassifyAction!findAll.action",
    		type:"post",
    		
    		success:function(data){
    			var list=data.resultlist;
    			/* $.each(list, function(i,n){
    				alert(n.firstKindName);
    			}); */
    			var sI=$("select[name='tblMajorName.majorKindId']");
    			$.each(list, function(i,n){
    				sI.append("<option value="+n.majorKindId+" id="+n.majorKindName+">"+n.majorKindId+"</option>");
    			});
    			
    		}
    	});
	/* });  */
    });
    
$(function($){
	 $("select[name='tblMajorName.majorKindId']").bind("change",function(){
		 var v=$("select[name='tblMajorName.majorKindId']").find('option:selected').attr('id');
		 $("input[name='tblMajorName.majorKindName']").val(v);
	 }); 
    });
</script>
</head>
<body>

<div class="page_title">人力资源&nbsp; &gt; 客户化设置&nbsp; &gt; 职称设置</div>
<form action="tblMajorNameAction!save.action" method="post" onsubmit="return checkIXall();">
<div class="button_bar">
	<button class="common_button" onclick="back();">返回</button>
	<button type="submit" class="common_button" onclick="javaScript: return confirm('确定提交吗？') ">提交</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>职称类型编号</th>
		<td>
		<select name="tblMajorName.majorKindId">
			<option name="o1">请选择</option>
		</select>
		</td>
		<th>职称类型名称</th>
		<td><input readonly="readonly" name="tblMajorName.majorKindName" value=""/></td>
	</tr>
	<tr>
		<th>职称编号</th>
		<td>
		<input id="id" name="tblMajorName.majorId" size="20" onblur="return checkIXid();"/><span id="tipid" class="red_star">*</span>
		</td>
		<th>职称名称</th>
		<td>
		<input id="name" name="tblMajorName.majorName" size="20" onblur="return checkIXname();"/><span id="tipname" class="red_star">*</span>
		</td>
		<th>测试数量</th>
		<td>
		<input id=count name="tblMajorName.testAmount" size="20" onblur="return checkIXcount();"/><span id="tipcount" class="red_star">*</span>
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