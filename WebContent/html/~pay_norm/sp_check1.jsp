<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="tangs" uri="/WEB-INF/pages.tld"%>  
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@taglib uri="/struts-dojo-tags" prefix="rq"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>jb-aptech毕业设计项目</title>
<rq:head parseContent="true"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>

<%-- function getValue(url){
	document.form1.onsubmit;
	document.form1.action=url; 
	//document.form1.action="doUpdate.jsp"; // 提交的路径 这里是一个Servlet的名称
	}
	
function toPage(page)
{
	var form = document.forms[0];
	form.page.value = page;
	form.submit();
}

function yanzhen(){	
	
	   var name = document.getElementById("name").value;
	   var testdate= dojo.widget.byId("time").getValue();     
	   if(name==null||name=="")
		   {
		   alert("请示入名称！");
		   return false;
		   }
	   else if(testdate==null||testdate=="")
		 {
		   alert("请示入时间！");
		   return false;
		 }
	   //alert(testdate);
	}

function checkit()
{
	//判断是否提交数据
	if(confirm("确定要删除吗？"))
	{
	return true;
	}
	else
	{
	return false;
	}
	
}
	</script>
 --%>
</head>
<body>
<div class="page_title">薪酬标准管理  > 薪酬设置查询 </div>

<form action="tblStandardSalaryDetailAction!find.action" name="form1" method="post" >
<div class="button_bar">
<!-- 	<input type="submit"  name="button" value="查询" onClick="yanzhen()" />  -->
	
	
	<!-- <a href="tblStandardSalaryAction!delete.action?tblStandardSalary.ssdId=<s:property value='#tblStandardSalary.ssdId' />"><input type="submit"  name="submit" value="删除" /></a>
	<input type="button"  name="button" value="登记"  onclick="javascript:document.location.href='html/~pay_norm/register.jsp';"/>
	<input type="submit"  name="submit" value="修改" onclick="getValue('TblStandardSalaryAction!modify.action')"/>
	<input type="submit"  name="submit" value="复核" onclick="getValue('html/~pay_norm/re_register.jsp')"/> -->
</div>

	<br/>
 <br/>
<table class="data_list_table">

	<tr>
		<th>薪酬标准编号</th>
		<th>薪酬标准名称</th>
		<!-- <th>薪酬标准项目编号</th>
		<th>薪酬标准项目名称</th> -->
		<th>薪酬总额</th>
		<th>操作</th>
		
	</tr>
 		<!-- 循环 -->
 <s:iterator value="list" status="stat" var="tt">
	<tr>
	   
	<td>         
	    <a href="tblStandardSalaryAction!sp_modify.action?tblStandardSalary.ssdId=<s:property value='#tt.ssdId' />">  <s:property value="#tt.standardId"/></a> 
		</td>
		<td>
		<a href="tblStandardSalaryAction!sp_modify.action?tblStandardSalary.ssdId=<s:property value='#tt.ssdId' />">   <s:property value="#tt.standardName"/></a>
		</td>
		 <%-- <td>
		<a href="tblStandardSalaryDetailAction!modify.action?tblStandardSalaryDetail.sdtId=<s:property value='#tt.sdtId' />">   <s:property value="#tt.itemId"/></a>
		</td>
		<td>
		<a href="tblStandardSalaryDetailAction!modify.action?tblStandardSalaryDetail.sdtId=<s:property value='#tt.sdtId' />">   <s:property value="#tt.itemName"/></a>
		</td> --%> 
	    <td>
		<a href="tblStandardSalaryAction!sp_modify.action?tblStandardSalary.ssdId=<s:property value='#tt.ssdId' />">    <s:property value="#tt.salarySum"/></a>
		</td>
		 <td>
		 <a href="tblStandardSalaryAction!sp_modify.action?tblStandardSalary.ssdId=<s:property value='#tt.ssdId' />"> 薪酬设置</a> 
		</td>	
		
	</tr>
</s:iterator>
	<tr>
<th colspan="7" class="pager">
<div class="pager">
	共<s:property value="total"/>"条记录 每页<input value="<s:property value="PageSize"/>" size="3" />条
	第<input value="<s:property value="pageNo"/>" size="?"/>页/共 <s:property value="totalPage"/> 页
	<%-- <s:if test="pageNo>1">
	<a href="javascript:toPage(1)">第一页</a>
	<a href="javascript:toPage(<s:property value="pageNo-1"/>)">上一页</a>
	</s:if>
	<s:else>
	第一页&nbsp;上一页&nbsp;
	</s:else>
	<s:if test="pageNo<totalPage">
	<a href="javascript:toPage(<s:property value="pageNo+1"/>)">下一页</a>
	<a href="javascript:toPage(<s:property value="totalPage"/>)">最后一页</a>
	</s:if>
	<s:else>
	下一页&nbsp;最后一页&nbsp;
	</s:else> --%>
	<tangs:pages pageNo="pageNo" total="totalPage"  styleClass="page" theme="number"/>  
	转到<input value="1" size="2" />页
	<button width="20" onclick="toPage(pageNo)">GO</button>
</div>
		</th>
	</tr>

</table>
</form>
 
</body>
</html>