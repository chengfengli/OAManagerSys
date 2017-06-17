function depData(){
	var data = {};
	data.id = $("#id").val();
	data.depCode = $("#depCode").val();
	data.depName = $("#depName").val();
	data.describe = $("#describe").val();
	return data;
}

$(function(){
	$("#entryTime").ligerDateEditor({width:300 });
	$("#department,#onTrialTime").ligerComboBox({width:300});
});

