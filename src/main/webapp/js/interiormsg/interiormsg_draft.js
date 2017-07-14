var grid;
/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text:'详情',icon:'view',click: function () {details(path+"/interiormsg/send/details");}});
	items.push({ line:true });
	items.push({text:'编辑',icon:'edit',click: function () {edit(path+"/interiormsg/writerMsg?type=edit");}});
	items.push({ line:true });
	items.push({text:'删除',icon:'delete',click: function () {del(path+"/interiormsg/delete");}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}

$(function(){
	/*工具栏方法*/
	toolbar();
	grid = $("#list").ligerGrid({
		checkbox: true,
		selectRowButtonOnly:true,
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '收件人', name: 'acceptName', width: "18%" },
	        { display: '内容', name: 'content', width:"50%" },
	        { display: '创建时间', name: 'createTime', width:"15%", },
	        { display: '上次保存时间', name: 'lastUpdateTime', width:"15%", }
        ], pageSize:10,
        url:path+"/interiormsg/draftList",
        width: '100%',height:'99%'
	});
});

