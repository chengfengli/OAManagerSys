var time = new Date().getTime();
var E = window.wangEditor;
var editor = new E('content');


/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text: "发送",icon:'up',click: function () {send()}});
	items.push({ line:true });
	items.push({text: "存草稿",icon:'pager',click: function () {draft();}});
	if(backbtn){
		items.push({ line:true });
		items.push({text: "返回",icon:'back',click: function () {history.go(-1);}});
	}
	$("#toolbar").ligerToolBar({
		items: items
	});
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
	var fileId = $("#fileId").val();
	var data = {
		title: title,
		content: content,
		acceptNo: account,
		copyer: copyer,
		fileId: fileId
	}
	
	var wait = parent.$.ligerDialog.waitting('发送中,请稍候...');
	var files = $("#file_list li");
	if(files.length > 0 || fileId != ''){
		$.upload(path+"/file/upload",function(result){
			if(fileId == '' ){
				data.fileId = result.strMessage;
			}
			$.ajax({
				url:path+"/email/doSend",
				type:"post",
				dataType:"json",
				data:data,
				success:function(response){
					wait.close();
					if(response.isSuccess){
						parent.$.ligerDialog.success(response.strMessage);
						send_websocket(response.acceptNo,response.tips);
					}else{
						parent.$.ligerDialog.error(response.strMessage);
					}
				},
				error:function(response){
					wait.close();
					parent.$.ligerDialog.error("系统错误!");
				}
			});
		})
	}else{
		$.ajax({
			url:path+"/email/doSend",
			type:"post",
			dataType:"json",
			data:data,
			success:function(response){
				wait.close();
				if(response.isSuccess){
					parent.$.ligerDialog.success(response.strMessage);
					send_websocket(response.acceptNo,response.tips);
				}else{
					parent.$.ligerDialog.error(response.strMessage);
				}
			},
			error:function(response){
				wait.close();
				parent.$.ligerDialog.error("系统错误!");
			}
		});
	}
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
	var wait = parent.$.ligerDialog.waitting('保存中,请稍候...');
	var files = $("#file_list li");
	if(files.length > 0){
		$.upload(path+"/file/upload",function(result){
			data.fileId = result.strMessage;
			$.ajax({
				url:path+"/email/draft",
				type:"post",
				dataType:"json",
				data:data,
				success:function(response){
					wait.close();
					if(response.isSuccess){
						parent.$.ligerDialog.success(response.strMessage);
						send_websocket(response.acceptNo,response.tips);
					}else{
						parent.$.ligerDialog.error(response.strMessage);
					}
				},
				error:function(response){
					wait.close();
					parent.$.ligerDialog.error("系统错误!");
				}
			});
		})
	}else{
		$.ajax({
			url:path+"/email/draft",
			type:"post",
			dataType:"json",
			data:data,
			success:function(response){
				wait.close();
				if(response.isSuccess){
					parent.$.ligerDialog.success(response.strMessage);
				}else{
					parent.$.ligerDialog.error(response.strMessage);
				}
			},
			error:function(response){
				wait.close();
				parent.$.ligerDialog.error("系统错误!");
			}
		});
	}
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


$(function(){
	$("#file").fileListener(function(file){
		$("#file_list").append('<li class="item">'+file.name+'&nbsp;&nbsp;<a class="remove" href="javascript:void(0)" data-id="'+file.id+'">移除</a></li>');
		$(".remove").on("click",function(){
			var id = $(this).data("id");
			$.fileRemove(id);
			$(this).parent().remove();
		})
	});
	toolbar();
	/*初始化富文本编辑器*/
	editor.create();
	
	/*添加收件人*/
	$(".group_send").click(function(){
		alert(JSON.stringify($(".group_send")));
	});
	
	$("#picker").click(function(){
		$("#file").click();
	});
});

