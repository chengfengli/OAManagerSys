var grid;
/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text:'编辑',icon:'edit',click: function () {edit(path+"/user/adduser?type=edit");}});
	items.push({ line:true });
	items.push({text:'基本信息',icon:'information_personal',click: function () {viewInfor();}});
	items.push({ line:true });
	items.push({text:'离职',icon:'delete',click: function () {leaveOffice();}});
	items.push({ line:true });
	items.push({text:'删除',icon:'delete1',click: function () {del(path+"/user/deleteEmp");}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}
/*设置权限*/
function setting(){
	$.ligerDialog.open({
		title : '添加菜单',
		width : 300,
		height :300,
		allowClose : false,
		url : path+"/user/setpermission",
		buttons : [
			{
				text : '保存',
				onclick : function(item, dialog) {
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
}

/*基本信息*/
function viewInfor(){
	var rows = grid.getCheckedRows();
	if (rows && rows.length > 0) {
		var ids = [];
		$(rows).each(function() {
			ids.push(this.id);
		});
		location.href = path+"/infor/editinfomation?empNo="+ids[0];
	}else{
		parent.$.ligerDialog.warn("选择要操作的数据!");
	}
}
/*离职*/
function leaveOffice(){
	var rows = grid.getCheckedRows();
	if (rows && rows.length > 0) {
		var ids = "";
		$(rows).each(function() {
			if(ids == ''){
				ids+= ''+this.id;
			}else{
				ids+= ','+this.id;
			}
		});
		$.ajax({
			url:path+"/user/leaveOffice",
			type:"post",
			dataType:"json",
			data:{idStr:ids},
			success:function(response){
				parent.$.ligerDialog.success(response.strMessage);
				grid.loadData();
			},
			error:function(){
				parent.$.ligerDialog.error("系统错误!");
			}
		});
	}else{
		parent.$.ligerDialog.warn("选择要操作的数据!");
	}
}

$(function(){
	$("#entryTime").ligerDateEditor();
	/*工具栏方法*/
	toolbar();
	grid = $("#list").ligerGrid({
		url:path+"/user/getallemp",
		checkbox: true,
		selectRowButtonOnly:true,
        columns: [
	        { display: '工号', name: 'id', width: "10%" },
	        { display: '姓名', name: 'name', width:"10%" },
	        { display: '部门', name: 'dep.depName', width:"10%"},
	        { display: '职位', name: 'position.positionName', width:"10%",render:function(row){
	        	var list = row.position;
	        	var positionName = "";
	        	for(var i in list){
	        		if(list[i].positionName != null && list[i].positionName != ''){
	        			positionName += list[i].positionName + ";";
	        		}
	        	}
	        	return positionName;
	        }},
	        { display: '入职时间', name: 'entryTime', width:"15%"},
	        { display: '试用期', name: 'probationPeriod', width:"15%",render:function(row){
	        		return row.probationPeriod+"个月";
	        	}
	        },
	        { display: '是否转正', name: 'formal', width:"10%",render:function(row){
	        		var str = '';
	        		if(row.formal == 0){
	        			str = '否';
	        		}else if(row.formal == 1){
	        			str = '是';
	        		}
	        		return str;
	        	}
	        },
	        { display: '是否在职', name: 'onJob', width:"10%",render:function(row){
	        		var str = '';
	        		if(row.onJob == 0){
	        			str = '否';
	        		}else if(row.onJob == 1){
	        			str = '是';
	        		}
	        		return str;
	        	}
	        }
        ], pageSize:10,
        width: '100%',height:'99%'
	});
	
	$("#select").click(function(){
		var name = $("#name").val();
		var entryTime = $("#entryTime").val();
		var probationPeriod = $("#probationPeriod").val();
		grid.setOptions({  
            parms : {  
            	name : name,  
            	entryTime : entryTime,
            	probationPeriod: probationPeriod
            } 
		});  
		grid.loadData(true); 
	});
	$(document).keypress(function(e) {
		if (e.keyCode == 13) {
			$("#select").click();
		}
	})
});

