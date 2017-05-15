/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text:'保存',icon:'save',click: function () {}});
	items.push({ line:true });
	items.push({text:'重置',icon:'reset',click: function () {edit();}});
	items.push({ line:true });
	items.push({text:'返回',icon:'back',click: function () {back();}});
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
	$("#entryTime").ligerDateEditor({width:300 });
	$("#department,#onTrialTime").ligerComboBox({width:300});
});

