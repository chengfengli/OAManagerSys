/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text: "返回",icon:'back',click: function () {back()}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}
/*返回*/
function back(){
	history.go(-1);
}
$(function(){
	toolbar();
	/*下载*/
	$(".download").click(function(){
		var id = $(this).data("id");
		download(id);
	});
});

