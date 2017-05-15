/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text: "发送",icon:'up',click: function () {send()}});
	items.push({ line:true });
	items.push({text: "存草稿",icon:'pager',click: function () {}});
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
/**/
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
	toolbar();
	/*初始化富文本编辑器*/
	var editor = new wangEditor('content');
	editor.create();
	/*选择附件*/
	$("#browse").click(function(){
		$("#file").click();
	});
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

