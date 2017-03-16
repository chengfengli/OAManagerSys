function toolbar() {
	var items = [];
	items.push({ type: 'button', text: "发送", icon: 'right', click: function () {}});
	items.push({ type: 'button', text: "存草稿", icon: 'save', click: function () {}});
	items.push({ type: 'button', text: "返回", icon: 'back', click: function () {} });
	$("#toolbar").ligerToolBar({
		items: items
	});
}
$(function(){
	toolbar();
});

