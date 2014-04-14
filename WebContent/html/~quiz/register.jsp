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
<form action="tblInterviewAction!save.action" method="post">
<div class="page_title">面试管理  &gt; 面试结果登记 </div>
<div class="button_bar">
	<input type="submit" class="common_button" value="提交" id="btn"> 
	<input type="reset" class="common_button" value="返回" onclick="history.back()">
</div>
<table class="query_form_table" >
	<tr>
		<th>职位分类</th>
		<td>
			<input disabled value="<s:property value='res.humaMajorKindName'/>" name="interview.humanMajorKindName"/>
			<input type="hidden" value="<s:property value='res.humanMajorKindId'/>" name="interview.humanMajorKindId">
			<input type="hidden" value="<s:property value='res.humaMajorKindName'/>" name="interview.humanMajorKindName">
		</td>
		<th>职位名称</th>
		<td colspan="3">
			<input disabled value="<s:property value='res.humanMajorName'/>" name="interview.humanMajorName"/>
			<input type="hidden" value="<s:property value='res.humanMajorId'/>" name="interview.humanMajorId">
			<input type="hidden" value="<s:property value='res.humanMajorName'/>" name="interview.humanMajorName">
		</td>
		<!-- <td colspan="2" rowspan="4" style="background-color: #fff">照片</td> -->
	</tr>
	<tr>
		
		<th>招聘类型</th>
		<td colspan="5">
			<input disabled value="<s:property value='res.engageType'/>"/>
		</td>
	</tr>
	<tr>
		<th>姓名</th>
		<td><input disabled name="interview.humanName" value="<s:property value='res.humanName'/>"/>
		<input type="hidden" name="interview.humanName" value="<s:property value='res.humanName'/>"/>
		</td>
		<th>性别</th>
		<td colspan="3"><input disabled  value="<s:property value='res.humanSex'/>"/></td>
	</tr>
	<tr>
		<th>E-MAIL</th>
		<td><input disabled  value="<s:property value='res.humanEmail'/>"/></td>
		<th>电话</th>
		<td colspan="3"><input disabled  value="<s:property value='res.humanTelephone'/>" /></td>
		</tr>
		<tr>
		<th>家庭电话</th>
		<td><input disabled  value="<s:property value='res.humanHomephone'/>" /></td>
		<th>手机</th>
		<td colspan="3"><input disabled  value="<s:property value='res.humanMobilephone'/>" /></td>
		<!-- <th>照片上传</th>
		<td><input type="file" alt="照片上传"></td> -->
	</tr>	
	<tr>
		<TH>住址</TH>
		<td colspan="3">
		<input size="100" disabled  value="<s:property value='res.humanAddress'/>"/>
		</td>
		<th>邮编</th>
		<td><input disabled  value="<s:property value='res.humanPostcode'/>"/></td>
	</tr>
	<tr>
		
		<th>国籍</th>
		<td><input disabled  value="<s:property value='res.humanNationality'/>"/></td>
		<th>出生地</th>
		<td><input disabled  value="<s:property value='res.humanBirthplace'/>"/></td>
		<th>生日</th>
		<td><input disabled  value="<s:property value='res.humanBirthday'/>"/></td>
	</tr>
	<tr>
		<th>民族</th>
		<td><input disabled  value="<s:property value='res.humanRace'/>"/></td>
		<th>宗教信仰</th>
		<td><input disabled  value="<s:property value='res.humanReligion'/>"/></td>
		<th>政治面貌</th>
		<td><input disabled  value="<s:property value='res.humanParty'/>"/></td>
	</tr>
	<tr>
		<th>身份号码</th>
		<td><input disabled  value="<s:property value='res.humanIdcard'/>"/></td>
		<th>年龄</th>
		<td><input disabled  value="<s:property value='res.humanAge'/>"/></td>
		<th>毕业学校</th>
		<td><input disabled  value="<s:property value='res.humanCollege'/>"/></td>
	</tr>
	<tr>
		<th>学历</th>
		<td><input disabled  value="<s:property value='res.humanEducatedDegree'/>"/></td>
		<th>教育年限</th>
		<td><input disabled  value="<s:property value='humanEducatedYears'/>"/></td>
		<th>学历专业</th>
		<td><input disabled  value="<s:property value='humanEducatedMajor'/>"/></td>
	</tr>
	<tr>
		<th>薪酬要求</th>
		<td><input disabled  value="<s:property value='res.demandSalaryStandard'/>"/></td>
		<th>注册时间</th>
		<td><input disabled  value="<s:property value='res.registTime'/>"/></td>
		<th>特长</th>
		<td><input disabled  value="<s:property value='res.humanSpecility'/>"/></td>
	</tr>
	<tr>
		<th>爱好</th>
		<td><input disabled  value="<s:property value='res.humanHobby'/>"/></td>
		<th>推荐人</th>
		<td><input disabled  value="<s:property value='res.checker'/>"/></td>
		<th>推荐时间</th>
		<td><input disabled  value="<s:property value='res.checkTime'/>"/></td>
	</tr>
	<tr>
		<th>个人履历</th>
		<td colspan="5"><textarea rows="6" cols="50"  disabled><s:property value='res.humanHistoryRecords'/></textarea></td>
	</tr>
	<tr>
		<th>备注</th>
		<td colspan="5"><textarea rows="6" cols="50"  disabled><s:property value='res.remark'/></textarea></td>
	</tr>
	<tr>
		<th>推荐意见</th>
		<td colspan="5"><textarea rows="6" cols="50"  disabled><s:property value='res.recomandation'/></textarea></td>
	</tr>
	<tr>
		
		<th>面试次数</th>
		<td>
			<input  type="hidden" name="interview.interviewAmount" value="<s:property value='res.testAmount+1'/>"/>
			第<s:property value='res.testAmount+1'/>次面试
		</td>
		<th>形象评价</th>
		<td>
			<select name="interview.imageDegree">
				<option value="A">A</option>
				<option value="B">B</option>
				<option value="C">C</option>
			</select>
		</td>
		<th>口才评价</th>
		<td>
			<select name="interview.nativeLanguageDegree">
				<option value="A">A</option>
				<option value="B">B</option>
				<option value="C">C</option>
			</select>
		</td>
	</tr>
	<tr>
		<th>外语口语能力</th>
		<td>
			<select name="interview.foreignLanguageDegree">
				<option value="A">A</option>
				<option value="B">B</option>
				<option value="C">C</option>
			</select>
		</td>
		<th>应变能力</th>
		<td>
			<select name="interview.responseSpeedDegree">
				<option value="A">A</option>
				<option value="B">B</option>
				<option value="C">C</option>
			</select>
		</td>
		<th>EQ</th>
		<td>
			<select name="interview.eqDegree">
				<option value="A">A</option>
				<option value="B">B</option>
				<option value="C">C</option>
			</select>
		</td>
	</tr>
	<tr>
		<th>IQ</th>
		<td>
			<select name="interview.iqDegree">
				<option value="A">A</option>
				<option value="B">B</option>
				<option value="C">C</option>
			</select>
		</td>
		<th>综合素质</th>
		<td>
			<select name="interview.multiQualityDegree">
				<option value="A">A</option>
				<option value="B">B</option>
				<option value="C">C</option>
			</select>
		</td>
		<th></th>
		<td></td>
	</tr>
	<tr>
		<th>面试人</th>
		<td><input   name="interview.register" valType="required" msg="<font color=red>*</font>面试人不能为空"/></td>
		<th>面试时间</th>
		<td>
			<sx:datetimepicker name="interview.registerTime" displayFormat="yyyy-MM-dd" />
		</td>
		<th></th>
		<td><input type="hidden" value="<s:property value='res.resId'/>" name="interview.resumeId"></td>
		
	</tr>
	<tr>
		<th>面试评价</th>
		<td colspan="5"><textarea rows="6" cols="50" name="interview.interviewComment" valType="required" msg="<font color=red>*</font>面试评价不能为空"></textarea></td>
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