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
$(function() {
	var vali=new Validators();
	$("#btn").bind("click", vali.subByJs);
});
</script>
</head>
<body>
<form action="tblInterviewAction!update.action" method="post">
<div class="page_title">面试管理  &gt; 面试筛选 </div>
<div class="button_bar">
	<select name="op">
		<option value="1">建议录用</option>
		<option value="2">建议面试</option>
		<option value="3">建议笔试</option>
		<option value="4">删除</option>
	</select>
	<input type="submit" class="common_button" value="提交" id="btn"> 
	<input type="reset" class="common_button" value="返回">
</div>
<table class="query_form_table" >
	<tr>
		<th>职位分类</th>
		<td>
			<input disabled value="<s:property value='resume.humaMajorKindName'/>" name="interview.humanMajorKindName"/>
			<input type="hidden" value="<s:property value='resume.humanMajorKindId'/>" name="interview.humanMajorKindId">
			<input type="hidden" value="<s:property value='resume.humaMajorKindName'/>" name="interview.humanMajorKindName">
		</td>
		<th>职位名称</th>
		<td>
			<input disabled value="<s:property value='resume.humanMajorName'/>" name="interview.humanMajorName"/>
			<input type="hidden" value="<s:property value='resume.humanMajorId'/>" name="interview.humanMajorId">
			<input type="hidden" value="<s:property value='resume.humanMajorName'/>" name="interview.humanMajorName">
		</td>
		<th>招聘类型</th>
		<td >
			<input disabled value="<s:property value='resume.engageType'/>"/>
		</td>
	</tr>
	<tr>
	</tr>
	<tr>
		<th>姓名</th>
		<td><input disabled name="interview.humanName" value="<s:property value='resume.humanName'/>"/>
		<input type="hidden" name="interview.humanName" value="<s:property value='resume.humanName'/>"/>
		</td>
		<th>性别</th>
		<td><input disabled  value="<s:property value='resume.humanSex'/>"/></td>
		<th>E-MAIL</th>
		<td><input disabled  value="<s:property value='resume.humanEmail'/>"/></td>
	</tr>
	<tr>
		<th>电话</th>
		<td><input disabled  value="<s:property value='resume.humanTelephone'/>" /></td>
		<th>家庭电话</th>
		<td><input disabled  value="<s:property value='resume.humanHomephone'/>" /></td>
		<th>手机</th>
		<td><input disabled  value="<s:property value='resume.humanMobilephone'/>" /></td>
	</tr>	
	<tr>
		<TH>住址</TH>
		<td colspan="3">
		<input size="100" disabled  value="<s:property value='resume.humanAddress'/>"/>
		</td>
		<th>邮编</th>
		<td><input disabled  value="<s:property value='resume.humanPostcode'/>"/></td>
	</tr>
	<tr>
		
		<th>国籍</th>
		<td><input disabled  value="<s:property value='resume.humanNationality'/>"/></td>
		<th>出生地</th>
		<td><input disabled  value="<s:property value='resume.humanBirthplace'/>"/></td>
		<th>生日</th>
		<td><input disabled  value="<s:property value='resume.humanBirthday'/>"/></td>
	</tr>
	<tr>
		<th>民族</th>
		<td><input disabled  value="<s:property value='resume.humanRace'/>"/></td>
		<th>宗教信仰</th>
		<td><input disabled  value="<s:property value='resume.humanReligion'/>"/></td>
		<th>政治面貌</th>
		<td><input disabled  value="<s:property value='resume.humanParty'/>"/></td>
	</tr>
	<tr>
		<th>身份号码</th>
		<td><input disabled  value="<s:property value='resume.humanIdcard'/>"/></td>
		<th>年龄</th>
		<td><input disabled  value="<s:property value='resume.humanAge'/>"/></td>
		<th>毕业学校</th>
		<td><input disabled  value="<s:property value='resume.humanCollege'/>"/></td>
	</tr>
	<tr>
		<th>学历</th>
		<td><input disabled  value="<s:property value='resume.humanEducatedDegree'/>"/></td>
		<th>教育年限</th>
		<td><input disabled  value="<s:property value='humanEducatedYears'/>"/></td>
		<th>学历专业</th>
		<td><input disabled  value="<s:property value='humanEducatedMajor'/>"/></td>
	</tr>
	<tr>
		<th>薪酬要求</th>
		<td><input disabled  value="<s:property value='resume.demandSalaryStandard'/>"/></td>
		<th>注册时间</th>
		<td><input disabled  value="<s:property value='resume.registTime'/>"/></td>
		<th>特长</th>
		<td><input disabled  value="<s:property value='resume.humanSpecility'/>"/></td>
	</tr>
	<tr>
		<th>爱好</th>
		<td><input disabled  value="<s:property value='resume.humanHobby'/>"/></td>
		<th>推荐人</th>
		<td><input disabled  value="<s:property value='resume.checker'/>"/></td>
		<th>推荐时间</th>
		<td><input disabled  value="<s:property value='resume.checkTime'/>"/></td>
	</tr>
	<tr>
		<th>个人履历</th>
		<td colspan="5"><textarea rows="6" cols="50"  disabled><s:property value='resume.humanHistoryRecords'/></textarea></td>
	</tr>
	<tr>
		<th>备注</th>
		<td colspan="5"><textarea rows="6" cols="50"  disabled><s:property value='resume.remark'/></textarea></td>
	</tr>
	<tr>
		<th>推荐意见</th>
		<td colspan="5"><textarea rows="6" cols="50"  disabled><s:property value='resume.recomandation'/></textarea></td>
	</tr>
	<tr>
		
		<th>面试次数</th>
		<td>
			<input  disabled name="interview.interviewAmount" value="<s:property value='interview.interviewAmount'/>"/>
		</td>
		<th>形象评价</th>
		<td>
		<input  disabled name="interview.imageDegree" value="<s:property value='interview.imageDegree'/>"/>
		</td>
		<th>口才评价</th>
		<td>
		<input  disabled name="interview.nativeLanguageDegree" value="<s:property value='interview.nativeLanguageDegree'/>"/>
		</td>
	</tr>
	<tr>
		<th>外语口语能力</th>
		<td>
		<input  disabled name="interview.foreignLanguageDegree" value="<s:property value='interview.foreignLanguageDegree'/>"/>
		</td>
		<th>应变能力</th>
		<td>
		<input  disabled name="interview.responseSpeedDegree" value="<s:property value='interview.responseSpeedDegree'/>"/>
		</td>
		<th>EQ</th>
		<td>
		<input  disabled name="interview.eqDegree" value="<s:property value='interview.eqDegree'/>"/>
		</td>
	</tr>
	<tr>
		<th>IQ</th>
		<td>
		<input  disabled name="interview.iqDegree" value="<s:property value='interview.iqDegree'/>"/>
		</td>
		<th>综合素质</th>
		<td>
		<input  disabled name="interview.multiQualityDegree" value="<s:property value='interview.multiQualityDegree'/>"/>
		</td>
		<th></th>
		<td></td>
	</tr>
	<tr>
		<th>面试人</th>
		<td>
		<input  disabled name="interview.register" value="<s:property value='interview.register'/>"/>
		</td>
		<th>面试时间</th>
		<td>
			<input  disabled name="interview.registerTime" value="<s:property value='interview.registerTime'/>"/>
		</td>
		<th></th>
		<td><input type="hidden" value="<s:property value='resume.resId'/>" name="interview.resumeId"></td>
		
	</tr>
	<tr>
		<th>面试评价</th>
		<td colspan="5"><textarea rows="6" cols="50" name="interview.interviewComment" disabled><s:property value='interview.interviewComment'/></textarea></td>
	</tr>
	<tr>
		<th>筛选人</th>
		<td><input type="text"  name="interview.checker" valType="required" msg="<font color=red>*</font>筛选人不能为空"></td>
		<th>筛选时间</th>
		<td>
			<sx:datetimepicker name="interview.checkTime" displayFormat="yyyy-MM-dd" />
		</td>
		<th></th>
		<td></td>
	</tr>
	<tr>
		<th>筛选意见</th>
		<td colspan="5"><textarea rows="6" cols="50" name="interview.checkComment" valType="required" msg="<font color=red>*</font>筛选意见不能为空"></textarea><span class="red_star">*</span></td>
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