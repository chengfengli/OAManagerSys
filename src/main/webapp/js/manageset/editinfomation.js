/*工具栏*/
function toolbar(view) {
	var items = [];
	if(view){
		items.push({text:'保存',icon:'save',click: function () {save();}});
		items.push({ line:true });
		items.push({text:'重置',icon:'reset',click: function () {reset();}});
	}
	items.push({ line:true });
	items.push({text:'返回',icon:'reset',click: function () {goBack();}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}
/*保存*/
function save(){
	var array = $("#baseInfor").serializeArray();
	var data = {};
	for(var i in array){
		var key = array[i].name;
		var value = array[i].value;
		if(key.indexOf("_")==-1){
			data[key] = value;
		}
	}
	if(data.id == ""){
		data.id = 0;
	}
	if(data.empNo == ""){
		data.empNo = 0;
	}
	if(data.age == ""){
		data.age = 20;
	}
	$.ajax({
		url:path+"/infor/editInfor",
		type:"post",
		dataType:"json",
		data:data,
		success:function(response){
			if(response.isSuccess){
				parent.$.ligerDialog.success(response.strMessage);
			}else{
				parent.$.ligerDialog.warn(response.strMessage);
			}
		},
		error:function(){
			parent.$.ligerDialog.error("系统错误");
		}
	});
}

/*重置*/
function reset(){
	
}

function goBack(){
	history.go(-1);
}
$(function(){
	toolbar(view);
	$("#birthday").ligerDateEditor({width:200});
	$("#politics,#sex,#children").ligerComboBox({width:200});
});

