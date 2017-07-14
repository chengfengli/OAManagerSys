var grid;
/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text: "详情",icon:'view',click: function () {details(path+"/interiormsg/send/details");}});
	items.push({ line:true });
	items.push({text: "删除",icon:'delete',click: function () {del(path+"/interiormsg/delete");}});
	items.push({ line:true });
	items.push({text: "编辑",icon:'edit',click: function () {edit(path+"/interiormsg/writerMsg?type=edit");}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}

$(function(){
	/*工具栏方法*/
	toolbar();
	grid = $("#msg_list").ligerGrid({
		checkbox: true,
		selectRowButtonOnly:true,
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '接收人', name: 'acceptName', width: "10%" },
	        { display: '短信内容', name: 'content', width: "50%" },
	        { display: '发送时间', name: 'sendTime', width:"12%", }
        ], pageSize:10,
        url:path+"/interiormsg/sendList",
        width: '100%',height:'99%'
	});
});

