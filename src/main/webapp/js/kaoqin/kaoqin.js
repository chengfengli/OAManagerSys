/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text: "签到",icon:'in',click: function () {signin();}});
	items.push({ line:true });
	items.push({text: "签退",icon:'out',click: function () {signout();}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}

/*签到*/
function signin(){
	parent.$.ligerDialog.warn('签到!');
}
/*签退*/
function signout(){
	parent.$.ligerDialog.warn('签退!');
}
$(function(){
	/*工具栏方法*/
	toolbar();
	/*模拟数据*/
	var array = [];
	for(var i=1;i<=31;i++){
		array.push({
			id:i,
			date:"2017-01-"+i,
			week:"六",
			officetime:"08:55",
			closingtime:"18:10",
			normalhours:8,
			actualhours:8,
			overtimehours:0,
			belatehours:0,
			leaveearlyhours:0,
			clockin:"正常",
			absenteeism:""
			
		});
	}
	var data={Rows:array};
	$("#list").ligerGrid({
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '日期', name: 'date', width: "9%" },
	        { display: '星期', name: 'week', width: "6%" },
	        { display: '上班时间', name: 'officetime', width:"9%", },
	        { display: '下班时间', name: 'closingtime', width:"9%", },
	        { display: '标准工时', name: 'normalhours', width:"6%", },
	        { display: '实际工时', name: 'actualhours', width:"6%", },
	        { display: '加班工时', name: 'overtimehours', width:"6%", },
	        { display: '迟到时数', name: 'belatehours', width:"6%", },
	        { display: '早退时数', name: 'leaveearlyhours', width:"6%", },
	        { display: '打卡记录', name: 'clockin', width:"9%", },
	        { display: '缺勤描述', name: 'absenteeism', width:"27%", }
        ], pageSize:31,
        data:data,
        width: '100%',height:'99%'
	});
});

