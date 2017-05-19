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
		$.ligerDialog.tip({  title: '提示',content:'登录成功！'});
	};
	websocket.onerror = function(event) {
		console.log("WebSocket:发生错误 ");
	};
	websocket.onclose = function(event) {
		console.log("WebSocket:已关闭");
	}
	
	$("#send").click(function(){
		var data={};
		data["from"]="1";
		data["fromName"]="张三";
		data["to"]="2";
		data["text"]="你好";
		websocket.send(JSON.stringify(data));
	});
});

