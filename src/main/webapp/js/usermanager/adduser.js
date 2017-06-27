var position = null;
/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text:'保存',icon:'save',click: function () {save()}});
	items.push({ line:true });
	items.push({text:'重置',icon:'reset',click: function () {}});
	items.push({ line:true });
	items.push({text:'返回',icon:'back',click: function () {back();}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}
/*保存*/
function save(){
	var params = {};
	params.name = $("#name").val();
	params.entryTime = $("#entryTime").val();
	params.depId = $("#department").val();
	if(position != null){
		params.positionId = position.getValue();
	}
	params.probationPeriod = $("#probationPeriod").val();
	$.ajax({
		url:path+"/user/edit",
		type:"post",
		dataType:"json",
		data:params,
		success:function(response){
			parent.$.ligerDialog.success(response.strMessage);
		},
		error:function(){
			parent.$.ligerDialog.error("系统错误!");
		}
	});
	
}
/*返回*/
function back(){
	history.go(-1);
}
$(function(){
	toolbar();
	$("#entryTime").ligerDateEditor({width:300 });
	$("#department,#probationPeriod,#position").ligerComboBox({width:300});
	/*选择部门后*/
	$("#department").change(function(){
		var depId = $(this).val();
		var option = '<option value="0" selected="selected">---请选择---</option>';
		if(depId == 0){
			$("#position").html(option);
		}else{
			position = $("#position").ligerComboBox({
				url:path+"/post/getpostbydepid",
				valueField : 'id',
				textField: 'positionName',
				parms:{depId:depId}
			});
		}
	});
});

