var E = window.wangEditor;
var editor = new E('content');
/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text: "发送",icon:'up',click: function () {send()}});
	items.push({ line:true });
	items.push({text: "存草稿",icon:'pager',click: function () {draft();}});
	if(back){
		items.push({ line:true });
		items.push({text: "返回",icon:'back',click: function () {back()}});
	}
	$("#toolbar").ligerToolBar({
		items: items
	});
}
/*返回*/
function back(){
	history.go(-1);
}
/*验证、发送*/
function send(){
	var account = $("#account").val();
	var copyer = $("#chaosong").val();
	var title = $("#title").val();
	var content = editor.$txt.html();
	if(account=="" || account.trim()==""){
		parent.$.ligerDialog.warn('填写收件人!');
		return;
	}
	if(title=="" || title.trim()==""){
		parent.$.ligerDialog.warn('填写主题!');
		return;
	}
	if(content == "" || content.trim() == ""){
		parent.$.ligerDialog.warn('填写内容!');
		return;
	}
	var data = {
		title:title,
		content:content,
		acceptNo:account,
		copyer:copyer
	}
	$.ajax({
		url:path+"/email/doSend",
		type:"post",
		dataType:"json",
		data:data,
		success:function(response){
			if(response.isSuccess){
				parent.$.ligerDialog.success(response.strMessage);
				send_websocket(response.acceptNo,response.tips);
			}else{
				parent.$.ligerDialog.error(response.strMessage);
			}
		},
		error:function(response){
			parent.$.ligerDialog.error("系统错误!");
		}
	});
}
/*存草稿*/
function draft(){
	var account = $("#account").val();
	var copyer = $("#chaosong").val();
	var title = $("#title").val();
	var content = editor.$txt.html();
	if(title=="" || title.trim()==""){
		parent.$.ligerDialog.warn('填写主题!');
		return;
	}
	if(content == "" || content.trim() == ""){
		parent.$.ligerDialog.warn('填写内容!');
		return;
	}
	var data = {
		title:title,
		content:content,
		acceptNo:account,
		copyer:copyer
	}
	$.ajax({
		url:path+"/email/draft",
		type:"post",
		dataType:"json",
		data:data,
		success:function(response){
			if(response.isSuccess){
				parent.$.ligerDialog.success(response.strMessage);
			}else{
				parent.$.ligerDialog.error(response.strMessage);
			}
		},
		error:function(response){
			parent.$.ligerDialog.error("系统错误!");
		}
	});
}
/*添加接收人*/
function add_send_user(userEmail){
	if($("#account").val().trim()==""){
		$("#account").val(userEmail);
	}else{
		if($("#account").val().indexOf(userEmail)==-1){
			$("#account").val($("#account").val()+";"+userEmail);
		}
	}
}
/*添加抄送人*/
function add_group_send(userEmail){
	if($("#chaosong").val().trim()==""){
		$("#chaosong").val(userEmail);
	}else{
		if($("#chaosong").val().indexOf(userEmail)==-1){
			$("#chaosong").val($("#chaosong").val()+";"+userEmail);
		}
	}
}
/*文件上传*/
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
$(function(){
	toolbar();
	/*初始化富文本编辑器*/
	editor.create();
	/*选择文件后*/
	$("#file").change(function(){
		var files = this.files;
		var li="";
		for(var i=0;i<files.length;i++){
			li+="<li>"+files[i].name+"</li>";
		}
		$("#file_count").text(files.length+" 个");
		$("#file_list").html(li);
	});
	/*添加收件人*/
	$(".group_send").click(function(){
		alert(JSON.stringify($(".group_send")));
	});
});

