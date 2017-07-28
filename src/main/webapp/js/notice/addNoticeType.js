function typeData(){
	var data = {};
	var id = $("#id").val();
	if(id == ""){
		id=0;
	}
	data.id = id;
	data.typeCode = $("#typeCode").val();
	data.typeName = $("#typeName").val();
	data.describe = $("#describe").val();
	return data;
}

