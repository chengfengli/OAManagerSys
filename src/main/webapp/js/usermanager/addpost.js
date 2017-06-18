var role={};
function data(){
	var data = role;
	data.positionCode = $("#positionCode").val();
	data.positionName = $("#positionName").val();
	data.depId = $("#dep").val();
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
			buttons : [
				{
					text : '确定',
					onclick : function(item, dialog) {
						role = dialog.frame.data();
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

