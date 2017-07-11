var grid;
/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text: "详情",icon:'view',click: function () {details();}});
	items.push({ line:true });
	items.push({text: "删除",icon:'delete',click: function () {del();}});
	items.push({ line:true });
	items.push({text: "编辑",icon:'edit',click: function () {edit(path+"/email/writerEmail?type=edit");}});
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
			url:path+"/email/delete",
			type:"post",
			dataType:"json",
			data:{ids:ids},
			success:function(response){
				if(response.isSuccess){
					grid.loadData();
				}
			},
			error:function(){
				parent.$.ligerDialog.error("系统错误!");
			}
		});
	}else{
		parent.$.ligerDialog.warn("选择要操作的邮件!");
	}
}


$(function(){
	$("#time").ligerDateEditor();
	/*工具栏方法*/
	toolbar();
	grid=$("#email_list").ligerGrid({
		checkbox: true,
		selectRowButtonOnly:true,
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '收件人', name: 'acceptName', width: "10%"},
	        { display: '主题', name: 'title', width:"50%"},
	        { display: '时间', name: 'sendTime', width:"30%"},
	        { display: '附件', name: 'fileId', width:"9%",render:function(row){
	        	if(row.fileId != null && row.fileId != ''){
	        		return '<img class="fileId" onclick="files('+row.fileId+')" style="margin-top:6px;cursor:pointer;" src="/icon/paper.png" />';
	        	}
	        }}
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
            	sendName : sender,  
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

