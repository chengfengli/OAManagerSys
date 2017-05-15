/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text: "返回",icon:'back',click: function () {back()}});
	items.push({ line:true });
	items.push({text: "编辑",icon:'edit',click: function () {back()}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}
/*返回*/
function back(){
	history.go(-1);
}

/*编辑*/
function back(){
	
}
$(function(){
	toolbar();
});

