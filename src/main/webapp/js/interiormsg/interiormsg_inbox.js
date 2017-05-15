/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text: "详情",icon:'view',click: function () {details();}});
	items.push({ line:true });
	items.push({text: "删除",icon:'delete',click: function () {del();}});
	items.push({ line:true });
	items.push({text: "转发",icon:'outbox',click: function () {forward();}});
	items.push({ line:true });
	items.push({text: "标记位已读",icon:'ok',click: function () {signreaded();}});
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
function forward(){
	parent.$.ligerDialog.warn('转发!');
}
/*标记为已读*/
function signreaded(){
	parent.$.ligerDialog.warn('已读!');
}
$(function(){
	/*工具栏方法*/
	toolbar();
	/*初始化邮件列表*/
	var array = [];
	for(var i=1;i<=100;i++){
		array.push({id:i,sender:"张三"+i,status:"已读"+i,content:"测试"+i,receiveTime:"2017-02-15"});
	}
	var data={Rows:array};
	$("#list").ligerGrid({
		checkbox: true,
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '发送人', name: 'sender', width: "10%" },
	        { display: '状态', name: 'status', width: "10%" },
	        { display: '内容', name: 'content', width:"50%" },
	        { display: '时间', name: 'receiveTime', width:"30%", }
        ], pageSize:10,
        data:data,
        width: '100%',height:'99%'
	});
});

