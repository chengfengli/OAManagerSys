/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text: "详情",icon:'view',click: function () {details();}});
	items.push({ line:true });
	items.push({text: "删除",icon:'delete',click: function () {del();}});
	items.push({ line:true });
	items.push({text: "编辑",icon:'edit',click: function () {forward();}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}
$(function(){
	/*工具栏方法*/
	toolbar();
	/*模拟数据*/
	var array = [];
	for(var i=1;i<=100;i++){
		array.push({id:i,title:"张三"+i,format:'MHT格式',type:'aadfa',content:"短信内容"+i,issueTime:"2017-02-15 10:24"});
	}
	var data={Rows:array};
	$("#list").ligerGrid({
		checkbox: true,
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '标题', name: 'title', width: "10%" },
	        { display: '格式', name: 'format', width: "10%" },
	        { display: '类型', name: 'type', width:"10%", },
	        { display: '内容', name: 'content', width:"50%", },
	        { display: '发布日期', name: 'issueTime', width:"19%", }
        ], pageSize:10,
        data:data,
        width: '100%',height:'99%'
	});
});

