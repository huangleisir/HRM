function reload(){
	window.location.reload();
}
function help(msg){
	alert('��ӭʹ��'+msg);
}

function to(url){
	window.location.href=url;
}
function back(){
	history.go(-1);
}
function save(url){
	alert('����ɹ���');
	to(url);
}
function add(url){
	alert('�½��ɹ���');
	to(url);
}
function del(msg){
	if (window.confirm("ȷ��ɾ��"+msg+"��")){
		reload();
	}
}
function setCurTime(oid){
	var now=new Date();
	var year=now.getYear();
	var month=now.getMonth();
	var day=now.getDate();
	var hours=now.getHours();
	var minutes=now.getMinutes();
	var seconds=now.getSeconds();
	var timeString = year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds;
	var oCtl = document.getElementById(oid);
	//oCtl.value = timeString;
}