/*初始化富文本编辑器*/
var editor = new wangEditor('content');
editor.create();
/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text: "发送",icon: 'up',click: function () {send()}});
	items.push({ line:true });
	items.push({text: "存草稿",icon: 'pager',click: function () {draft()}});
	if(backbtn == 'true'){
		items.push({ line:true });
		items.push({text: "返回",icon:'back',click: function () {history.go(-1);}});
	}
	$("#toolbar").ligerToolBar({
		items: items
	});
}
/*验证、发送*/
function send(){
	var id = $("#id").val();
	if(id==""){
		id=0;
	}
	var account = $("#account").val();
	var content = editor.$txt.html();
	if(account == "" || account.trim()==""){
		parent.$.ligerDialog.warn('填写收信人!');
		return;
	}
	if(content == "" ||content.trim()==""){
		parent.$.ligerDialog.warn('填写消息内容!');
		return;
	}
	var data = {
			content: content,
			acceptNo: account
		}
	var wait = parent.$.ligerDialog.waitting('发送中,请稍候...');
	$.ajax({
		url:path+"/interiormsg/sendMsg",
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

/*草稿*/
function draft(){
	var id = $("#id").val();
	if(id == ''){
		id=0;
	}
	var account = $("#account").val();
	var content = editor.$txt.html();
	if(content == "" ||content.trim()==""){
		parent.$.ligerDialog.warn('填写消息内容!');
		return;
	}
	var data = {
			content: content,
			acceptNo: account
		}
	var wait = parent.$.ligerDialog.waitting('保存中,请稍候...');
	$.ajax({
		url:path+"/interiormsg/draft",
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

$(function(){
	toolbar();
});

