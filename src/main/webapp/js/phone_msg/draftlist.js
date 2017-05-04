/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text:'详情',icon:'view',click: function () {details();}});
	items.push({text:'编辑',icon:'edit',click: function () {edit();}});
	items.push({text:'删除',icon:'delete',click: function () {del();}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}
/*详情*/
function details(){
	location.href=path+"/email/details";
	return;
	var manager = $("#list").ligerGetGridManager();
	var rows = manager.getCheckedRows();
	if (rows && rows.length == 1) {
		var ids = [];
		$(rows).each(function() {
			ids.push(this.id);
		});
		parent.$.ligerDialog.warn(ids[0]);
	}
}
/*删除*/
function del(){
	parent.$.ligerDialog.warn('删除!');
}
/*转发*/
function edit(){
	parent.$.ligerDialog.warn('编辑!');
}
$(function(){
	/*工具栏方法*/
	toolbar();
	/*初始化邮件列表*/
	var array = [];
	for(var i=1;i<=100;i++){
		array.push({id:i,receiveposition:"张三"+i,content:"测试"+i,lastSaveTime:"2017-02-15 10:24"});
	}
	var data={Rows:array};
	$("#list").ligerGrid({
		checkbox: true,
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '收件人', name: 'receiveposition', width: "18%" },
	        { display: '内容', name: 'content', width:"50%" },
	        { display: '上次保存时间', name: 'lastSaveTime', width:"30%", }
        ], pageSize:10,
        data:data,
        width: '100%',height:'99%'
	});
});

