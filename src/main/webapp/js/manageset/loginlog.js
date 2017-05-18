$(function() {
	$("#list").ligerGrid({
		checkbox: true,
		usePager:false,
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '登录日期', name: 'loginDate', width:"30%" },
	        { display: 'IP', name: 'ip', width:"30%", },
	        { display: '地点', name: 'address', width: "30%" }
        ],
        width: '99%',height:'100%'
	});
});
