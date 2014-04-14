<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="/struts-dojo-tags" prefix="sx"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	//点击修改按钮时页面变成可编辑状态的事件处理
	$(function(){
		var vali=new Validators();
		
		$("#save").hide();
		$("#save").bind("click", vali.subByJs);
		/* $("#save").bind("click",function(){
			$("form:first").submit();
		}); */
		
	});
	function change(){
		$("*[disabled]").removeAttr("disabled");
		$("#save").show();
	 	$.getJSON("bindPublicAction!bind.action", function(data) {
			var pubAttrs = data.attrList;
			for ( var i = 0; i < pubAttrs.length; i++) {
				var pkind = pubAttrs[i];
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
	}
</script>
</head>
<body>

<div class="page_title">简历管理 &gt; 简历筛选 </div>
<form action="tblResumeAction!update.action" method="post">
<table class="query_form_table">
	<tr>
		<th></th>
		<td colspan="5"> <input id="button" type="button" onclick="change()" value="修改" class="common_button"/>
			<input id="save" type="submit"  value="保存" class="common_button"/>
		</td>
	</tr> 
	<tr>
		<th>职位分类</th>
		<td>
			<input type="hidden" name="res.resId" value="<s:property value='res.resId'/>">
			<input disabled value="<s:property value='res.humaMajorKindName'/>" name="res.humaMajorKindName"/>
			<%-- <input type="hidden" name="res.humaMajorKindName" value="<s:property value='res.humaMajorKindName'/>"> --%>
			<input type="hidden" value="<s:property value='res.humanMajorKindId'/>" name="res.humanMajorKindId">
		</td>
		<th>爱好</th>
		<td><input disabled id="humanHobby" value="<s:property value='res.humanHobby'/>" name="res.humanHobby"/></td>
		<th>招聘类型</th>
		<td><select disabled name="res.engageType">
			<option value="社会招聘" <s:if test='res.engageType=="社会招聘"'> selected="selected"</s:if> >社会招聘</option>
			<option value="校园招聘" <s:if test='res.engageType=="校园招聘"'> selected="selected"</s:if> >校园招聘</option>
		</select></td>
	</tr>
	<tr>
		<th>姓名</th>
		<td><input disabled name="res.humanName" value="<s:property value='res.humanName'/>"  valType="required" msg="<font color=red>*</font>不能为空"/></td>
		<th>性别</th>
		<td><select disabled name="res.humanSex" >
			<option value="女" <s:if test='res.humanSex=="女"'> selected="selected"</s:if> >女</option>
			<option value="男" <s:if test='res.humanSex=="男"'> selected="selected"</s:if> >男</option>
		</select></td>
		<th>Email</th>
		<td><input disabled name="res.humanEmail" value="<s:property value='res.humanEmail'/>" valType="MAIL" msg="<font color=red>*</font>电子邮箱格式不正确"/></td>
	</tr>
	<tr>
		<th>电话</th>
		<td><input disabled name="res.humanTelephone" value="<s:property value='res.humanTelephone'/>"  valType="TEL" msg="<font color=red>*</font>电话格式不正确"/></td>
		<th>家庭电话</th>
		<td><input disabled name="res.humanHomephone" value="<s:property value='res.humanHomephone'/>" valType="TEL" msg="<font color=red>*</font>电话格式不正确"/></td>
		<th>手机</th>
		<td><input disabled name="res.humanMobilephone" value="<s:property value='res.humanMobilephone'/>" valType="MOBILE" msg="<font color=red>*</font>手机格式不正确"/></td>
	</tr>
	<tr>
		<th>住址</th>
		<td colspan="3"><input size="100" disabled name="res.humanAddress" value="<s:property value='res.humanAddress'/>" valType="required" msg="<font color=red>*</font>不能为空"/></td>
		<th>邮编</th>
		<td><input disabled name="res.humanPostcode" value="<s:property value='res.humanPostcode'/>" valType="OTHER" regString="^[0-9]{6}$" msg="<font color=red>*</font>6位数字"/></td>
	</tr>
	<tr>
		<th>国籍</th>
		<td><select disabled id="humanNationality" name="res.humanNationality">
 			<option  selected="selected" value="<s:property value='res.humanNationality'/>"><s:property value='res.humanNationality'/></option>
 		</select></td>
		<th>出生地</th>
		<td><input disabled name="res.humanBirthplace" value="<s:property value='res.humanBirthplace'/>" /></td>
		<th>生日</th>
		<td><sx:datetimepicker name="res.humanBirthday" displayFormat="yyyy-MM-dd" value="<s:property value='res.humanBirthday'/>"/></td>
	</tr>
	<tr>
		<th>民族</th>
		<td><select id="humanRace" disabled name="res.humanRace">
		<option selected="selected" value="<s:property value='res.humanRace'/>"><s:property value='res.humanRace'/></option>
		</select></td>
		<th>宗教信仰</th>
		<td><select id="humanReligion" disabled name="res.humanReligion">
		 <option selected="selected" value="<s:property value='res.humanReligion'/>"><s:property value='res.humanReligion'/></option>
		</select></td>
		<th>政治面貌</th>
		<td><select id="humanParty" disabled name="res.humanParty">
			<option selected="selected" value="<s:property value='res.humanParty'/>"><s:property value='res.humanParty'/></option>
		</select></td>
	</tr>
	<tr>
		<th>身份证号码</th>
		<td><input disabled name="res.humanIdcard" value="<s:property value='res.humanIdcard'/>" valType="IDENTITY" msg="<font color=red>*</font>身份证号码格式不正确"/></td>
		<th>年龄</th>
		<td><input disabled name="res.humanAge" value="<s:property value='res.humanAge'/>" valType="NUMBER" msg="<font color=red>*</font>只能是数字"/></td>
		<th>毕业学校</th>
		<td><input disabled name="res.humanCollege" value="<s:property value='res.humanCollege'/>" valType="required" msg="<font color=red>*</font>不能为空"/></td>
	</tr>
	<tr>
		<th>学历</th>
		<td><select id="humanEducatedDegree" disabled name="res.humanEducatedDegree">
			<option selected="selected" value="<s:property value='res.humanEducatedDegree'/>"><s:property value='res.humanEducatedDegree'/></option>
		</select></td>
		<th>教育年限</th>
		<td><select id="humanEducatedYears" disabled name="res.humanEducatedYears">
			<option selected="selected" value="<s:property value='res.humanEducatedYears'/>"><s:property value='res.humanEducatedYears'/></option>
		</select></td>
		<th>学历专业</th>
		<td><select id="humanEducatedMajor" disabled name="res.humanEducatedMajor">
			<option selected="selected" value="<s:property value='res.humanEducatedMajor'/>"><s:property value='res.humanEducatedMajor'/></option>
 		</select></td>
	</tr>
	<tr>
		<th>薪酬要求</th>
		<td><input disabled name="res.demandSalaryStandard" value="<s:property value='res.demandSalaryStandard'/>" valType="OTHER" regString="^[0-9\.]*$" msg="<font color=red>*</font>数字/金额"/></td>
		<th>注册时间</th>
		<td><sx:datetimepicker name="res.registTime" displayFormat="yyyy-MM-dd" value="<s:property value='res.registTime'/>"/></td>
		<th>特长</th>
		<td><select id="humanSpecility" disabled name="res.humanSpecility">
 			<option selected="selected" value="<s:property value='res.humanSpecility'/>"><s:property value='res.humanSpecility'/></option>
		</select></td>
	</tr>
	<tr>
		<th>个人履历</th>
		<td colspan="5"><textarea rows="6" cols="100" name="res.humanHistoryRecords" valType="required" msg="<font color=red>*</font>不能为空"><s:property value='res.humanHistoryRecords'/></textarea></td>
	</tr>
	<tr>
		<th>备注</th>
		<td colspan="5"><textarea rows="6" cols="100" name="res.remark" valType="required" msg="<font color=red>*</font>不能为空"><s:property value='res.remark'/></textarea></td>
	</tr>
	<tr>
		<th>推荐意见</th>
		<td colspan="3"><textarea disabled rows="6" cols="100" name="res.recomandation" valType="required" msg="<font color=red>*</font>不能为空"><s:property value='res.recomandation'/></textarea><span class="red_star">*</span></td>
		<th>推荐面试</th>
		<td>
			<input type="hidden" name="res.interviewStatus" value="0">
			<select disabled name="res.checkStatus" >
			<option value="1" <s:if test='res.checkStatus==1'> selected="selected"</s:if> >是</option>
			<option value="0" <s:if test='res.checkStatus==0'> selected="selected"</s:if> >否</option>
		</select>
		</td>
	</tr>
	<tr>
		<th>推荐人</th>
		<td colspan="5"> <input disabled name="res.checker" value="<s:property value='res.checker'/>" valType="required" msg="<font color=red>*</font>不能为空"/></td>
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