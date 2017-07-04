$(function() {
	$("#portalMain").ligerPortal({
		columns : [{
			width : 500,
			panels : [ {
				title : '账号信息',
				width : '100%',
				height : 200,
				url :path + '/user/accountinfo',
			},
			{
				title : '登录日志',
				width : '100%',
				height : 212,
				url :path + '/user/loginlog',
			}]
		},
		{
			width : 500,
			panels : [ {
				title : '密码设置',
				width : '100%',
				height : 200,
				url :path + '/user/setpwd',
			} ]
		}]
	});
});
