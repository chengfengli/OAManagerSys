var grid=null;
/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text:'添加',icon:'add',click: function () {add()}});
	items.push({ line:true });
	items.push({text:'编辑',icon:'edit',click: function () {edit()}});
	items.push({ line:true });
	items.push({text:'删除',icon:'delete1',click: function () {del(path+"/department/delete")}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}
/*添加部门*/
function add(){
	parent.$.ligerDialog.open({
		title : '添加部门',
		width : 400,
		height :300,
		allowClose : false,
		url : path+"/department/adddeppage",
		buttons : [
			{
				text : '保存',
				onclick : function(item, dialog) {
					var data = dialog.frame.depData();
					$.ajax({
						url:path+"/department/adddep",
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
					title : '修改部门',
					width : 400,
					height : 300,
					allowClose : false,
					url : path+"/department/adddeppage?id="+ids[0],
					buttons : [
						{
							text : '保存',
							onclick : function(item, dialog) {
								var data = dialog.frame.depData();
								$.ajax({
									url:path+"/department/adddep",
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
	$("#entryTime").ligerDateEditor();
	/*工具栏方法*/
	toolbar();
	grid = $("#list").ligerGrid({
		url:path+"/department/deplist",
		checkbox: true,
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '编码', name: 'depCode', width: "15%" },
	        { display: '部门', name: 'depName', width:"10%"},
	        { display: '创建人', name: 'create.name', width:"15%"},
	        { display: '创建时间', name: 'createTime', width:"15%"},
	        { display: '描述', name: 'describe', width:"20%"},
        ], pageSize:10,
        width: '100%',height:'99%'
	});
	
	$("#select").click(function(){
		var depCode = $("#depCode").val();
		var id = $("#id").val();
		grid.setOptions({  
            parms : {  
            	depCode : depCode,  
                id : id  
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

