var grid;
/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text: "详情",icon:'view',click: function () {details();}});
	items.push({ line:true });
	items.push({text: "删除",icon:'delete',click: function () {del();}});
	items.push({ line:true });
	items.push({text: "编辑",icon:'edit',click: function () {edit();}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}
/*详情*/
function details(){
	var rows = grid.getCheckedRows();
	if (rows && rows.length == 1) {
		var ids = [];
		$(rows).each(function() {
			ids.push(this.id);
		});
		location.href = path+"/email/send_details?id="+ids[0];
	}else{
		parent.$.ligerDialog.warn("选择一封邮件");
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
	$("#time").ligerDateEditor();
	/*工具栏方法*/
	toolbar();
	/*初始化邮件列表*/
	var array = [];
	for(var i=1;i<=100;i++){
		array.push({id:i,receiveposition:"张三"+i,status:"已读"+i,subject:"测试"+i,addTime:"2017-02-15 10:24"});
	}
	var data={Rows:array};
	grid=$("#email_list").ligerGrid({
		checkbox: true,
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '收件人', name: 'acceptName', width: "10%" },
	        { display: '主题', name: 'title', width:"50%" },
	        { display: '时间', name: 'sendTime', width:"30%", }
        ], pageSize:10,
        url:path+"/email/outboxList",
        width: '100%',height:'99%'
	});
	
	/*搜索*/
	$("#select").click(function(){
		var sender = $("#sender").val();
		var sendTime = $("#time").val();
		grid.setOptions({
            parms : {
            	sendUser : sendUser,  
            	sendTime : sendTime
            } 
		});  
		grid.loadData(true); 
	});
	$(document).keypress(function(e) {
		if (e.keyCode == 13) {
			$("#select").click();
		}
	})
});

