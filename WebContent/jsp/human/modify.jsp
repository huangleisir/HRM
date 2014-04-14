<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-dojo-tags" prefix="sd"%>
<%@taglib uri="/struts-tags" prefix="s"%>
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
<sd:head parseContent="true" />
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script src="script/jquery.1.7.2.min.js"></script>
<s:url var="firstClassUrl" action="getFiresClassList"
	namespace="/human/ajax" />
<script type="text/javascript">
$(document).ready(function() {
	selectChange();
	<s:if test="#parameters.type[0] == 'add'">
		fillMajorClassify("humanMajorKindId");
    </s:if>
    fillSalary("salaryStandardId","<s:property value="model.salaryStandardId"/>");
	fillPublicAtt("humanHobby","爱好","<s:property value="model.humanHobby"/>"); 
	fillPublicAtt("humanNationality","国籍","<s:property value="model.humanNationality"/>");
	fillPublicAtt("humanReligion","宗教信仰","<s:property value="model.humanReligion"/>");
	fillPublicAtt("humanParty","政治面貌","<s:property value="model.humanParty"/>");
	fillPublicAtt("humanEducatedDegree","学历","<s:property value="model.humanEducatedDegree"/>");
	fillPublicAtt("trainingAmount","教育年限","<s:property value="model.trainingAmount"/>");
	fillPublicAtt("humanRace","民族","<s:property value="model.humanRace"/>");
	fillPublicAtt("humanEducatedMajor","学历专业","<s:property value="model.humanEducatedMajor"/>");
	fillPublicAtt("humanSpeciality","特长","<s:property value="model.humanSpeciality"/>"); 
	
	//填充第一机构的数据
	$.ajax({
		   type: "POST",
		   url: "http://localhost:8080/HRM//human/ajax/getFirstClassList.action",
		   dataType: 'json',
		   data: null,
		   success: function(msg){
			   $("#firstKindId").html("<option value='' >请选择</option>");
		    	for(i=0;i<msg.firstClassList.length;i++){
			  	var name= msg.firstClassList[i].firstKindName;
		      	var id= msg.firstClassList[i].firstKindId;
		      	$("#firstKindId").append("<option value="+id+">"+name+"</option>");
		     }
		     
		   }
		 });
	
	//第一机构改变是联动填充第二机构
	$("#firstKindId").change(function(){
		var firsid= $("#firstKindId").val();
		$("#secondKindId").html("<option value=''>请选择</option>");
		$.ajax({
			   type: "POST",
			   url: "http://localhost:8080/HRM//human/ajax/getSecondClassByFirstClass.action",
			   dataType: 'json',
			   data: "firstId="+firsid,
			   success: function(msg){
			    	for(i=0;i<msg.secondClassList.length;i++){
				  	var name= msg.secondClassList[i].secondKindName;
			      	var id= msg.secondClassList[i].secondKindId;
			      	$("#secondKindId").append("<option value="+id+">"+name+"</option>");
			     }
			     
			   }
			 });
	});
	
	//第二机构改变是联动填充第三机构
	$("#secondKindId").change(function(){
		var secondId= $("#secondKindId").val();
		$("#thirdKindId").html("<option value=''>请选择</option>");
		$.ajax({
			   type: "POST",
			   url: "http://localhost:8080/HRM//human/ajax/getThirdClassBySecondClass.action",
			   dataType: 'json',
			   data: "secondId="+secondId,
			   success: function(msg){
			    	for(i=0;i<msg.thirdClassList.length;i++){
				  	var name= msg.thirdClassList[i].thirdKindName;
			      	var id= msg.thirdClassList[i].thirdKindId;
			      	$("#thirdKindId").append("<option value="+id+">"+name+"</option>");
			     }
			     
			   }
			 });
	});

	$("#humanMajorKindId").change(function(){
		fillmajor("humanMajorId",$(this).val(),null);
	});
	
	
	//图片预览
	$("#file").change(function(){
		 $("#p").attr("src", "file:///" + $("#file").val());
	});
	
	
	<s:if test="#parameters.type[0] == 'show'">
	input2disabled();
	select2disabled();
	</s:if>
	//ready方法结束点
	});
	//填充职位分类下拉框
	function fillMajorClassify(eid){
		$.ajax({
			   type: "POST",
			   url: "http://localhost:8080/HRM/human/ajax/getMajorClassify.action",
			   dataType: 'json',
			   data: null,
			   success: function(msg){
				   eid="#"+eid;
				   $(eid).html("<option value=''>请选择</option>");
			    	for(i=0;i<msg.majorClassifyList.length;i++){
				  	var name= msg.majorClassifyList[i].majorKindName;
			      	var id= msg.majorClassifyList[i].majorKindId;
			      	$(eid).append("<option value="+id+">"+name+"</option>");
			     }
			     
			   }
			 });
	}
	
	//填充薪酬等级下拉框
	function fillSalary(eid,selected){
		$.ajax({
			   type: "POST",
			   url: "http://localhost:8080/HRM/human/ajax/getTblStandardSalaryAll.action",
			   dataType: 'json',
			   data: null,
			   success: function(msg){
				   eid="#"+eid;
				   $(eid).html("<option value=''>请选择</option>");
			    	for(i=0;i<msg.standardSalaryList.length;i++){
				  	var name= msg.standardSalaryList[i].standardName;
				  	var id= msg.standardSalaryList[i].standardId;
				  	if(id==selected){
				  		$(eid).append("<option selected='selected' value="+id+">"+name+"</option>");
				  	}else{
			      		$(eid).append("<option value="+id+">"+name+"</option>");
				  	}
			     }
			     
			   }
			 });
	}
	
	//填充公共属性下拉框
	function fillPublicAtt(eid,strType,selected){
		$.ajax({
			   type: "POST",
			   url: "http://localhost:8080/HRM/human/ajax/getPublicAttMapByType.action",
			   dataType: 'json',
			   data: "type="+strType,
			   success: function(msg){
				   eid="#"+eid;
				   $(eid).html("<option value=''>请选择</option>");
			    	for(i=0;i<msg.attNames.length;i++){
				  	var name= msg.attNames[i];
				  	if(name==selected){
				  		$(eid).append("<option selected='selected' value="+name+">"+name+"</option>");
				  	}else{
			      		$(eid).append("<option value="+name+">"+name+"</option>");
				  	}
			     }
			     
			   }
			 });
	}
	
	//填充职位名称下拉框，依赖于职位类型
	function fillmajor(eid,strClazz,selected){
		$.ajax({
			   type: "POST",
			   url: "http://localhost:8080/HRM/human/ajax/getTblMajorNameByClassId.action",
			   dataType: 'json',
			   data: "clazz="+strClazz,
			   success: function(msg){
				   eid="#"+eid;
				   $(eid).html("<option value=''>请选择</option>");
			    	for(i=0;i<msg.majorNameList.length;i++){
				  	var name= msg.majorNameList[i].majorName;
				  	var id= msg.majorNameList[i].majorId;
				  	if(name==selected){
				  		$(eid).append("<option selected='selected' value="+id+">"+name+"</option>");
				  	}else{
			      		$(eid).append("<option value="+id+">"+name+"</option>");
				  	}
			     }
			     
			   }
			 });
	}
	
	function selectChange(){
		$("#firstKindId").change(function(){ $("#firstKindName").val($("#firstKindId").find("option:selected").text());});
		
		$("#secondKindId").change(function(){ $("#secondKindName").val($("#secondKindId").find("option:selected").text());});
		
		$("#thirdKindId").change(function(){ $("#thirdKindName").val($("#thirdKindId").find("option:selected").text());});
		
		$("#humanMajorKindId").change(function(){ $("#humanMajorKindName").val($("#humanMajorKindId").find("option:selected").text());});
		
		$("#humanMajorId").change(function(){ $("#humanMajorName").val($("#humanMajorId").find("option:selected").text());});
		
	}
	function input2disabled(){
		$("input").attr("readonly","readonly");
		$("textarea").attr("readonly","readonly");
	}
	function select2disabled(){
		$("select").attr("disabled","disabled");
	}
	 function submitCheck(){
		var flag=true;
		alert($("#firstKindId").val()=="");
		if($("#firstKindId").val()=="") flag=false;
		if($("#secondKindId").val()=="") flag=false;
		if($("#thirdKindId").val()=="") flag=false;

		if($("#humanMajorKindId").val()=="") flag=false;
		if($("#humanMajorKindId").val()=="") flag=false;
		if($("#humanName").val()=="") flag=false;
		if(!flag){
			alert("输入的数据有误，请修改后提交");
			return false;
		}
		return true;
	} 
</script>

</head>
<body>
	<div class="page_title">人力资源&nbsp; &gt; 人力资源档案登记</div>
	<button onclick="history.back();" value="返回">返回</button>  
	<s:if test="#parameters.type[0] == 'add'">
		<s:url var="actionUrl" action="add" namespace="/human" />
	</s:if>
	<s:elseif test="#parameters.type[0] == 'update'">
		<s:url var="actionUrl" action="update" namespace="/human" />
	</s:elseif>
	<s:elseif test="#parameters.type[0] == 'check'">
		<s:url var="actionUrl" action="checked" namespace="/human" />
	</s:elseif> 
	<form enctype="multipart/form-data" action="<s:property value="#actionUrl"/>" method="post">
		<input name="hufId" type="hidden" value="<s:property value="hufId"/>">
		<div class="button_bar">
			<s:if test="#parameters.type[0] == 'add'">
				<input class="common_button" type="reset" value="清除" />
				<input onclick="return submitCheck();" class="common_button" type="submit" value="保存" />
			</s:if>
			<s:elseif test="#parameters.type[0] == 'update'">
				<input onclick="return submitCheck();" class="common_button" type="submit" value="更新" />
			</s:elseif>
			<s:elseif test="#parameters.type[0] == 'check'">
				<input onclick="return submitCheck();" class="common_button" type="submit" value="审核通过" />
			</s:elseif> 
		</div>
		<table class="query_form_table">
			<tr>
				<th>I级机构<input name="firstKindName" id="firstKindName" type="hidden" value="<s:property value="firstKindName"/>"/></th>
				<td>
					<s:if test="#parameters.type[0] == 'add'">
						<select id="firstKindId" name="firstKindId">
							<option>请选择</option>
						</select>
					</s:if>
					<s:else>
						<s:property value="model.firstKindName"/>
					</s:else>	
					<s:fielderror fieldName="firstKindName" id ="vfirstKindName"></s:fielderror>
				</td>
				<th>II级机构<input id="secondKindName" name="secondKindName" type="hidden" value="<s:property value="secondKindName"/>"/></th>
				<td>
				<s:if test="#parameters.type[0] == 'add'">
					<select id="secondKindId" name="secondKindId">
						<option>请选择</option>
					</select>
				</s:if>
				<s:else>
					<s:property value="model.secondKindName"/>
				</s:else>
				<s:fielderror fieldName="secondKindName" id ="vsecondKindName"></s:fielderror>
				</td> 
				<td rowspan="6" colspan="3" align="center"><img id="p" src="<%=basePath%><s:property value="model.humanPicture"/>"></td>
			</tr>
			<tr>
				<th>III级机构<input id="thirdKindName" name="thirdKindName" type="hidden" value="<s:property value="thirdKindName"/>"/></th>
				<td>
					<s:if test="#parameters.type[0] == 'add'">
						<select id="thirdKindId" name="thirdKindId">
							<option value=''>请选择</option>
						</select>
					</s:if>
					<s:else>
						<s:property value="model.thirdKindName"/>
					</s:else>
					<s:fielderror fieldName="thirdKindName" id ="vthirdKindName"></s:fielderror>
				</td>
				<th>职位分类
				<input id="humanMajorKindName" name="humanMajorKindName" type="hidden" value="<s:property value="humanMajorKindName"/>"/></th>
				<td>
					<s:if test="#parameters.type[0] == 'add'">
						<select id="humanMajorKindId" name="humanMajorKindId">
							<option value=''>请选择</option>
						</select>
					</s:if>
					<s:else>
						<s:property value="model.humanMajorKindName"/>
					</s:else>
					<s:fielderror fieldName="humanMajorKindName" id ="vhumanMajorKindName"></s:fielderror>
				
				</td>
			</tr>
			<tr>
				<th>爱好</th>
				<td><select id="humanHobby" name="humanHobby">
						<option value=''>请选择</option>
				</select></td>
				<th>职称<input id="humanMajorName" name="humanMajorName" type="hidden" value="<s:property value="humanMajorName"/>"/></th>
				<td>
					<s:if test="#parameters.type[0] == 'add'">
						<select id="humanMajorId" name="humanMajorId">
							<option value=''>请选择</option>
						</select>
					</s:if>
					<s:else>
						<s:property value="model.humanMajorName"/>
					</s:else>
					<s:fielderror fieldName="humanMajorKindName" id ="vhumanMajorKindName"></s:fielderror>
				</td>
			</tr>
			<tr>
				<th>姓名</th>
				<td><input id="humanName" size="20" name="humanName"
					value='<s:property value="model.humanName" />' />
				<s:fielderror fieldName="humanName" id ="vName"></s:fielderror>
				</td>
				<th>电话</th>
				<td><input size="20" name="humanTelephone"
					value='<s:property value="model.humanTelephone" />' /></td>
			</tr>
			<tr>
				<th>性别</th>
				<td><select name="humanSex">
				<s:if test="model.humanSex==1"></s:if>
						<option <s:if test="model.humanSex==1">selected="selected"</s:if>  value="1">男</option>
						<option <s:if test="model.humanSex==2">selected="selected"</s:if> value="2">女</option>
				</select></td>
				<th>EMAIL</th>
				<td><input size="30" name="humanEmail"
					value='<s:property value="model.humanEmail" />' /></td>
			</tr>
			<tr>
				<th>QQ</th>
				<td><input size="20" name="humanQq"
					value='<s:property value="model.humanQq" />' /></td>
				<th>手机</th>
				<td><input size="30" name="humanMobilephone"
					value='<s:property value="model.humanMobilephone" />' /></td>
			</tr>
			<tr>
				<th>住址</th>
				<td><input size="20" name="humanAddress"
					value='<s:property value="model.humanAddress" />' /></td>
				<th>邮编</th>
				<td><input size="30" name="humanPostcode"
					value='<s:property value="model.humanPostcode" />' /></td>
				<th>照片
				<s:if test="#parameters.type[0] != 'add'"> 
					<input name="humanPicture" type="hidden" value="<s:property value="model.humanPicture"/>" />
			    </s:if>
				</th>
				<td><input id="file" name="humanPictureFile" type="file" /></td>
			</tr>
			<tr>
				<th>国籍</th>
				<td><select id="humanNationality" name="humanNationality">
						<option value="1">中国</option>
						<option selected="selected" value="2">美国</option>
				</select></td>
				<th>出生地</th>
				<td><input size="20" name="humanBirthplace"
					value='<s:property value="model.humanBirthplace" />' /></td>
				<th>生日</th>
				<td><sd:datetimepicker type="date" name="humanBirthday"
						displayFormat="dd-MM月-yyyy"></sd:datetimepicker> <!-- <input size="20" /> --></td>
			</tr>
			<tr>
				<th>宗教信仰</th>
				<td><select id="humanReligion" name="humanReligion">
						<option value=''>请选择</option>
				</select></td>
				<th>政治面貌</th>
				<td><select id="humanParty" name="humanParty">
						<option value=''>请选择</option>
				</select></td>
				<th>身份证号码</th>
				<td><input size="20" name="humanIdCard"
					value='<s:property value="model.humanIdCard" />' /></td>
			</tr>
			<tr>
				<th>年龄</th>
				<td><input size="20" name="humanAge"
					value='<s:property value="model.humanAge" />' /></td>
				<th>学历</th>
				<td><select id="humanEducatedDegree" name="humanEducatedDegree">
						<option value=''>请选择</option>
				</select></td>
				<th>教育年限</th>
				<td><select id="trainingAmount" name="trainingAmount">
					<option value=''>请选择</option>
				</select></td>
			</tr>
			<tr>
				<th>薪酬标准</th>
				<td><select id="salaryStandardId" name="salaryStandardId">
						<option value=''>请选择</option>
				</select></td>
				<th>开户行</th>
				<td><input size="20" name="humanBank"
					value='<s:property value="model.humanBank" />' /></td>
				<th>帐号</th>
				<td><input size="20" name="humanAccount"
					value='<s:property value="model.humanAccount" />' /></td>
			</tr>
			<tr>
				<th>民族</th>
				<td><select id="humanRace" name="humanRace">
						<option value="1">汉族</option>
						<option selected="selected" value="2">苗族</option>
				</select></td>
				<th>社会保障号码</th>
				<td><input
					value='<s:property value="model.humanSocietySecurityId" />'
					size="20" name="humanSocietySecurityId" /></td>
				<th>学历专业</th>
				<td><select id="humanEducatedMajor" name="humanEducatedMajor">
						<option value=''>请选择</option>
				</select></td>
			</tr>
			<tr>
				<th><s:if test="#parameters.type[0] == 'check'">复核人</s:if> <s:elseif
						test="#parameters.type[0] == 'update'">
				变更人
				</s:elseif> <s:else>登记人</s:else></th>
				<%-- <td><input  value='<s:property value="model.register" />' size="20" name="register" /></td> --%>
				<td><s:if test="#parameters.type[0] == 'check'">
						<input value='<s:property value="model.checker" />' size="20"
							name="checker" />
					</s:if> <s:elseif test="#parameters.type[0] == 'update'">
						<input value='<s:property value="model.changer" />' size="20"
							name="changer" />
					</s:elseif> <s:else>
						<input value='<s:property value="model.register" />' size="20"
							name="register" />
					</s:else></td>
				<th>
				<s:if test="#parameters.type[0] == 'check'">复核时间</s:if> 
				<s:elseif test="#parameters.type[0] == 'update'">修改时间</s:elseif>
				<s:else>建档时间</s:else>
				</th>
				<td>
					<s:if test="#parameters.type[0] == 'check'">
						<sd:datetimepicker value="modal.checkTime" type="date" name="checkTime" displayFormat="dd-MM月-yyyy"></sd:datetimepicker>
					</s:if> 
					<s:elseif test="#parameters.type[0] == 'update'">
						<sd:datetimepicker value="modal.changeTime" type="date" name="changeTime" displayFormat="dd-MM月-yyyy"></sd:datetimepicker>
					</s:elseif>
					<s:else>
						<sd:datetimepicker value="modal.registTime" type="date" name="registTime" displayFormat="dd-MM月-yyyy"></sd:datetimepicker>
					</s:else>
				</td>
				<th>特长</th> 
				<td><select id="humanSpeciality" name="humanSpeciality">
						<option value="1">特长1</option>
						<option selected="selected" value="2">特长2</option>
						<option value="3">特长3</option>
				</select></td>
			</tr>
			<tr>
				<th>个人履历</th>
				<td colspan="3"><textarea name="humanHistroyRecords" rows="6"
						cols="100%"><s:property value="model.humanHistroyRecords" /></textarea>
			</tr>
			<tr>
				<th>家庭关系信息</th>
				<td colspan="3"><textarea name="humanFamilyMembership" rows="6"
						cols="100%"><s:property value="model.humanFamilyMembership" /></textarea>
			</tr>
			<tr>
				<th>备注</th>
				<td colspan="3"><textarea name="remark" rows="6" cols="100%"><s:property value="model.remark" /></textarea>
			</tr>
		</table>
		<input type="hidden" name="checkStatus" value="<s:property value="model.checkStatus"/>"/> 
	</form>
	
</body>
</html>
