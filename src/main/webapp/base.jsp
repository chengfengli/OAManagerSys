<% 
	String context = request.getContextPath(); 
	String basePath = request.getServerName() + ":" + request.getServerPort() + context + "/";
%>
<script>
	var url = '<%=basePath%>';
	var path = '<%=context %>';
</script>
<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/Aqua/css/ligerui-all.css" />
<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/ligerui-icons.css" />
<link rel="stylesheet" type="text/css" href="<%=context %>/wangEditor/dist/css/wangEditor.min.css">
<link rel="stylesheet" type="text/css" href="<%=context %>/webuploader/webuploader.css">
<script src="<%=context %>/js/jquery-1.9.0.min.js"></script>
<script src="<%=context %>/Source/lib/ligerUI/js/ligerui.all.js"></script>
<script src="<%=context %>/webuploader/webuploader.js"></script>
<script src="<%=context %>/wangEditor/dist/js/wangEditor.js"></script>
<script src="<%=context %>/js/websocket.js"></script>
