<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-dojo-tags" prefix="sx"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<sx:head parseContent="true" />
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script src="script/jquery.1.7.2.min.js"></script>
<script type='text/javascript' src="lib/jquery.poshytip.js"></script>
<script type='text/javascript' src='lib/jq.validate.js'></script>
<link rel="stylesheet" type="text/css" href="main.css" />
	<link rel="stylesheet" href="lib/tip-yellowsimple/tip-yellowsimple.css" type="text/css" />
	<style type="text/css">
	.border {
		border:1px solid red;
	}
	td {
		padding:7px;
	}
	#labels {
		text-align:right;
	}
</style>
<script type="text/javascript">
	jQuery(function($) {
		//绑定一级机构
		$.getJSON("bindAction!bindFirst.action", function(data) {
			//必须用eval把字符串转换成json   
			//data.firstKind为json对象中firstKind数组
			var ffkinds = eval(data.firstKind);
			//设置一级机构的select 的size为数组长度
			$("#ffk").attr("size", "4");
			// 遍历firstKind数组
			for ( var i = 0; i < ffkinds.length; i++) {
				// json对象中的一个元素            
				var ffkind = ffkinds[i];
				// 创建一个option             
				var option = document.createElement("option");
				$(option).attr("value", ffkind.firstKindId);
				$(option).html(ffkind.firstKindName);
				if(i==0)
					$(option).attr("selected", "selected");
				//添加到select下
				document.getElementById("ffk").appendChild(option);
			}
		});
		
		//绑定职位种类
		$.getJSON("bindAction!bindMajorKind.action", function(data) {
			//必须用eval把字符串转换成json   
			//data.firstKind为json对象中firstKind数组
			var mjkinds = eval(data.majorKind);
			//设置一级机构的select 的size为数组长度
			//$("#mjkind").attr("size", mjkinds.length);
			// 遍历firstKind数组
			for ( var i = 0; i < mjkinds.length; i++) {
				// json对象中的一个元素            
				var mjkind = mjkinds[i];
				// 创建一个option             
				var option = document.createElement("option");
				$(option).attr("value", mjkind.majorKindId);
				$(option).html(mjkind.majorKindName);
				if(i==0)
					$(option).attr("selected", "selected");
				//添加到select下
				document.getElementById("mjkind").appendChild(option);
			}
		});
		
		var vali=new Validators();
		$("#btn").bind("click", vali.subByJs);
	});

	function getSecond(obj) {
		$("#fsk > option[value!='']").remove();
		$("#ftk > option[value!='']").remove();
		var ffkid = $(obj).val();
		$.getJSON("bindAction!bindSecond.action?ffkid="+ffkid, function(data) {
			//必须用eval把字符串转换成json   
			//data.secondKind为json对象中secondKind数组
			var fskinds = eval(data.secondKind);
			//设置一级机构的select 的size为数组长度
			
			//$("#fsk").attr("size", "4");
			// 遍历firstKind数组
			for ( var i = 0; i < fskinds.length; i++) {
				// json对象中的一个元素            
				var fskind = fskinds[i];
				// 创建一个option             
				var option = document.createElement("option");
				$(option).attr("value", fskind.secondKindId);
				$(option).html(fskind.secondKindName);
				if(i==0)
					$(option).attr("selected", "selected");
				//添加到select下
				document.getElementById("fsk").appendChild(option);
			}
		});
		$("#ffkn").val($("#ffk option:selected").html());
	}
	
	function getThird(obj) {
		$("#ftk > option[value!='']").remove();
		var fskid = $(obj).val();
		var ffkid =$("#ffk").val();
		$.getJSON("bindAction!bindThird.action?fskid="+fskid+"&ffkid="+ffkid, function(data) {
			//必须用eval把字符串转换成json   
			//data.secondKind为json对象中secondKind数组
			var ftkinds = eval(data.thirdKind);
			//设置一级机构的select 的size为数组长度
			$("#fsk").attr("size",ftkinds.length);
			// 遍历firstKind数组
			for ( var i = 0; i < ftkinds.length; i++) {
				// json对象中的一个元素            
				var ftkind = ftkinds[i];
				// 创建一个option             
				var option = document.createElement("option");
				$(option).attr("value", ftkind.secondKindId);
				$(option).html(ftkind.secondKindName);
				if(i==0)
					$(option).attr("selected", "selected");
				//添加到select下
				document.getElementById("ftk").appendChild(option);
			}
		});
		$("#fskn").val($("#fsk option:selected").html());
	}
	
	function getMjName(obj) {
		$("#mjname > option").remove();
		var mjkid = $(obj).val();
		$.getJSON("bindAction!bindMajorName.action?mjkId="+mjkid, function(data) {
			//必须用eval把字符串转换成json   
			//data.secondKind为json对象中secondKind数组
			var mjns = eval(data.majorName);
			//设置一级机构的select 的size为数组长度
			//$("#fsk").attr("size",ftkinds.length);
			// 遍历firstKind数组
			for ( var i = 0; i < mjns.length; i++) {
				// json对象中的一个元素            
				var mjn = mjns[i];
				// 创建一个option             
				var option = document.createElement("option");
				$(option).attr("value", mjn.majorId);
				$(option).html(mjn.majorName);
				//添加到select下
				document.getElementById("mjname").appendChild(option);
			}
		});
		$("#mjkn").val($("#mjkind option:selected").html());
	} 
	function getTname(){
		$("#ftkn").val($("#ftk option:selected").html());
	}
	function getMname(){
		$("#mjn").val($("#mjname option:selected").html());
	}
</script>
</head>
<body>
	<div class="page_title">职位发布管理  &gt; 职位发布登记 </div>
	<form action="tblPositionReleaseAction!save.action" method="post">
		<div class="button_bar">
			<input type="submit" class="common_button" value="提交" id="btn">
			<input type="reset" class="common_button" value="重置">
		</div>
		<table class="query_form_table">
			<tr>
				<th>I 级机构</th>
				<td>
					<input type="hidden" id="ffkn" name="tblPositionRelease.firstKindName">
					<select id="ffk" name="tblPositionRelease.firstKindId" onclick="getSecond(this)"  valType="required" msg="<font color=red>*</font>不能为空">
						<option value=""></option>
					</select>
				</td>
				<th>II 级机构</th>
				<td>
					<input type="hidden" id="fskn" name="tblPositionRelease.secondKindName">
					<select id="fsk" name="tblPositionRelease.secondKindId" onclick="getThird(this)"  valType="required" msg="<font color=red>*</font>不能为空"><option selected value="">请选择...</option></select></td>
				<th>III 级机构</th>
				<td>
					<input type="hidden" id="ftkn" name="tblPositionRelease.thirdKindName" >
				<select id="ftk" name="tblPositionRelease.thirdKindId" onclick="getTname()" valType="required" msg="<font color=red>*</font>不能为空"><option selected value="">请选择...</option></select></td>
			</tr>
			<tr>

				<th>招聘类型</th>
				<td><select name="tblPositionRelease.engageType">
						<option selected>社会招聘</option>
						<option>校园招聘</option>
				</select>
				</td>
				<th>职位分类</th>
				<td>
					<input type="hidden" id="mjkn" name="tblPositionRelease.majorKindName">
				<select id="mjkind" name="tblPositionRelease.majorKindId" onclick="getMjName(this)">
						<option>请选择...</option>
				</select>
				</td>
				<th>职位名称</th>
				<td>
					<input type="hidden" id="mjn" name="tblPositionRelease.majorName">
				<select id="mjname" name="tblPositionRelease.majorId" onclick="getMname()"></select></td>
			</tr>
			<tr>

				<th>招聘人数</th>
				<td><input name="tblPositionRelease.humanAmount" valType="NUMBER" msg="<font color=red>*</font>必须为数字且不能为空"/></td>
				<th>截止日期</th>
				<td colspan="3" id="time">
					<sx:datetimepicker name="tblPositionRelease.deadline" displayFormat="yyyy-MM-dd" value="%{'today'}"/>
				</td>
			</tr>
			<tr>
				<th>发布职位者</th>
				<td><input name="tblPositionRelease.register" valType="required" msg="<font color=red>*</font>发布人不能为空"/></td>
				<th>发布职位时间</th>
				<td colspan="3">
					<sx:datetimepicker name="tblPositionRelease.registTime" displayFormat="yyyy-MM-dd" value="%{'today'}"/>
				</td>
			</tr>
			<tr>
				<th>职位描述</th>
				<td colspan="5"><textarea rows="6" cols="50" name="tblPositionRelease.majorDescribe" valType="required" msg="<font color=red>*</font>不能为空"></textarea></td>
			</tr>
			<tr>
				<th>招聘要求</th>
				<td colspan="5"><textarea rows="6" cols="50" name="tblPositionRelease.engageRequired" valType="required" msg="<font color=red>*</font>不能为空"></textarea></td>
			</tr>
		</table>
	</form>
	<script>
		setCurTime('t1');
		setCurTime('t2');
		setCurTime('t3');
	</script>
</body>
</html>