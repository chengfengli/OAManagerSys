var grid;
/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text: "详情",icon:'view',click: function () {details();}});
	items.push({ line:true });
	items.push({text: "删除",icon:'delete',click: function () {del();}});
	items.push({ line:true });
	items.push({text: "转发",icon:'outbox',click: function () {forward();}});
	items.push({ line:true });
	items.push({text: "标记为已读",icon:'ok',click: function () {signreaded();}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}
/*详情*/
function details(){
	var manager = $("#email_list").ligerGetGridManager();
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
	var rows = grid.getCheckedRows();
	if (rows && rows.length > 0) {
		var ids = '';
		$(rows).each(function() {
			if(ids == ''){
				ids+= ''+this.id;
			}else{
				ids+= ','+this.id;
			}
		});
		$.ajax({
			url:path+"/email/readed",
			type:"post",
			dataType:"json",
			data:{id:ids},
			success:function(response){
				parent.$.ligerDialog.success(response.strMessage);
				grid.loadData();
			},
			error:function(){
				parent.$.ligerDialog.error("系统错误!");
			}
		});
	}else{
		parent.$.ligerDialog.warn("选择要操作的数据!");
	}
	parent.$.ligerDialog.warn('已读!');
}
$(function(){
	$("#sendTime").ligerDateEditor();
	/*工具栏方法*/
	toolbar();
	/*初始化邮件列表*/
	var array = [];
	for(var i=1;i<=100;i++){
		array.push({id:i,sender:"张三"+i,status:"已读"+i,subject:"测试"+i,receiveTime:"2017-02-15"});
	}
	var data={Rows:array};
	grid = $("#email_list").ligerGrid({
		checkbox: true,
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '发件人', name: 'emp.name', width: "9%" },
	        { display: '状态', name: 'acceptStatus', width: "10%",render:function(row){
	        	if(row.acceptStatus == 0){
	        		return "未读";
	        	}else if(row.acceptStatus == 1){
	        		return "已读";
	        	}
	        }},
	        { display: '主题', name: 'title', width:"50%" },
	        { display: '时间', name: 'sendTime', width:"30%", }
        ], pageSize:10,
        url:path + "/email/inboxList",
        width: '100%',height:'99%'
	});
	
	$("#select").click(function(){
		var sendUser = $("#sendUser").val();
		var sendTime = $("#sendTime").val();
		var acceptStatus = $("#status").val();
		grid.setOptions({  
            parms : {  
            	sendUser : sendUser,  
            	sendTime : sendTime,
            	acceptStatus: acceptStatus
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

