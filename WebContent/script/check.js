//验证一级机构id
function checkIId(){
	var IId=document.getElementById("tblfir").value;
	var tipI=document.getElementById("tipI");
	var reg=/^\d{1,2}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="一级机构编号由1到2位数字组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
//验证一级机构name
function checkIName(){
	var IId=document.getElementById("tblfirname").value;
	var tipI=document.getElementById("tipIname");
	var reg=/^\S{2,60}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="一级机构名称由2到60位非空字符组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
//验证一级机构薪酬责任人
function checksalary(){
	var IId=document.getElementById("salary").value;
	var tipI=document.getElementById("tipsalary");
	var reg=/^\S{2,255}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="一级机构薪酬责任由2到255位非空字符组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
//验证一级机构销售责任人
function checksale(){
	var IId=document.getElementById("sale").value;
	var tipI=document.getElementById("tipsale");
	var reg=/^\S{2,255}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="一级机构销售责任人由2到255位非空字符组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
function checkIall(){
	if(checkIId()&&checkIName()&&checksalary()&&checksale()){
		return true;
	}
	return false;
}




//验证二级机构id
function checkIIid(){
	var IId=document.getElementById("id").value;
	var tipI=document.getElementById("tipid");
	var reg=/^\d{1,2}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="二级机构id由2位数字组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
//验证二级机构name
function checkIIname(){
	var IId=document.getElementById("name").value;
	var tipI=document.getElementById("tipname");
	var reg=/^\S{2,60}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="二级机构name由2到60位非空字符组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
//验证二级机构salary
function checkIIsalary(){
	var IId=document.getElementById("salary").value;
	var tipI=document.getElementById("tipsalary");
	var reg=/^\S{2,255}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="二级机构salary由2到255位非空字符组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
//验证二级机构sale
function checkIIsale(){
	var IId=document.getElementById("sale").value;
	var tipI=document.getElementById("tipsale");
	var reg=/^\S{2,255}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="二级机构sale由2到255位非空字符组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
function checkIIall(){
	if(checkIIid()&&checkIIname()&&checkIIsalary()&&checkIIsale()){
		return true;
	}
	return false;
}



//验证三级机构id
function checkIIIid(){
	var IId=document.getElementById("id").value;
	var tipI=document.getElementById("tipid");
	var reg=/^\d{1,2}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="三级机构id由2位数字组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
//验证三级机构name
function checkIIIname(){
	var IId=document.getElementById("name").value;
	var tipI=document.getElementById("tipname");
	var reg=/^\S{2,60}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="三级机构name由2到60位非空字符组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
//验证三级机构isretail
function checkIIIisretail(){
	var IId=document.getElementById("isretail").value;
	var tipI=document.getElementById("tipisretail");
	var reg=/^\D{1}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="三级机构isretail由2位非数字组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
//验证三级机构sale
function checkIIIsale(){
	var IId=document.getElementById("sale").value;
	var tipI=document.getElementById("tipsale");
	var reg=/^\S{2,255}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="三级机构sale由2到255位非空字符组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
function checkIIIall(){
	if(checkIIIid()&&checkIIIname()&&checkIIIsale()){
		return true;
	}
	return false;
}




//验证职位名称id
function checkIXid(){
	var IId=document.getElementById("id").value;
	var tipI=document.getElementById("tipid");
	var reg=/^\d{1,2}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="职称id由1到2位数字组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
//验证职位名称name
function checkIXname(){
	var IId=document.getElementById("name").value;
	var tipI=document.getElementById("tipname");
	var reg=/^\S{2,60}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="职位名称name由2到60位非空字符组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
//验证职位名称count
function checkIXcount(){
	var IId=document.getElementById("count").value;
	var tipI=document.getElementById("tipcount");
	var reg=/^\d{1,5}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="职位名称count由1到5位数字组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
function checkIXall(){
	if(checkIXid()&&checkIXname()&&checkIXcount()){
		return true;
	}
	return false;
}






//验证职位分类id
function checkXid(){
	var IId=document.getElementById("id").value;
	var tipI=document.getElementById("tipid");
	var reg=/^\d{1,2}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="职位分类id由1到2位数字组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
//验证职位分类name
function checkXname(){
	var IId=document.getElementById("name").value;
	var tipI=document.getElementById("tipname");
	var reg=/^\S{2,60}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="职位分类name由2到255位非空字符组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
function checkXall(){
	if(checkXid()&&checkXname()){
		return true;
	}
	return false;
}





//验证公共属性id
function checkXIid(){
	var IId=document.getElementById("id").value;
	var tipI=document.getElementById("tipid");
	var reg=/^\S{2,60}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="公共属性id由2到60位非空字符组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
//验证公共属性name
function checkXIname(){
	var IId=document.getElementById("name").value;
	var tipI=document.getElementById("tipname");
	var reg=/^\S{2,60}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="公共属性name由2到60位非空字符组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
function checkXIall(){
	if(checkXIid()&&checkXIname()){
		return true;
	}
	return false;
}

//验证一级机构修改页面
//验证一级机构id
function checkm1id(){
	var IId=document.getElementById("id").value;
	var tipI=document.getElementById("tipid");
	var reg=/^\d{1,2}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="一级机构id由1到2位数字组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
//验证一级机构name
function checkm1name(){
	var IId=document.getElementById("name").value;
	var tipI=document.getElementById("tipname");
	var reg=/^\S{2,60}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="一级机构name由2到60位非空字符组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
//验证一级机构薪酬责任人
function checkm1salary(){
	var IId=document.getElementById("salary").value;
	var tipI=document.getElementById("tipsalary");
	var reg=/^\S{2,255}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="一级机构薪酬责任人由2到255位非空字符组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
//验证一级机构销售责任人
function checkm1sale(){
	var IId=document.getElementById("sale").value;
	var tipI=document.getElementById("tipsale");
	var reg=/^\S{2,255}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="一级机构销售责任人由2到255位非空字符组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}

function checkm1all(){
	if(checkm1id()&&checkm1name()&&checkm1salary()&&checkm1sale()){
		return true;
	}
	return false;
}

//验证二级机构修改页面
//验证二级机构id
function checkm2id(){
	var IId=document.getElementById("id").value;
	var tipI=document.getElementById("tipid");
	var reg=/^\d{1,2}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="二级机构id由2位数字组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
//验证二级机构name
function checkm2name(){
	var IId=document.getElementById("name").value;
	var tipI=document.getElementById("tipname");
	var reg=/^\S{2,60}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="二级机构name由2到60位非数字组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
//验证二级机构薪酬责任人
function checkm2salary(){
	var IId=document.getElementById("salary").value;
	var tipI=document.getElementById("tipsalary");
	var reg=/^\S{2,255}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="二级机构薪酬责任人由2到255位非空字符组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
//验证二级机构销售责任人
function checkm2sale(){
	var IId=document.getElementById("sale").value;
	var tipI=document.getElementById("tipsale");
	var reg=/^\S{2,255}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="二级机构销售责任人由2到255位非空字符组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
function checkm2all(){
	if(checkm2id()&&checkm2name()&&checkm2salary()&&checkm2sale()){
		return true;
	}
	return false;
}


//验证三级机构修改页面
//验证三级机构id
function checkm3id(){
	var IId=document.getElementById("id").value;
	var tipI=document.getElementById("tipid");
	var reg=/^\d{1,2}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="三级机构id由1到2位数字组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
//验证三级机构name
function checkm3name(){
	var IId=document.getElementById("name").value;
	var tipI=document.getElementById("tipname");
	var reg=/^\S{2,60}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="三级机构name由2到60位非数字组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
//验证三级机构薪酬责任人
function checkm3salary(){
	var IId=document.getElementById("salary").value;
	var tipI=document.getElementById("tipsalary");
	var reg=/^\S{2,255}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="三级机构薪酬责任人由2到255位非空字符组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
//验证三级机构销售责任人
function checkm3sale(){
	var IId=document.getElementById("sale").value;
	var tipI=document.getElementById("tipsale");
	var reg=/^\S{2,255}$/;
	if(reg.test(IId)==false){
		tipI.innerHTML="三级机构销售责任人由2到255位非空字符组成！";
		return false;
	}
	tipI.innerHTML="格式正确。";
	return true;
}
function checkm3all(){
	if(checkm3id()&&checkm3name()&&checkm3sale()){
		return true;
	}
	return false;
}
//验证登陆非空
function checkuname(){
	var IId=document.getElementById("uname").value;
	var tipI=document.getElementById("tipuname");
	var reg=/^\S{1,60}$/;
	if(reg.test(IId)==false){
		alert("用户名由1——69个非空字符组成！");
		return false;
	}
	return true;
}

function checkpassword(){
	var IId=document.getElementById("password").value;
	var tipI=document.getElementById("tippassword");
	var reg=/^\S{1,60}$/;
	if(reg.test(IId)==false){
		alert("密码由1——69个非空字符组成！");
		return false;
	}
	return true;
}