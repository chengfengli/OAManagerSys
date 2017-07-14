var grid;
/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text: "详情",icon:'view',click: function () {details(path+"/interiormsg/accept/details");}});
	items.push({ line:true });
	items.push({text: "删除",icon:'delete',click: function () {del(path+"/interiormsg/delete");}});
	items.push({ line:true });
	items.push({text: "转发",icon:'outbox',click: function () {edit(path+"/interiormsg/writerMsg?type=forward");}});
	items.push({ line:true });
	items.push({text: "标记为已读",icon:'ok',click: function () {signreaded(path+"/interiormsg/read");}});
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
	        { display: '发送人', name: 'emp.name', width: "10%" },
	        { display: '状态', name: 'readStatus', width: "10%",render:function(row){
	        	if(row.readStatus == 0){
	        		return "未读";
	        	}else{
	        		return "已读";
	        	}
	        }},
	        { display: '内容', name: 'content', width:"50%" },
	        { display: '时间', name: 'sendTime', width:"30%", }
        ], pageSize:10,
        url:path+"/interiormsg/acceptList",
        width: '100%',height:'99%'
	});
});

