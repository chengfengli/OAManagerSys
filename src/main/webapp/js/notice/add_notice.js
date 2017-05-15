/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text: "发布",icon:'up',click: function () {send()}});
	items.push({ line:true });
	items.push({text: "重置",icon:'reset',click: function () {}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}

$(function(){
	$("#format,#type").ligerComboBox({width:300});
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

