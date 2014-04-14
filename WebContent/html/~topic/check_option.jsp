<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tangs" uri="/WEB-INF/pages.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script src="script/jquery.1.7.2.min.js"></script>
<script type="text/javascript">
$(function() {

	//绑定试题种类
	$.getJSON("bindQustionAction!bindFirst.action", function(data) {
		//必须用eval把字符串转换成json   
		//data.firstKind为json对象中firstKind数组
		var fqkinds = eval(data.firstQust);
		//设置一级机构的select 的size为数组长度
		$("#fq").attr("size", fqkinds.length);
		// 遍历firstKind数组
		for ( var i = 0; i <fqkinds.length; i++) {
			// json对象中的一个元素            
			var mjkind = fqkinds[i];
			// 创建一个option             
			var option = document.createElement("option");
			$(option).attr("value", mjkind.firstKindId);
			$(option).html(mjkind.firstKindName);
			//添加到select下
			document.getElementById("fq").appendChild(option);
		}
	});
	$("#start").bind("click", function() {
		location.href='tblQuestionsAction!spliter.action?fqkid='+$("#fq").val();
	});
	
 });
</script>
</head>
<body>

<div class="page_title">招聘考试题库管理  &gt; 试题查询 </div>
<div class="button_bar">
	<input id="start" type="button" class="common_button" value="开始">
</div>
<table class="query_form_table">
	<tr>
		<th>请选择试题分类</th>
		<td><select id="fq" name=""></select></td>
	</tr>
</table>
<br/>
<br/>
<table class="data_list_table">
	<tr>
		<th>题干</th>
		<th>试题I级分类</th>
		<th>试题I级分类</th>
		<th>登记人</th>
		<th>登记日期</th>
		<th>出处</th>
		<th>正确答案</th>
		<th>变更</th>
	</tr>
	
	<s:iterator value="list" status="stat" var="quest">
		<tr>
			<td class="list_data_text"><s:property value='#quest.content'/></td>
			<td class="list_data_text"><s:property value='#quest.firstKindName'/></td>
			<td class="list_data_text"><s:property value='#quest.secondKindName'/></td>
			<td class="list_data_text"><s:property value='#quest.register'/></td>
			<td class="list_data_ltext"><s:property value='#quest.registTime'/></td>
			<td class="list_data_text"><s:property value='#quest.derivation'/></td>
			<td class="list_data_text"><s:property value='#quest.correctKey'/></td>
			<td class="list_data_text"><a href="tblQuestionsAction!check.action?tblQuestions.subId=<s:property value='#quest.subId'/>">变更</a></td>
		</tr>
	</s:iterator>	
	<tr>
				<th colspan="8" class="pager">
					<div >
						共 <s:property value="totalPage"/> 页 第 <s:property value="pageNo"/> 页<br><br>   
  			 			 <tangs:pages pageNo="pageNo" total="totalPage"  styleClass="pager" theme="number"/>
					</div>
				</th>
			</tr>
</table>
<script>
	setCurTime('t1');
	setCurTime('t2');
	setCurTime('t3');
</script>
</body>
</html>