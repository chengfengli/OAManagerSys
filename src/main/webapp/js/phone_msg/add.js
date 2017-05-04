/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text: "发送",icon: 'up',click: function () {send()}});
	items.push({text: "存草稿",icon: 'pager',click: function () {}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}
/*验证、发送*/
function send(){
	var account = $("#account").val();
	var subject = $("#subject").val();
	if(account.trim()==""){
		parent.$.ligerDialog.warn('填写收件人!');
		return;
	}
	if(subject.trim()==""){
		parent.$.ligerDialog.warn('填写主题!');
		return;
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

$(function(){
	toolbar();
	/*初始化富文本编辑器*/
	var editor = new wangEditor('content');
	editor.create();
});

