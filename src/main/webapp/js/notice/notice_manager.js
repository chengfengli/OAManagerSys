var grid;
/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text: "详情",icon:'view',click: function () {details(path+"/notice/details")}});
	items.push({ line:true });
	/*items.push({text: "编辑",icon:'edit',click: function () {}});
	items.push({ line:true });*/
	items.push({text: "查阅情况",icon:'chart',click: function () {}});
	items.push({ line:true });
	items.push({text: "删除",icon:'delete',click: function () {del(path+"/notice/delete")}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}

$(function(){
	/*工具栏方法*/
	toolbar();
	grid = $("#list").ligerGrid({
		checkbox: true,
		selectRowButtonOnly:true,
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '标题', name: 'title', width: "20%"},
	        { display: '格式', name: 'format', width: "10%",render:function(row){
	        	if(row.format == "common"){
	        		return "普通";
	        	}else{
	        		return "MHT";
	        	}
	        }},
	        { display: '类型', name: 'type.typeName', width:"10%"},
	        { display: '发布日期', name: 'createTime', width:"19%"},
	        { display: '附件', width:"19%",render:function(row){
	        	if(row.fileId != null && row.fileId != ''){
	        		return '<img class="fileId" onclick="files('+row.fileId+')" style="margin-top:6px;cursor:pointer;" src="/icon/paper.png" />';
	        	}
	        }}
        ], pageSize:10,
        url:path+"/notice/list_all",
        width: '100%',height:'99%'
	});
	
	/*搜索*/
	$("#select").click(function(){
		var format = $("#format").val();
		var type = $("#type").val();
		grid.setOptions({
            parms : {
            	format : format,  
            	typeId : type
            } 
		});  
		grid.loadData(true);
	});
});

