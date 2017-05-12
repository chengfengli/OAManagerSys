/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text:'添加',icon:'add',click: function () {add();}});
	items.push({text:'编辑',icon:'edit',click: function () {edit();}});
	items.push({text:'删除',icon:'delete',click: function () {del();}});
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
	parent.$.ligerDialog.open({
		title : '修改联系人',
		width : 450,
		height : 400,
		allowClose : false,
		url : path+'/linkman/addlinkman',
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
		array.push({id:i,name:"张三",group:"公司"+i,address:"四川成都锦江",mobile:"13511111111",telephone:"0818-11111111",qq:"123456789",email:"12345678@qq.com",other:"adafedfcv"});
	}
	var data={Rows:array};
	$("#list").ligerGrid({
		checkbox: true,
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '姓名', name: 'name', width: "5%" },
	        { display: '分组', name: 'group', width: "9%" },
	        { display: '住址', name: 'address', width:"35%" },
	        { display: '手机', name: 'mobile', width:"10%", },
	        { display: '电话', name: 'telephone', width:"10%", },
	        { display: 'QQ', name: 'qq', width:"10%", },
	        { display: '邮箱', name: 'email', width:"10%", },
	        { display: '其他', name: 'other', width:"10%", }
        ], pageSize:10,
        data:data,
        width: '100%',height:'99%'
	});
});

