/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text:'修改密码',icon:'editpwd',click: function () {edit();}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}
$(function(){
	toolbar();
	$("#birthDay").ligerDateEditor({width:200});
	$("#politicsStatus,#sex").ligerComboBox({width:200});
});

