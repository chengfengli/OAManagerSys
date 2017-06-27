var grid
/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text:'添加',icon:'add',click: function () {add()}});
	items.push({ line:true });
	items.push({text:'编辑',icon:'edit',click: function () {edit()}});
	items.push({ line:true });
	items.push({text:'删除',icon:'delete1',click: function () {del()}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}
/*添加职位*/
function add(){
	parent.$.ligerDialog.open({
		title : '添加职位',
		width : 500,
		height :300,
		allowClose : false,
		url : path+"/post/addpostpage",
		buttons : [
			{
				text : '保存',
				onclick : function(item, dialog) {
					var data = dialog.frame.data();
					$.ajax({
						url:path+"/post/addpost",
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
/*编辑*/
function edit(){
	var rows = grid.getCheckedRows();
	if (rows && rows.length == 1) {
		var ids = [];
		$(rows).each(function() {
			ids.push(this.id);
		});
		parent.$.ligerDialog.open({
			title : '修改职位',
			width : 500,
			height :300,
			allowClose : false,
			url : path+"/post/addpostpage?id="+ids[0],
			buttons : [
				{
					text : '保存',
					onclick : function(item, dialog) {
						var data = dialog.frame.data();
						$.ajax({
							url:path+"/post/addpost",
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
	}else{
		parent.$.ligerDialog.warn("选择一条数据!");
	}
}

/*删除*/
function del(){
	var rows = grid.getCheckedRows();
	if (rows && rows.length != 0) {
		var ids = '';
		$(rows).each(function() {
			if(ids == ''){
				ids+= ''+this.id;
			}else{
				ids+= ','+this.id;
			}
		});
		parent.$.ligerDialog.confirm('确定删除职位？', function (yes) {
			if(yes){
				$.ajax({
					url:path+"/post/delete",
					type:"post",
					dataType:"json",
					data:{id:ids},
					seccess:function(response){
						grid.loadData();
						parent.$.ligerDialog.success(response.strMessage);
					},
					error:function(response){
						parent.$.ligerDialog.error('系统错误');
					}
				});
			}
		});
	}else{
		parent.$.ligerDialog.warn("选择要删除的数据!");
	}
}
$(function(){
	$("#entryTime").ligerDateEditor();
	/*工具栏方法*/
	toolbar();
	/*初始数据*/
	grid = $("#list").ligerGrid({
		url:path+"/post/getpost",
		checkbox: true,
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '编码', name: 'positionCode', width: "10%" },
	        { display: '职位', name: 'positionName', width:"10%"},
	        { display: '部门', name: 'dep.depName', width:"10%"},
	        { display: '创建时间', name: 'createTime', width:"15%"},
	        { display: '创建人', name: 'create.name', width:"15%"}
        ], pageSize:10,
        width: '100%',height:'99%'
	});
});

