var grid;
/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text:'添加',icon:'add',click: function () {add();}});
	items.push({text:'编辑',icon:'edit',click: function () {edit();}});
	items.push({text:'删除',icon:'delete',click: function () {del(path+"/linkman/delete");}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}
/*添加*/
function add(){
	parent.$.ligerDialog.open({
		title : '添加联系人',
		width : 450,
		height : 400,
		allowClose : false,
		url : path+'/linkman/addlinkman',
		buttons : [ 
		    {
				text : '保存',
				onclick : function(item, dialog) {
					var data = dialog.frame.data();
					$.ajax({
						url:path+"/linkman/save",
						type:"post",
						dataType:"json",
						data:data,
						success:function(result){
							if(result.isSuccess){
								grid.loadData();
								dialog.close();
							}else{
								parent.$.ligerDialog.warn(result.strMessage);
							}
						},
						error:function(result){
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
/*编辑*/
function edit(){
	var rows = grid.getCheckedRows();
	if (rows && rows.length == 1) {
		var ids = [];
		$(rows).each(function() {
			ids.push(this.id);
		});
		parent.$.ligerDialog.open({
			title : '修改联系人',
			width : 450,
			height : 400,
			allowClose : false,
			url : path+'/linkman/addlinkman?id='+ids[0],
			buttons : [ 
			    {
					text : '保存',
					onclick : function(item, dialog) {
						var data = dialog.frame.data();
						$.ajax({
							url:path+"/linkman/save",
							type:"post",
							dataType:"json",
							data:data,
							success:function(result){
								if(result.isSuccess){
									grid.loadData();
									dialog.close();
								}else{
									parent.$.ligerDialog.warn(result.strMessage);
								}
							},
							error:function(result){
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
	}else{
		parent.$.ligerDialog.warn("选择一条数据");
	}
}
$(function(){
	/*工具栏方法*/
	toolbar();
	grid = $("#list").ligerGrid({
		checkbox: true,
		selectRowButtonOnly:true,
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '姓名', name: 'name', width: "5%" },
	        { display: '分组', name: 'group.groupName', width: "9%" },
	        { display: '住址', name: 'address', width:"35%" },
	        { display: '手机', name: 'mobile', width:"10%", },
	        { display: '电话', name: 'telephone', width:"10%", },
	        { display: 'QQ', name: 'qq', width:"10%", },
	        { display: '邮箱', name: 'email', width:"10%", },
	        { display: '其他', name: 'other', width:"10%", }
        ], pageSize:10,
        url:path+"/linkman/list",
        width: '100%',height:'99%'
	});
	$("#select").click(function(){
		grid.setOptions({  
            parms : {  
            	name: $("#name").val(),
            	groupId: $("#group").val()
            } 
		});  
		grid.loadData(true);
	});
});

