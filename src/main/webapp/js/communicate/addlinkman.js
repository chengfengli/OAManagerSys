function data(){
	var id = $("#id").val();
	if(id == ''){
		id = 0;
	}
	return {
		id: id,
		name: $("#name").val(),
		groupId: $("#group").val(),
		address: $("#address").val(),
		mobile: $("#mobile").val(),
		telephone: $("#telephone").val(),
		qq: $("#qq").val(),
		email: $("#email").val(),
		other: $("#other").val()
	}
}
$(function(){
	$("#group").ligerComboBox({width:300});
});

