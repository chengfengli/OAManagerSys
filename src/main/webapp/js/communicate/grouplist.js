/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text:'新建',icon:'add',click: function () {add();}});
	items.push({text:'编辑',icon:'edit',click: function () {edit();}});
	items.push({text:'删除',icon:'delete',click: function () {del();}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}
/*新建组*/
function add(){
	parent.$.ligerDialog.open({
		title : '新建分组',
		width :350,
		height : 170,
		allowClose : false,
		url : path+'/group/addgroup',
		buttons : [ 
		    {
				text : '保存',
				onclick : function(item, dialog) {
					var data = dialog.frame.data();
					console.log(data);
					$.ajax({
						url:path+"/group/save",
						type:"post",
						dataType:"json",
						data:data,
						success:function(result){
							if(result.isSuccess){
								dialog.close();
								grid.loadData();
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
/*编辑日志*/
function edit(){
	parent.$.ligerDialog.open({
		title : '编辑分组',
		width :350,
		height : 170,
		allowClose : false,
		url : path+'/group/addgroup',
		buttons : [ 
		    {
				text : '保存',
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
/*删除日志*/
function del(){
	parent.$.ligerDialog.warn('删除!');
}
$(function(){
	/*工具栏方法*/
	toolbar();
	$("#startTime,#endTime").ligerDateEditor();
	/*初始数据*/
	var array = [];
	for(var i=1;i<=100;i++){
		array.push({id:i,code:"ADFASDF",grouName:"分组一"+i,createTime:new Date(),lastUpdateTime:new Date()});
	}
	var data={Rows:array};
	$("#list").ligerGrid({
		checkbox: true,
        columns: [
	        { display: 'id', name: 'id',hide : true},
	        { display: '编码', name: 'code', width: "10%"},
	        { display: '组名', name: 'grouName', width:"15%"},
	        { display: '创建时间', name: 'createTime', width:"15%"},
	        { display: '上次修改时间', name: 'lastUpdateTime', width:"15%"}
        ], pageSize:10,
        data:data,
        width: '100%',height:'99%'
	});
});

