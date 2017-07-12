﻿/*列表方法*/
//编辑
function edit(url){
	var rows = grid.getCheckedRows();
	if (rows && rows.length == 1) {
		var ids = [];
		$(rows).each(function() {
			ids.push(this.id);
		});
		location.href = url+"&id="+ids[0];
	}else{
		parent.$.ligerDialog.warn("选择一封邮件");
	}
}
/*详情*/
function details(url){
	var rows = grid.getCheckedRows();
	if (rows && rows.length == 1) {
		var ids = [];
		$(rows).each(function() {
			ids.push(this.id);
		});
		location.href = url+"?id="+ids[0];
	}else{
		parent.$.ligerDialog.warn("选择一封邮件");
	}
}
/*删除*/
function del(url){
	var rows = grid.getCheckedRows();
	if (rows && rows.length > 0) {
		var ids = '';
		$(rows).each(function() {
			if(ids == ''){
				ids+= ''+this.id;
			}else{
				ids+= ','+this.id;
			}
		});
		parent.$.ligerDialog.confirm('确定删除数据？', function (yes) {
			if(yes){
				$.ajax({
					url:url,
					type:"post",
					dataType:"json",
					data:{ids:ids},
					success:function(response){
						if(response.isSuccess){
							grid.loadData();
						}
					},
					error:function(){
						parent.$.ligerDialog.error("系统错误!");
					}
				});
			}
		});
		
	}else{
		parent.$.ligerDialog.warn("选择要操作的数据!");
	}
}
//搜索回车键
$(document).keypress(function(e) {
	if (e.keyCode == 13) {
		$("#select").click();
	}
})

/*查看附件*/
function files(fileId){
	parent.$.ligerDialog.open({
		title : '附件',
		width : 590,
		allowClose : false,
		url : path+"/file/page/list?fileId="+fileId,
		buttons : [
		    {
				text : '关闭',
				onclick : function(item, dialog) {
					dialog.close();
				}
			}
		]
	});
}

//附件下载
function download(id){
	location.href = path+"/file/download?id="+id;
}
