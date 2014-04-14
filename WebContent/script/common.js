
function help() {
	//location.href("/CRM/about.jsp");	
	location.href("tblPositionReleaseAction!save.action");	
}

function to(url) {
	window.location.href = url;
}

function back() {
	history.go(-1);
}

function save(url) {
	alert("\xb1\xa3\xb4\xe6\xb3\xc9\xb9\xa6\xa3\xa1");
	to(url);
}

function add(url) {
	alert("\xd0\xc2\xbd\xa8\xb3\xc9\xb9\xa6\xa3\xa1");
	to(url);
}

function del(msg) {
	if (window.confirm("\xc8\xb7\xc8\xcf\xc9\xbe\xb3\xfd" + msg + "\xa3\xbf")) {
		reload();
	}
}

function setCurTime(oid) {
	var now = new Date();
	var year = now.getYear();
	var month = now.getMonth();
	var day = now.getDate();
	var hours = now.getHours();
	var minutes = now.getMinutes();
	var seconds = now.getSeconds();
	var timeString = year + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + seconds;
	var oCtl = document.getElementById(oid);
	//oCtl.value = timeString;
}

function submit(){
	document.forms[0].submit();
}