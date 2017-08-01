/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text: "外出",icon:'add',click: function () {leave();}});
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
		title : '申请外出',
		width : 450,
		height : 400,
		allowClose : false,
		url : path+'/goout/goout',
		buttons : [
		    {
				text : '申请',
				onclick : function(item, dialog) {
					var data = dialog.frame.data();
					$.ajax({
						url:path+"/apply/apply",
						type:"post",
						dataType:"json",
						data:data,
						success:function(result){
							if(result.isSuccess){
								parent.$.ligerDialog.success(result.strMessage);
								dialog.close();
							}else{
								parent.$.ligerDialog.warn(result.strMessage);
							}
						},
						error:function(){
							parent.$.ligerDialog.error("系统异常");
						}
					});
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
	$("#list").ligerGrid({
		checkbox: true,
		selectRowButtonOnly:true,
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '开始时间', name: 'startTime', width: "15%" },
	        { display: '结束时间', name: 'endTime', width: "15%" },
	        { display: '时长', name: 'longHours', width:"5%", },
	        { display: '外出事由', name: 'reason', width:"34%", },
	        { display: '审批人', name: 'approverEmp.name', width:"10%", },
	        { display: '状态', width:"10%",render:function(row){
	        	if(row.status=="w"){
	        		return "待审";
	        	}else if(row.status=="a"){
	        		return "同意";
	        	}else if(row.status=="d"){
	        		return "拒绝";
	        	}
	        }}
        ], pageSize:10,
        url:path+"/apply/outlist",
        width: '100%',height:'99%'
	});
});

