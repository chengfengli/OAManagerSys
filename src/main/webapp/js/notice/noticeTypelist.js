var grid=null;
/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text:'添加',icon:'add',click: function () {add()}});
	items.push({ line:true });
	items.push({text:'编辑',icon:'edit',click: function () {edit()}});
	items.push({ line:true });
	items.push({text:'删除',icon:'delete1',click: function () {del(path+"/noticeType/delete")}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}
/*添加部门*/
function add(){
	parent.$.ligerDialog.open({
		title : '添加类型',
		width : 400,
		height :300,
		allowClose : false,
		url : path+"/noticeType/page/noticeType",
		buttons : [
			{
				text : '保存',
				onclick : function(item, dialog) {
					var data = dialog.frame.typeData();
					$.ajax({
						url:path+"/noticeType/save",
						type:"post",
						dataType:"json",
						data:data,
						success:function(response){
							if(response.isSuccess){
								dialog.close();
								grid.loadData();
								parent.$.ligerDialog.success(response.strMessage);
							}else{
								parent.$.ligerDialog.warn(response.strMessage);
							}
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
/*编辑*/
function edit(){
	var rows = grid.getCheckedRows();
	if (rows && rows.length == 1) {
		var ids = [];
		$(rows).each(function() {
			ids.push(this.id);
		});
		parent.$.ligerDialog.open({
					title : '修改类型',
					width : 400,
					height : 300,
					allowClose : false,
					url : path+"/noticeType/page/noticeType?id="+ids[0],
					buttons : [
						{
							text : '保存',
							onclick : function(item, dialog) {
								var data = dialog.frame.typeData();
								$.ajax({
									url:path+"/noticeType/save",
									type:"post",
									dataType:"json",
									data:data,
									success:function(response){
										if(response.isSuccess){
											dialog.close();
											grid.loadData();
											parent.$.ligerDialog.success(response.strMessage);
										}else{
											parent.$.ligerDialog.success(response.strMessage);
										}
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
	}else{
		parent.$.ligerDialog.warn("选择一条数据!");
	}
}

$(function(){
	/*工具栏方法*/
	toolbar();
	grid = $("#list").ligerGrid({
		url:path+"/noticeType/list",
		checkbox: true,
		selectRowButtonOnly:true,
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '类型编码', name: 'typeCode', width: "15%" },
	        { display: '类型名称', name: 'typeName', width:"10%"},
	        { display: '创建人', name: 'create.name', width:"15%"},
	        { display: '创建时间', name: 'createTime', width:"15%"},
	        { display: '修改人', name: 'update.name', width:"15%"},
	        { display: '最近修改时间', name: 'lastUpdateTime', width:"15%"}
        ], pageSize:10,
        width: '100%',height:'99%'
	});
	
	$("#select").click(function(){
		var typeName = $("#typeName").val();
		grid.setOptions({  
            parms : {  
            	typeName : typeName
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

