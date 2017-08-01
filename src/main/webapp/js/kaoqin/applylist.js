var grid;
/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text: "申请",icon:'add',click: function () {leave();}});
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
		title : '发起申请',
		width : 450,
		height : 430,
		allowClose : false,
		url : path+'/apply/page/apply',
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
	grid = $("#list").ligerGrid({
		checkbox: true,
		selectRowButtonOnly:true,
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '申请类型', name: 'applyType.typeName', width: "5%" },
	        { display: '开始时间', name: 'startTime', width: "15%" },
	        { display: '结束时间', name: 'endTime', width: "15%" },
	        { display: '时长', name: 'longHours', width:"5%", },
	        { display: '出差地点', name: 'address', width:"15%", },
	        { display: '外出事由', name: 'reason', width:"34%", },
	        { display: '审批人', name: 'approverEmp.name', width:"5%", },
	        { display: '状态', width:"5%",render:function(row){
	        	if(row.status=="w"){
	        		return "<span style='color:orange;'>待审</span>";
	        	}else if(row.status=="a"){
	        		return "<span style='color:green;'>同意</span>";
	        	}else if(row.status=="d"){
	        		return "<span style='color:red;'>拒绝</span>";
	        	}
	        }}
        ], pageSize:10,
        url:path+"/apply/applylist",
        width: '100%',height:'99%'
	});
	$("#select").click(function(){
		var typeCode = $("#typeCode").val();
		var startTime = $("#startTime").val();
		var endTime = $("#endTime").val()+" 59:59:59";
		grid.setOptions({  
            parms : {  
            	typeCode : typeCode,
            	startTime : startTime,
            	endTime : endTime
            } 
		});  
		grid.loadData(true);
	});
});

