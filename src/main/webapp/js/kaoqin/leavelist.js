/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text: "请假",icon:'add',click: function () {leave();}});
	items.push({ line:true });
	items.push({text: "销假",icon:'delete',click: function () {}});
	items.push({ line:true });
	items.push({text: "撤销",icon:'candle',click: function () {}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}

/*请假*/
function leave(){
	parent.$.ligerDialog.open({
		title : '请假申请',
		width : 450,
		height : 400,
		allowClose : false,
		url : path+'/leave/leave',
		buttons : [ 
		    {
				text : '申请',
				onclick : function(item, dialog) {
					dialog.close();
				}
		    },
		    {
				text : '返回',
				onclick : function(item, dialog) {
					dialog.close();
				}
			}
		]
	});
}

$(function(){
	$("#startTime,#endTime").ligerDateEditor();
	/*工具栏方法*/
	toolbar();
	/*初始数据*/
	var array = [];
	for(var i=1;i<=100;i++){
		array.push({
			id:i,
			startTime:"2017-05-15 09:00",
			endTime:"2017-05-15 18:00",
			longHours:8,
			leaveType:"事假",
			reason:"山东人大大大",
			approve:"张三",
			status:"同意"
		});
	}
	var data={Rows:array};
	$("#list").ligerGrid({
		checkbox: true,
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '开始时间', name: 'startTime', width: "15%" },
	        { display: '结束时间', name: 'endTime', width: "15%" },
	        { display: '时长', name: 'longHours', width:"5%", },
	        { display: '类型', name: 'leaveType', width:"10%", },
	        { display: '事由', name: 'reason', width:"34%", },
	        { display: '审批人', name: 'approve', width:"10%", },
	        { display: '状态', name: 'status', width:"10%", }
        ], pageSize:10,
        data:data,
        width: '100%',height:'99%'
	});
});

