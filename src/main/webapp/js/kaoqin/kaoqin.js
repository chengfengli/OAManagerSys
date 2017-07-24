var grid;
/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text: "签到",icon:'in',click: function () {signin("/kaoqin/signIn");}});
	items.push({ line:true });
	items.push({text: "签退",icon:'out',click: function () {signin("/kaoqin/signOut");}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}

/*签到签退*/
function signin(url){
	$.ajax({
		url:path+url,
		type:"post",
		dataType:"json",
		success:function(result){
			if(result.isSuccess){
				parent.$.ligerDialog.success(result.strMessage);
				grid.loadData();
			}else{
				parent.$.ligerDialog.success(result.strMessage);
			}
		}
	});
}
$(function(){
	$("#month").ligerDateEditor({
		format: "yyyy-MM",
		labelAlign: 'center',
	});
	/*工具栏方法*/
	toolbar();
	grid = $("#list").ligerGrid({
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '日期', name: 'day', width: "9%" },
	        { display: '星期', name: 'weekDay', width: "6%" },
	        { display: '上班时间', name: 'signInTime', width:"9%", },
	        { display: '下班时间', name: 'signOutTime', width:"9%", },
	        { display: '标准工时', name: 'standardWorkTime', width:"6%", },
	        { display: '实际工时', name: 'actualWorkTime', width:"6%", },
	        { display: '加班工时', name: 'overTimeLong', width:"6%", },
	        { display: '迟到时数', name: 'lateTimeLong', width:"6%", },
	        { display: '早退时数', name: 'leaveEarlyTimeLong', width:"6%", },
	        { display: '打卡记录', name: 'status', width:"9%",render:function(row){
	        	if(row.status=="N"){
	        		return "<span style='color:green;'>正常</span>";
	        	}else if(row.status=="C"){
	        		return "<span style='color:red;'>迟到</span>";
	        	}else if(row.status=="Z"){
	        		return "<span style='color:red;'>早退</span>";
	        	}else if(row.status=="K"){
	        		return "<span style='color:red;'>旷工</span>";
	        	}else if(row.status=="CZ"){
	        		return "<span style='color:red;'>迟到·早退</span>";
	        	}else if(row.status=="L"){
	        		return "<span style='color:orange;'>请假</span>";
	        	}
	        }},
	        { display: '描述', name: 'describe', width:"27%", }
        ],
        pageSize:31,
        pageSizeOptions:[10,15,31],
        url:path+"/kaoqin/list",
        width: '100%',height:'99%'
	});
	$("#select").click(function(){
		var yearMonth = $("#month").val();
		grid.setOptions({  
            parms : {  
            	yearMonth : yearMonth
            } 
		});  
		grid.loadData(true);
	});
});

