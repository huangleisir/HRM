$(function(){
	// $('#uploadify').uploadifySettings('folder','JS'); //动态修改参数
	
	$("#file").uploadify({ // 初始化函数
	    width: 20,
	    uploader: '<%=basePath%>images/uploadify.swf',
	    // flash文件位置，注意路径
	    // 'swf' : '<%=basePath%>resources/lib/uploadify/uploadify.swf',
	    script: '<%=basePath%>IntentionController.do?method=upload',
	    // 后台处理的请求(sevlet)
	    buttonImg: '<%=basePath%>images/uploadify-cancel.png',
	    // 上传按钮的背景图片
	    auto: true,
	    // 选定文件后是否自动上传，默认false
	    cancelImg: '<%=basePath%>images/uploadify-cancel.png',
	    // 取消按钮图片
	    // 'folder' :
		// '<%=basePath%>resources/lib/uploadify/pic',//您想将文件保存到的路径，将auto设置为true里才有用，不然跳到类里去处理，那就那里说了算
	    queueID: 'fileQueue',
	    // 与下面的上传文件列表id对应
	    queueSizeLimit: 8,
	    // 上传文件的数量
	    scriptData: {
	        'userID': ''
	    },
	    // 向后台传的数据
	    fileDesc: '',
	    // 上传文件类型说明
	    fileExt: 'jpg,png,gif,jpeg',
	    // 控制可上传文件的扩展名，启用本项时需同时声明fileDesc
	    method: 'post',
	    // 如果向后台传输数据，必须是get
	    // sizeLimit:10000,//文件上传的大小限制，单位是字节
	    multi: true,
	    simUploadLimit: 8,
	    // 同时上传文件的数量，设置了这个参数后，
	    // 那么你会因设置multi:true和queueSizeLimit：8而可以多选8个文件，
	    // 但如果一旦你将simUploadLimit也设置了，那么只会上传这个参数指定的文件个数，其它就上传不了
	    buttonText: 'BROWSE',
	    // 浏览按钮上的文字
	    onComplete: function(event, queueID, fileObj, serverData, data) { // 当上传完成后的回调函数，ajax方式哦~~
	        // alert("上传成功");
	        addImg(serverData);
	        // alert(serverData);
	        // addImg(serverData);
	        /*
			 * $('#image').attr("src",serverData);//serverData是sevlet中out.print图片的路径
			 * $('#image').show();
			 */
	    },
	    onSelect: function(e, queueId, fileObj) {
	        /*
			 * alert("唯一标识:" + queueId + "\r\n" + "文件名：" + fileObj.name + "\r\n" +
			 * "文件大小：" + fileObj.size + "\r\n" + "创建时间：" + fileObj.creationDate +
			 * "\r\n" + "最后修改时间：" + fileObj.modificationDate + "\r\n" + "文件类型：" +
			 * fileObj.type );
			 */

	    },
	    onError: function(event, queueID, fileObj) {
	    	alert("文件:" + fileObj.name + " 上传失败");
	    }
	});
});