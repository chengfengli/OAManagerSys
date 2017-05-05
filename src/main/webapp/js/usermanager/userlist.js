/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text:'设置权限',icon:'setting',click: function () {setting();}});
	items.push({text:'编辑',icon:'edit',click: function () {edit();}});
	items.push({text:'删除',icon:'delete',click: function () {del();}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}
/*设置权限*/
function setting(){
	
}
/*编辑*/
function edit(){
	
}
/*删除*/
function del(){
	parent.$.ligerDialog.warn('删除!');
}
$(function(){
	/*工具栏方法*/
	toolbar();
	/*初始数据*/
	var array = [];
	for(var i=1;i<=100;i++){
		array.push({id:i,workNo:"0000"+i,name:"李四"+i,branch:"销售部",post:"销售经理",entryTime:"2017-05-01",official:"否",onJob:"在职"});
	}
	var data={Rows:array};
	$("#list").ligerGrid({
		checkbox: true,
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '工号', name: 'workNo', width: "10%" },
	        { display: '姓名', name: 'name', width:"50%" },
	        { display: '部门', name: 'branch', width:"10%"},
	        { display: '职位', name: 'post', width:"20%"},
	        { display: '入职时间', name: 'entryTime', width:"10%"},
	        { display: '是否转正', name: 'official', width:"20%"},
	        { display: '是否在职', name: 'onJob', width:"10%"}
        ], pageSize:10,
        data:data,
        width: '100%',height:'99%'
	});
});

