var manager;
/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text:'新建周报',icon:'add',click: function () {addWorkLog();}});
	items.push({text:'编辑',icon:'edit',click: function () {edit();}});
	items.push({text:'删除',icon:'delete',click: function () {del();}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}
/*新建周报*/
function addWorkLog(){
	parent.$.ligerDialog.open({
		title : '新建工作日志',
		width : 450,
		height : 350,
		allowClose : false,
		url : path+'/worklog/addweeklog',
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
/*编辑周报*/
function edit(){
	parent.$.ligerDialog.open({
		title : '编辑周报',
		width : 450,
		height : 350,
		allowClose : false,
		url : path+'/worklog/addweeklog',
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
/*保存*/
function beginEdit(rowindex){
	var data = manager.getData();
	alert(data[rowindex].performance);
}
$(function(){
	/*工具栏方法*/
	toolbar();
	$("#weekDate").ligerDateEditor();
	/*初始数据*/
	var array = [];
	for(var i=1;i<=100;i++){
		array.push({id:i,workDate:new Date(),content:"测试"+i,priority:"一级",performance:"未完成"});
	}
	var data={Rows:array};
	manager=$("#list").ligerGrid({
		checkbox: true,
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '工作内容', name: 'content', width:"45%" },
	        { display: '优先级', name: 'priority', width:"10%", },
	        { display: '完成日期', name: 'workDate', width: "19%" },
	        { display: '完成情况', name: 'performance',editor: { type: 'text' }, width:"20%", },
	        { display: '操作',isSort: false, width:"5%",render: function (rowdata, rowindex, value){
                var h = "";
                if (!rowdata._editing){
                    h += "<a href='javascript:beginEdit(" + rowindex + ")'>保存</a> ";
                }
                return h;
            }
        }
        ], pageSize:10,
        enabledEdit: true,
        data:data,
        width: '100%',height:'99%'
	});
});

