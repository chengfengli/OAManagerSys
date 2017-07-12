<META HTTP-EQUIV="pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate"> 
<META HTTP-EQUIV="expires" CONTENT="0">
<% 
	String context = request.getContextPath(); 
	String basePath = request.getServerName() + ":" + request.getServerPort() + context + "/";
%>
<script>
	var url = '<%=basePath%>';
	var path = '<%=context %>';
</script>
<link rel="stylesheet" type="text/css" href="<%=context %>/wangEditor/dist/css/wangEditor.min.css">
<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/ligerui-icons.css" />
<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/Aqua/css/ligerui-all.css" />
<script src="<%=context %>/js/jquery-1.9.0.min.js"></script>
<script src="<%=context %>/Source/lib/ligerUI/js/ligerui.all.js"></script>
<script src="<%=context %>/wangEditor/dist/js/wangEditor.js"></script>
<script src="<%=context %>/js/websocket.js"></script>
<script src="<%=context %>/js/upload.js"></script>
<script src="<%=context %>/js/commons/list_fun.js"></script>
