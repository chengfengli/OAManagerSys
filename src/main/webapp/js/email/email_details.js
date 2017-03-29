/*工具栏*/
function toolbar() {
	var items = [];
	items.push({ type: 'button', text: "返回",click: function () {back()}});
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
});

