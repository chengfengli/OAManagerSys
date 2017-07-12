﻿var grid;
/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text: "详情",icon:'view',click: function () {details(path+"/email/details");}});
	items.push({ line:true });
	items.push({text: "删除",icon:'delete',click: function () {del(path+"/email/delete");}});
	items.push({ line:true });
	items.push({text: "转发",icon:'outbox',click: function () {edit(path+"/email/writerEmail?type=forward");}});
	items.push({ line:true });
	items.push({text: "标记为已读",icon:'ok',click: function () {signreaded();}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}

/*标记为已读*/
function signreaded(){
	var rows = grid.getCheckedRows();
	if (rows && rows.length > 0) {
		var ids = '';
		var emailStatus = [];
		$(rows).each(function() {
			emailStatus.push(this.emailStatus);
			if(ids == ''){
				ids+= ''+this.id;
			}else{
				ids+= ','+this.id;
			}
		});
		for(var i in emailStatus){
			if(emailStatus[i] == 1){
				parent.$.ligerDialog.warn("数据中包含了已读邮件!");
				return;
			}
		}
		$.ajax({
			url:path+"/email/readed",
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
		parent.$.ligerDialog.warn("选择要操作的数据!");
	}
}

$(function(){
	$("#sendTime").ligerDateEditor();
	/*工具栏方法*/
	toolbar();
	grid = $("#email_list").ligerGrid({
		checkbox: true,
		selectRowButtonOnly:true,
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '发件人', name: 'emp.name', width: "9%" },
	        { display: '状态', name: 'emailStatus', width: "10%",render:function(row){
	        	if(row.emailStatus == 0){
	        		return "未读";
	        	}else if(row.emailStatus == 1){
	        		return "已读";
	        	}
	        }},
	        { display: '主题', name: 'title', width:"50%" },
	        { display: '时间', name: 'sendTime', width:"20%", },
	        { display: '附件', name: 'fileId', width:"10%",render:function(row){
	        	if(row.fileId != null && row.fileId != ''){
	        		return '<img class="fileId" onclick="files('+row.fileId+')" style="margin-top:6px;cursor:pointer;" src="/icon/paper.png" />';
	        	}
	        } }
        ], pageSize:10,
        url:path + "/email/inboxList",
        width: '100%',height:'99%'
	});
	
	$("#select").click(function(){
		var sendName = $("#sendName").val();
		var sendTime = $("#sendTime").val();
		var acceptStatus = $("#status").val();
		grid.setOptions({  
            parms : {  
            	sendName : sendName,  
            	sendTime : sendTime,
            	acceptStatus: acceptStatus
            } 
		});  
		grid.loadData(true); 
	});
});

