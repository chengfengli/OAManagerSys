/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text: "详情",icon:'view',click: function () {details();}});
	items.push({ line:true });
	items.push({text: "同意",icon:'ok',click: function () {ok();}});
	items.push({ line:true });
	items.push({text: "拒绝",icon:'delete1',click: function () {delete1();}});
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
					buttons : [ 
					    {
							text : '同意',
							onclick : function(item, dialog) {
								dialog.close();
							}
						},
						{
							text : '拒绝',
							onclick : function(item, dialog) {
								dialog.close();
							}
						},
						{
							text : '关闭',
							onclick : function(item, dialog) {
								dialog.close();
							}
						}
					  ]
				});
	}
}
/*同意*/
function ok(){
	parent.$.ligerDialog.warn('删除!');
}
/*拒绝*/
function delete1(){
	parent.$.ligerDialog.warn('拒绝!');
}
$(function(){
	/*工具栏方法*/
	toolbar();
	/*初始化邮件列表*/
	var array = [];
	for(var i=1;i<=100;i++){
		array.push({id:i,applyName:"张三"+i,reason:'阿达啊饿啊啊',startTime:'2017-05-01',endTime:"2017-05-02",status:"待审"});
	}
	var data={Rows:array};
	$("#list").ligerGrid({
		checkbox: true,
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '申请人', name: 'applyName', width: "10%" },
	        { display: '事由', name: 'reason', width: "50%" },
	        { display: '开始时间', name: 'startTime', width:"10%", },
	        { display: '结束时间', name: 'endTime', width:"10%", },
	        { display: '状态', name: 'status', width:"10%", }
        ], pageSize:10,
        data:data,
        width: '100%',height:'99%'
	});
});

