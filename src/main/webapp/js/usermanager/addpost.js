﻿function data(){
	var data = role;
	data.positionCode = $("#positionCode").val();
	data.positionName = $("#positionName").val();
	data.depId = $("#dep").val();
	if($("#id").val() == ""){
		data.id = 0;
	}else{
		data.id = $("#id").val();
	}
	return data;
}
$(function(){
	$("#dep").ligerComboBox({width:300});
	$("#set").click(function(){
		parent.$.ligerDialog.open({
			title : '配置访问权限',
			width : 800,
			height :600,
			allowClose : false,
			url : path+"/post/setrows",
			urlParms:{id:positionId},
			buttons : [
				{
					text : '确定',
					onclick : function(item, dialog) {
						role.parentMenu = dialog.frame.data().parentMenu;
						role.childMenu = dialog.frame.data().childMenu;
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
	});
});

