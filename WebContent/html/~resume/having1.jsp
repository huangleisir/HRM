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
	jQuery(function($) {
		//绑定职位种类
		$.getJSON("bindAction!bindMajorKind.action", function(data) {
			//必须用eval把字符串转换成json   
			//data.firstKind为json对象中firstKind数组
			var mjkinds = eval(data.majorKind);
			//设置一级机构的select 的size为数组长度
			$("#mjkind").attr("size", mjkinds.length);
			// 遍历firstKind数组
			for ( var i = 0; i < mjkinds.length; i++) {
				// json对象中的一个元素            
				var mjkind = mjkinds[i];
				// 创建一个option             
				var option = document.createElement("option");
				$(option).attr("value", mjkind.majorKindId);
				$(option).html(mjkind.majorKindName);
				//添加到select下
				document.getElementById("mjkind").appendChild(option);
			}
		});
		$("#start").bind("click", function() {
			location.href='tblResumeAction!valid.action?mjkid='+$("#mjkind").val();
		});

	});
</script>
</head>
<body>
	<div class="page_title">简历管理  &gt; 有效简历查询 </div>

	<div class="button_bar">
		<input id="start" type="button" class="common_button" value="开始">
	</div>
	<table class="query_form_table">
		<tr>
			<th>职位分类</th>
			<td><select id="mjkind" name="tblPositionRelease.majorKindId">
			</select></td>
		</tr>
	</table>
	<br>
	<br>
	<br>
	<br>
	<br>
	<h3>查询结果</h3>
	<table class="data_list_table">
		<tr>
			<th>姓名</th>
			<th>性别</th>
			<th>年龄</th>
			<th>学历</th>
			<th>专业</th>
		</tr>
		<s:iterator value="list" status="stat" var="resume">
			<tr>
				<td class="list_data_text">
				<s:property value='#resume.humanName'/>  
				</td>
				<td class="list_data_text">
				<s:property value='#resume.humanSex'/>
				</td>
				<td class="list_data_number">
				<s:property value='#resume.humanAge'/>
				</td>
				<td class="list_data_text">
				<s:property value='#resume.humanEducatedDegree'/>
				</td>
				<td class="list_data_text">
				<s:property value='#resume.humanEducatedMajor'/>
				</td>
			</tr>
		</s:iterator>
		<tr>
				<th colspan="5" class="pager">
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