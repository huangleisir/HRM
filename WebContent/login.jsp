<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="script/jquery.1.7.2.min.js"></script>
<script type="text/javascript" src="script/check.js"></script>
<script type="text/javascript">
$(function($){
	 $("img[name='login']").bind("click",function(){ 
		var uname=$("#uname").val();
		var password=$("#password").val();
    	$.ajax({
    		url:"UserAction!doLogin.action?tbluser.UName="+uname+"&tbluser.UPassword="+password,
    		type:"post",
    		success:function(data){
    			if(data.UId==null || data.UTrueName==null){
    				alert("用户名或密码错误");
    				window.location='login.jsp';
    			}else{
    				alert("登录成功");
    				window.location='html/index.html';
    			}
    			    		}
    	});
	 });
    });
</script>
<style>
	th{
		font-size:12px;
		text-align:right;
		font-weight:normal;
	}
	td{
		font-size:12px;
		text-align:left;
	}
	input{
		width:100px;
		font-size:12px;
		border:solid 1px lightblue;
	}
</style>
</head>
<body BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 style="text-align:center;padding-top:20px;">
	<TABLE WIDTH=800 BORDER=0 CELLPADDING=0 CELLSPACING=0>
  <TR>
		<TD COLSPAN=7>
			<IMG SRC="images/login/login_01.jpg" WIDTH=800 HEIGHT=71 ALT=""></TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=71 ALT=""></TD>
	</TR>
	<TR>
		<TD COLSPAN=7>&nbsp;
		
		</TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=66 ALT=""></TD>
	</TR>
	<TR>
		<TD COLSPAN=7>
			<IMG SRC="images/login/login_03.jpg" WIDTH=800 HEIGHT=6 ALT=""></TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=6 ALT=""></TD>
	</TR>
	<TR>
		
    <TD COLSPAN=3>&nbsp; </TD>
		<TD COLSPAN=3 ROWSPAN=2>
			<IMG SRC="images/login/login_05.jpg" WIDTH=426 HEIGHT=83 ALT=""></TD>
		
    <TD ROWSPAN=3>&nbsp;</TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=44 ALT=""></TD>
	</TR>
	<TR>
		
    <TD ROWSPAN=4>&nbsp; </TD>
		<TD COLSPAN=2>
			<IMG SRC="images/login/login_08.jpg" WIDTH=94 HEIGHT=39 ALT=""></TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=39 ALT=""></TD>
	</TR>
	<TR>
		<TD ROWSPAN=3>
			<IMG SRC="images/login/login_09.jpg" WIDTH=15 HEIGHT=141 ALT=""></TD>
		
    <TD COLSPAN=2 ROWSPAN=2 background="images/login/login_10.jpg" >
	<table width="100%">
        <tr> 
          <th>用户名</th>
          <td><input id="uname" size="10" maxlength="20" onblur="return checkuname();"/><span id="tipuname" ></span></td>
        </tr>
        <tr> 
          <th>密码</th>
          <td><input id="password" type="password" size="10" maxlength="20" onblur="return checkpassword();"/><span id="tippassword" ></span></td>
        </tr>
        <tr> 
          <td>&nbsp;</td>
          <td><img name="login" src="images/login/login_button.jpg" width="73" height="25"></td>
        </tr>
      </table>

	
    </TD>
		<TD COLSPAN=2>
			<IMG SRC="images/login/login_11.jpg" WIDTH=304 HEIGHT=86 ALT=""></TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=86 ALT=""></TD>
	</TR>
	<TR>
		<TD ROWSPAN=2>
			<IMG SRC="images/login/login_12.jpg" WIDTH=19 HEIGHT=55 ALT=""></TD>
		
    <TD COLSPAN=2 ROWSPAN=3>&nbsp; </TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=28 ALT=""></TD>
	</TR>
	<TR>
		<TD COLSPAN=2>
			<IMG SRC="images/login/login_14.jpg" WIDTH=201 HEIGHT=27 ALT=""></TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=27 ALT=""></TD>
	</TR>
	<TR>
		
    <TD COLSPAN=5>&nbsp; </TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=67 ALT=""></TD>
	</TR>
	<TR>
		
    <TD COLSPAN=7 background="images/login/login_16.jpg" style="text-align:right;padding-right:25px;"> 
			&copy; 2008 北京阿博泰克北大青鸟信息技术有限公司
    </TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=1 HEIGHT=55 ALT=""></TD>
	</TR>
	<TR>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=150 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=15 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=79 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=122 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=19 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=285 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/login/spacer.gif" WIDTH=130 HEIGHT=1 ALT=""></TD>
		<TD></TD>
	</TR>
</TABLE>
</body>
</html>