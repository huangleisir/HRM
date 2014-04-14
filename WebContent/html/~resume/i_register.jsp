<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-dojo-tags" prefix="sx"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<sx:head parseContent="true" />
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
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
$(function() {
	$.getJSON("bindPublicAction!bind.action", function(data) {
		var pubAttrs = data.attrList;
		for ( var i = 0; i < pubAttrs.length; i++) {
			var pkind = pubAttrs[i];
			if (pkind.attributeKind == "爱好")
				$("#humanHobby").append(
						"<option value=" + pkind.attributeName + ">"
								+ pkind.attributeName + "</option>");
			if (pkind.attributeKind == "国籍")
				$("#humanNationality").append(
						"<option value=" + pkind.attributeName + ">"
								+ pkind.attributeName + "</option>");
			if (pkind.attributeKind == "民族")
				$("#humanRace").append(
						"<option value=" + pkind.attributeName + ">"
								+ pkind.attributeName + "</option>");
			if (pkind.attributeKind == "宗教信仰")
				$("#humanReligion").append(
						"<option value=" + pkind.attributeName + ">"
								+ pkind.attributeName + "</option>");
			if (pkind.attributeKind == "政治面貌")
				$("#humanParty").append(
						"<option value=" + pkind.attributeName + ">"
								+ pkind.attributeName + "</option>");
			if (pkind.attributeKind == "教育年限")
				$("#humanEducatedYears").append(
						"<option value=" + pkind.attributeName + ">"
								+ pkind.attributeName + "</option>");
			if (pkind.attributeKind == "专业")
				$("#humanEducatedMajor").append(
						"<option value=" + pkind.attributeName + ">"
								+ pkind.attributeName + "</option>");
			if (pkind.attributeKind == "学历")
				$("#humanEducatedDegree").append(
						"<option value=" + pkind.attributeName + ">"
								+ pkind.attributeName + "</option>");
			if (pkind.attributeKind == "特长")
				$("#humanSpecility").append(
						"<option value=" + pkind.attributeName + ">"
								+ pkind.attributeName + "</option>");
		}
	});
	var vali=new Validators();
	$("#btn").bind("click", vali.subByJs);
});
</script>
</head>
<body>
	<div class="page_title">简历管理  &gt; 职位申请 </div>
	<form action="tblResumeAction!save.action"
		method="post">
		<div class="button_bar">
			<input type="submit" class="common_button" value="提交" id="btn"> 
			<input type="reset" class="common_button" value="重置">
		</div>
		<table class="query_form_table">
			<tr>
				<th>职位分类</th>
				<td>
					<input type="hidden" name="res.humaMajorKindName" value="<s:property value='tblPositionRelease.majorKindName'/>">
					<input type="hidden" name="res.humanMajorKindId" value="<s:property value='tblPositionRelease.majorKindId'/>" >
					<input disabled value="<s:property value='tblPositionRelease.majorKindName'/>"/>
				</td>
				<th>职位名称</th>
				<td>
					<input type="hidden" name="res.humanMajorName" value="<s:property value='tblPositionRelease.majorName'/>">
					<input type="hidden" name="res.humanMajorId" value="<s:property value='tblPositionRelease.majorId'/>" >
					<input disabled value="<s:property value='tblPositionRelease.majorName'/>"/>
				</td>
				<th>招聘类型</th>
				<td>
					<input type="hidden" name="res.engageType" value="<s:property value='tblPositionRelease.engageType'/>" >
					<input disabled value="<s:property value='tblPositionRelease.engageType'/>"/>
				</td>
			</tr>
			<tr>
				<th>姓名</th>
				<td><input name="res.humanName" valType="required" msg="<font color=red>*</font>不能为空"/>
				</td>
				<th>性别</th>
				<td><select name="res.humanSex">
						<option value="女">女</option>
						<option value="男">男</option>
				</select>
				</td>
				<th>Email</th>
				<td><input id="humanEmail" name="res.humanEmail" valType="MAIL" msg="<font color=red>*</font>电子邮箱格式不正确"/>
				</td>
			</tr>
			<tr>
				<th>电话</th>
				<td><input name="res.humanTelephone" valType="TEL" msg="<font color=red>*</font>电话格式不正确"/>
				</td>
				<th>家庭电话</th>
				<td><input name="res.humanHomephone" valType="TEL" msg="<font color=red>*</font>电话格式不正确"/>
				</td>
				<th>手机</th>
				<td><input name="res.humanMobilephone" valType="MOBILE" msg="<font color=red>*</font>手机格式不正确"/>
				</td>
			</tr>
			<tr>
				<th>爱好</th>
				<td><select id="humanHobby" name="res.humanHobby">
						<option value="#">请选择</option>
				</select>
				</td>
				<th></th>
				<td></td>
				<th></th>
				<td></td>
			</tr>
			<tr>
				<th>住址</th>
				<td colspan="3"><input id="humanAddress" name="res.humanAddress" valType="required" msg="<font color=red>*</font>不能为空"/>
				</td>
				<th>邮编</th>
				<td><input id="humanPostcode" name="res.humanPostcode" valType="OTHER" regString="^[0-9]{6}$" msg="<font color=red>*</font>6位数字"/>
				</td>
			</tr>
			<tr>
				<th>国籍</th>
				<td><select id="humanNationality" name="res.humanNationality">
						<option value="#">请选择</option>
				</select>
				</td>
				<th>出生地</th>
				<td><input id="humanBirthplace" name="res.humanBirthplace" />
				</td>
				<th>生日</th>
				<td>
					<sx:datetimepicker name="res.humanBirthday" displayFormat="yyyy-MM-dd" />
				</td>
			</tr>
			<tr>
				<th>民族</th>
				<td><select id="humanRace" name="res.humanRace">
						<option value="#">请选择</option>
				</select>
				</td>
				<th>宗教信仰</th>
				<td><select id="humanReligion" name="res.humanReligion">
						<option value="#">请选择</option>
				</select>
				</td>
				<th>政治面貌</th>
				<td><select id="humanParty" name="res.humanParty">
						<option value="#">请选择</option>
				</select>
				</td>
			</tr>
			<tr>
				<th>身份证号码</th>
				<td><input id="humanIdcard" name="res.humanIdcard" valType="IDENTITY" msg="<font color=red>*</font>身份证号码格式不正确"/>
				</td>
				<th>年龄</th>
				<td><input id="humanAge" name="res.humanAge" valType="NUMBER" msg="<font color=red>*</font>只能是数字"/>
				</td>
				<th>毕业学校</th>
				<td><input id="humanCollege" name="res.humanCollege" valType="required" msg="<font color=red>*</font>不能为空"/>
				</td>
			</tr>
			<tr>
				<th>专业</th>
				<td><select id="humanEducatedMajor" name="res.humanEducatedMajor">
						<option value="#">请选择</option>
				</select>
				</td>
				<th>教育年限</th>
				<td><select id="humanEducatedYears" name="res.humanEducatedYears">
						<option value="#">请选择</option>
				</select>
				</td>
				<th>学历</th>
				<td><select id="humanEducatedDegree" name="res.humanEducatedDegree">
						<option value="#">请选择</option>
				</select>
				</td>
			</tr>
			<tr>
				<th>薪酬要求</th>
				<td><input id="demandSalaryStandard" name="res.demandSalaryStandard" valType="NUMBER" msg="<font color=red>*</font>只能是数字"/>
				</td>
				<th>注册时间</th>
				<td><sx:datetimepicker name="res.registTime" displayFormat="yyyy-MM-dd" />
				</td>
				<th>特长</th>
				<td><select id="humanSpecility" name="res.humanSpecility">
						<option value="#">请选择</option>
				</select>
				</td>
			</tr>
			<tr>
				<th>个人履历</th>
				<td colspan="5"><textarea id="humanHistoryRecords"
						name="res.humanHistoryRecords" rows="6" cols="50" valType="required" msg="<font color=red>*</font>不能为空"></textarea>
				</td>
			</tr>
			<tr>
				<th>备注</th>
				<td colspan="5"><textarea id="remark" name="res.remark"
						rows="6" cols="50" valType="required" msg="<font color=red>*</font>不能为空"></textarea>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>