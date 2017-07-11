/*列表方法*/
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
function details(){
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

