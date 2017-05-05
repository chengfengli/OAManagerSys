/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text:'新建日志',icon:'add',click: function () {addWorkLog();}});
	items.push({text:'编辑',icon:'edit',click: function () {edit();}});
	items.push({text:'删除',icon:'delete',click: function () {del();}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}
/*新建日志*/
function addWorkLog(){
	parent.$.ligerDialog.open({
		title : '新建工作日志',
		width : 450,
		height : 350,
		allowClose : false,
		url : path+'/worklog/addworklog',
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
/*编辑日志*/
function edit(){
	parent.$.ligerDialog.open({
		title : '新建工作日志',
		width : 450,
		height : 350,
		allowClose : false,
		url : path+'/worklog/addworklog',
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
	/*初始数据*/
	var array = [];
	for(var i=1;i<=100;i++){
		array.push({id:i,workDate:new Date(),content:"测试"+i,priority:"一级",performance:"未完成"});
	}
	var data={Rows:array};
	$("#list").ligerGrid({
		checkbox: true,
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '日期', name: 'workDate', width: "10%" },
	        { display: '工作内容', name: 'content', width:"50%" },
	        { display: '优先级', name: 'priority', width:"10%", },
	        { display: '完成情况', name: 'performance', width:"20%", }
        ], pageSize:10,
        data:data,
        width: '100%',height:'99%'
	});
});

