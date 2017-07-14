var grid;
/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text: "详情",icon:'view',click: function () {details(path+"/email/details");}});
	items.push({ line:true });
	items.push({text: "删除",icon:'delete',click: function () {del(path+"/email/delete");}});
	items.push({ line:true });
	items.push({text: "转发",icon:'outbox',click: function () {edit(path+"/email/writerEmail?type=forward");}});
	items.push({ line:true });
	items.push({text: "标记为已读",icon:'ok',click: function () {signreaded(path+"/email/readed");}});
	$("#toolbar").ligerToolBar({
		items: items
	});
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

