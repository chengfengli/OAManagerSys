var grid;
/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text: "详情",icon:'view',click: function () {details(path+"/apply/page/details")}});
	items.push({ line:true });
	items.push({text: "同意",icon:'ok',click: function () {ok();}});
	items.push({ line:true });
	items.push({text: "拒绝",icon:'delete1',click: function () {delete1();}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}
/*同意*/
function ok(){
	var rows = grid.getCheckedRows();
	if (rows && rows.length > 0){
		for(var i in rows){
			if(rows[i].status=="a" || rows[i].status=="d"){
				parent.$.ligerDialog.warn("包含了已审申请");
				return;
			}
		}
		parent.$.ligerDialog.prompt('审核意见',true, function (yes,value) {
			if(yes){
				var ids = '';
				$(rows).each(function() {
					if(ids == ''){
						ids+= ''+this.id;
					}else{
						ids+= ','+this.id;
					}
				});
				$.ajax({
					url:path+"/notice/appro_agree",
					type:"POST",
					dataType:"json",
					data:{ids:ids,opinion:value},
					success:function(result){
						if(result.isSuccess){
							grid.loadData();
						}else{
							parent.$.ligerDialog.warn(result.strMessage);
						}
					}
				});
			}
		});
	}else{
		parent.$.ligerDialog.warn("请选择要审核的申请");
	}
}
/*拒绝*/
function delete1(){
	var rows = grid.getCheckedRows();
	if (rows && rows.length > 0){
		for(var i in rows){
			if(rows[i].status=="a" || rows[i].status=="d"){
				parent.$.ligerDialog.warn("包含了已审申请");
				return;
			}
		}
		parent.$.ligerDialog.prompt('拒绝理由',true, function (yes,value) {
			if(yes){
				var ids = '';
				$(rows).each(function() {
					if(ids == ''){
						ids+= ''+this.id;
					}else{
						ids+= ','+this.id;
					}
				});
				$.ajax({
					url:path+"/notice/appro_disagree",
					type:"POST",
					dataType:"json",
					data:{ids:ids,opinion:value},
					success:function(result){
						if(result.isSuccess){
							grid.loadData();
						}else{
							parent.$.ligerDialog.warn(result.strMessage);
						}
					}
				});
			}
		});
	}else{
		parent.$.ligerDialog.warn("请选择要审核的申请");
	}
}
$(function(){
	/*工具栏方法*/
	toolbar();
	/*初始化邮件列表*/
	var array = [];
	for(var i=1;i<=100;i++){
		array.push({id:i,applyName:"张三"+i,reason:'阿达啊饿啊啊',startTime:'2017-05-01',endTime:"2017-05-02",status:"待审"});
	}
	var data={Rows:array};
	grid = $("#list").ligerGrid({
		checkbox: true,
		selectRowButtonOnly:true,
        columns: [
	        { display: 'id', name: 'id',hide : true},
	        { display: '申请人', name: 'create.name', width: "5%"},
	        { display: '类型', name: 'applyType.typeName', width: "5%"},
	        { display: '事由', name: 'reason', width: "39%" },
	        { display: '开始时间', name: 'startTime', width:"15%"},
	        { display: '结束时间', name: 'endTime', width:"15%"},
	        { display: '状态', width:"5%",render:function(row){
	        	if(row.status=="w"){
	        		return "<span style='color:orange;'>待审</span>";
	        	}else if(row.status=="a"){
	        		return "<span style='color:green;'>同意</span>";
	        	}else if(row.status=="d"){
	        		return "<span style='color:red;'>拒绝</span>";
	        	}
	        }},
	        { display: '审核意见', name: 'opinion', width:"15%"}
        ], pageSize:10,
        url:path+"/notice/careful_list",
        width: '100%',height:'99%'
	});
});

