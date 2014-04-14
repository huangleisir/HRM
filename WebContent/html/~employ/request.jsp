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
<form action="tblInterviewAction!passUpdate.action" method="post">
<div class="page_title">录用管理  &gt; 录用申请 </div>
<div class="button_bar">
	<input type="submit" class="common_button" value="建议录用" id="btn"> 
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
		<td colspan="">
			<input disabled value="<s:property value='resume.engageType'/>"/>
		</td>
	</tr>
	<tr>
		<th>姓名</th>
		<td><input disabled name="interview.humanName" value="<s:property value='resume.humanName'/>"/>
		<input type="hidden" name="interview.humanName" value="<s:property value='resume.humanName'/>"/>
		</td>
		<th>性别</th>
		<td><input disabled  value="<s:property value='resume.humanSex'/>"/></td>
		<th>邮编</th>
		<td><input disabled  value="<s:property value='resume.humanPostcode'/>"/></td>
	</tr>
	<tr>
		<th>E-MAIL</th>
		<td><input disabled  value="<s:property value='resume.humanEmail'/>"/></td>
		<th>电话</th>
		<td><input disabled  value="<s:property value='resume.humanTelephone'/>" /></td>
		<TH>住址</TH>
		<td >
		<input size="100" disabled  value="<s:property value='resume.humanAddress'/>"/>
		</td>
		</tr>
	<tr>
		<th>家庭电话</th>
		<td><input disabled  value="<s:property value='resume.humanHomephone'/>" /></td>
		<th>手机</th>
		<td><input disabled  value="<s:property value='resume.humanMobilephone'/>" /></td>
		<th></th>
		<td></td>
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
		<td><input type="text" disabled="disabled" name="interview.checker" value="<s:property value='interview.checker'/>"></td>
		<th>筛选时间</th>
		<td>
			<input type="text" disabled="disabled" name="interview.checkTime" value="<s:property value='interview.checkTime'/>">
		</td>
		<th></th>
		<td></td>
	</tr>
	<tr>
		<th>筛选意见</th>
		<td colspan="5"><textarea rows="6" cols="50" disabled="disabled" name="interview.checkComment"><s:property value='interview.checkComment'/></textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>录用申请审核意见</th>
		<td colspan="5"><textarea rows="6" cols="50" name="resume.passPasscomment" valType="required" msg="<font color=red>*</font>录用申请审核意见不能为空"></textarea><span class="red_star">*</span></td>
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