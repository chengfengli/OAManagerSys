var grid;
/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text:'编辑',icon:'edit',click: function () {edit();}});
	items.push({ line:true });
	items.push({text:'个人信息',icon:'information_personal',click: function () {}});
	items.push({ line:true });
	items.push({text:'离职',icon:'delete',click: function () {leaveOffice();}});
	items.push({ line:true });
	items.push({text:'删除',icon:'delete1',click: function () {del();}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}
/*设置权限*/
function setting(){
	$.ligerDialog.open({
		title : '添加菜单',
		width : 300,
		height :300,
		allowClose : false,
		url : path+"/user/setpermission",
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
		array.push({id:i,workNo:"0000"+i,name:"李四"+i,department:"销售部",position:"销售经理",entryTime:"2017-05-01",onTrialTime:"三个月",official:"否",onJob:"在职"});
	}
	var data={Rows:array};
	grid = $("#list").ligerGrid({
		url:path+"/user/getallemp",
		checkbox: true,
        columns: [
	        { display: '工号', name: 'id', width: "10%" },
	        { display: '姓名', name: 'name', width:"10%" },
	        { display: '部门', name: 'dep.depName', width:"10%"},
	        { display: '职位', name: 'position', width:"10%"},
	        { display: '入职时间', name: 'entryTime', width:"15%",render:function(row){
	        		var str = new Date(parseInt(row.entryTime)).toLocaleString().replace(/\//g,'-');
	        		return str;
	        	}
	        },
	        { display: '试用时间', name: 'probationPeriod', width:"15%",render:function(row){
	        		var str = '';
	        		if(row.probationPeriod == 1){
	        			str = '一个月';
	        		}else if(row.probationPeriod == 2){
	        			str = '二个月';
	        		}
	        		else if(row.probationPeriod == 3){
	        			str = '三个月';
	        		}
	        		return str;
	        	}
	        },
	        { display: '是否转正', name: 'formal', width:"10%",render:function(row){
	        		var str = '';
	        		if(row.formal == 0){
	        			str = '否';
	        		}else if(row.formal == 1){
	        			str = '是';
	        		}
	        		return str;
	        	}
	        },
	        { display: '是否在职', name: 'onJob', width:"10%"}
        ], pageSize:10,
        width: '100%',height:'99%'
	});
});

