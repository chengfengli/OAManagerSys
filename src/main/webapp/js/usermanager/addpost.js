var data;
$(function(){
	$("#department").ligerComboBox({width:300});
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
						data = dialog.frame.data();
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

