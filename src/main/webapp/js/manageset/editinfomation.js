/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text:'保存',icon:'save',click: function () {}});
	items.push({ line:true });
	items.push({text:'重置',icon:'reset',click: function () {edit();}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}
$(function(){
	toolbar();
	$("#birthDay").ligerDateEditor({width:200});
	$("#politicsStatus,#sex,#child").ligerComboBox({width:200});
});

