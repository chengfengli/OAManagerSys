var uploader = WebUploader.create({
	//chunked: true,
    // swf文件路径
    swf:path+'/webuploader/Uploader.swf',
    // 文件接收服务端。
    server: 'file/upload',
    // 选择文件的按钮。可选。内部根据当前运行是创建，可能是input元素，也可能是flash.
    pick: '#picker',
    // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
    resize: false,
    auto:false
});
// 当有文件被添加进队列的时候
uploader.on( 'fileQueued', function( file ) {
    $("#thelist").append('<div class="item" id="'+file.id+'_item">'+
				    		'<div class="name" id="'+file.id+'_name">'+file.name+'</div>'+
				    		'<div class="progressBox">'+
				    			'<span class="status" id="'+file.id+'_status">等待上传...</span>'+
				    			'<div  class="progress" id="'+file.id+'_progress"></div>'+
				    		'</div>'+
				    	'</div>');
});
// 文件上传过程中创建进度条实时显示。
uploader.on( 'uploadProgress', function( file, percentage ) {
	if(percentage==1){
		$("#"+file.id+"_status").text('成功');
	}else{
		$("#"+file.id+"_status").text('上传中');
	}
	$("#"+file.id+"_progress").css( 'width', percentage * 100 + '%' );
    
});
// 文件上到服务器之后响应事件。
uploader.on( 'uploadAccept', function(data,data1,data2) {
	console.log(data1);
});

function start(){
	uploader.upload('WU_FILE_0');
}

function stop(){
	uploader.stop('WU_FILE_0');
}

function cancel(){
	//uploader.cancelFile( 'WU_FILE_0' );
	uploader.removeFile( 'WU_FILE_0',true);
	$("#WU_FILE_0_item").remove();
}

