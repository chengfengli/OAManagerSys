function data(){
	var id = $("#id").val();
	if(id==""){
		id = 0;
	}
	var groupCode = $("#groupCode").val();
	var groupName = $("#groupName").val();
	var data = {
			id:id,
			groupName:groupName,
			groupCode:groupCode,
	}
	return data;
}