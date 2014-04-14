$(document).ready(function() {
	//填充第一机构的数据
	$.ajax({
		   type: "POST",
		   url: "human/ajax/getFirstClassList.action",
		   dataType: 'json',
		   data: null,
		   success: function(msg){
			   $("#firstKindId").html("");
		    	for(var i=0;i<msg.firstClassList.length;i++){
			  	var name= msg.firstClassList[i].firstKindName;
		      	var id= msg.firstClassList[i].firstKindId;
		      	$("#firstKindId").append("<option value="+id+">"+name+"</option>");
		     }
		     
		   }
		 });
	
	//第一机构改变是联动填充第二机构
	$("#firstKindId").change(function(){
		var firsid= $("#firstKindId").val();
		$("#secondKindId").html("");
		$.ajax({
			   type: "POST",
			   url: "human/ajax/getSecondClassByFirstClass.action",
			   dataType: 'json',
			   data: "firstId="+firsid,
			   success: function(msg){
			    	for(var i=0;i<msg.secondClassList.length;i++){
				  	var name= msg.secondClassList[i].secondKindName;
			      	var id= msg.secondClassList[i].secondKindId;
			      	$("#secondKindId").append("<option value="+id+">"+name+"</option>");
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
	
	//ready方法结束点
	});