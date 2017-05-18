﻿/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text:'添加',icon:'add',click: function () {add()}});
	items.push({ line:true });
	items.push({text:'编辑',icon:'edit',click: function () {}});
	items.push({ line:true });
	items.push({text:'详情',icon:'view',click: function () {}});
	items.push({ line:true });
	items.push({text:'删除',icon:'delete1',click: function () {}});
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
		url : path+"/post/addpost",
		buttons : [
			{
				text : '保存',
				onclick : function(item, dialog) {
					console.log(dialog.frame.data);
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
	location.href=path+"/user/adduser";
}
/*leaveOffice*/
function leaveOffice(){
	
}
/*删除*/
function del(){
	parent.$.ligerDialog.warn('删除!');
}
$(function(){
	$("#entryTime").ligerDateEditor();
	/*工具栏方法*/
	toolbar();
	/*初始数据*/
	var array = [];
	for(var i=1;i<=100;i++){
		array.push({id:i,code:"0000DAFD"+i,position:"总经理"+i,department:"销售部",createTime:"2017-05-01",creater:"超级管理员"});
	}
	var data={Rows:array};
	$("#list").ligerGrid({
		checkbox: true,
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '编码', name: 'code', width: "10%" },
	        { display: '职位', name: 'position', width:"10%"},
	        { display: '部门', name: 'department', width:"10%"},
	        { display: '创建时间', name: 'createTime', width:"15%"},
	        { display: '创建人', name: 'creater', width:"15%"}
        ], pageSize:10,
        data:data,
        width: '100%',height:'99%'
	});
});

