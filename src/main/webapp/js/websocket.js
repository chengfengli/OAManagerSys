var websocket;
if ('WebSocket' in window) {
	websocket = new WebSocket("ws://" + url + "wshome");
} else if ('MozWebSocket' in window) {
	websocket = new MozWebSocket("ws://" + url + "wshome");
} else {
	websocket = new SockJS("http://" + url + "ws/sockjshome");
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
function send_websocket(to,text){
	var data={};
	data["from"]="1";
	data["fromName"]="张三";
	data["to"]=to;
	data["text"]=text;
	websocket.send(JSON.stringify(data));
}