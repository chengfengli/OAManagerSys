$(function(){
	var websocket;
	if ('WebSocket' in window) {
		websocket = new WebSocket("ws://" + basePath + "wshome?uid=1");
	} else if ('MozWebSocket' in window) {
		websocket = new MozWebSocket("ws://" + basePath + "wshome");
	} else {
		websocket = new SockJS("http://" + basePath + "ws/sockjshome");
	}
	websocket.onopen = function(event) {
		console.log("WebSocket:已连接");
	};
	//接收消息
	websocket.onmessage = function(event) {
		var data=JSON.parse(event.data);
		$.ligerDialog.close();
		$.ligerDialog.tip({  title: '提示',content:data.text});
	};
	websocket.onerror = function(event) {
		console.log("WebSocket:发生错误 ");
	};
	websocket.onclose = function(event) {
		console.log("WebSocket:已关闭");
	}
	
	$("#send").click(function(){
		var txt = $("#txt").val();
		var data={};
		data["from"]="1";
		data["fromName"]="张三";
		data["to"]=txt;
		data["text"]="你好,你有新的消息";
		websocket.send(JSON.stringify(data));
	});
});

