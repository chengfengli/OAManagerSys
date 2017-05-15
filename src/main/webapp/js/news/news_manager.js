/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text: "详情",icon:'view',click: function () {details();}});
	items.push({ line:true });
	items.push({text: "编辑",icon:'edit',click: function () {}});
	items.push({ line:true });
	items.push({text: "查阅情况",icon:'chart',click: function () {}});
	items.push({ line:true });
	items.push({text: "删除",icon:'delete',click: function () {del();}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}
/*详情*/
function details(){
	var manager = $("#list").ligerGetGridManager();
	var rows = manager.getCheckedRows();
	if (rows && rows.length == 1) {
		var ids = [];
		$(rows).each(function() {
			ids.push(this.id);
		});
		parent.$.ligerDialog.warn(ids[0]);
		return;
		$.ligerDialog.open({
					title : '消息详情',
					width : 900,
					height : 500,
					allowClose : false,
					url : '${_ctx}/bap/message/detailedMessage?url=replyPage&messageId='+ ids[0],
					buttons : [ {
						text : '返回',
						onclick : function(item, dialog) {
							dialog.close();
						}
					} ]
				});
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
	/*模拟数据*/
	var array = [];
	for(var i=1;i<=100;i++){
		array.push({id:i,title:"张三"+i,format:'MHT格式',type:'aadfa',content:"短信内容"+i,issueUser:"张三",issueTime:"2017-02-15 10:24"});
	}
	var data={Rows:array};
	$("#list").ligerGrid({
		checkbox: true,
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '标题', name: 'title', width: "10%" },
	        { display: '格式', name: 'format', width: "8%" },
	        { display: '类型', name: 'type', width:"8%", },
	        { display: '内容', name: 'content', width:"38javascript:void(0);%", },
	        { display: '发布人', name: 'issueUser', width:"8%", },
	        { display: '发布日期', name: 'issueTime', width:"19%", }
        ], pageSize:10,
        data:data,
        width: '100%',height:'99%'
	});
});

