var position = null;
/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text:'保存',icon:'save',click: function () {save()}});
	items.push({ line:true });
	items.push({text:'重置',icon:'reset',click: function () {reset()}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}
/*保存*/
function save(){
	var params = {};
	if($("#id").val() != ""){
		params.id = $("#id").val();
	}
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

function reset(){
	$("input").val('');
	$("select").val("0");
	$("#position").ligerComboBox({
		url:path+"/post/getpostbydepid",
		valueField : 'id',
		textField: 'positionName',
		isMultiSelect:true,
		isShowCheckBox:true,
		width:300,
		parms:{depId:0}
	});
}
$(function(){
	toolbar();
	$("#entryTime").ligerDateEditor({width:300 });
	$("#department,#probationPeriod").ligerComboBox({width:300});
	$("#position").ligerComboBox({
		url:path+"/post/getpostbydepid",
		valueField : 'id',
		textField: 'positionName',
		isMultiSelect:true,
		isShowCheckBox:true,
		width:300,
		parms:{depId:0}
	});
	/*选择部门后*/
	$("#department").change(function(){
		var depId = $(this).val();
		position = $("#position").ligerComboBox({
			url:path+"/post/getpostbydepid",
			valueField : 'id',
			textField: 'positionName',
			isMultiSelect:true,
			isShowCheckBox:true,
			width:300,
			parms:{depId:depId}
		});
	});
	/*修改时，加载默认的职位*/
	if($("#department").val() != 0){
		var selectId = $("#positionId").val();
		position = $("#position").ligerComboBox({
			url:path+"/post/getpostbydepid",
			width:300,
			valueField : 'id',
			textField: 'positionName',
			isMultiSelect:true,
			isShowCheckBox:true,
			valueFieldID: 'positionId',
			parms:{depId:$("#department").val()}
		});
		position.setValue(selectId);
	}
});

