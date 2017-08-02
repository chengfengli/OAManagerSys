function data(){
	return {
		typeCode:$("#typeCode").val(),
		startTime:$("#startTime").val(),
		endTime:$("#endTime").val(),
		approver:$("#approver").val(),
		reason:$("#reason").val(),
		typeCode:$("#typeCode").val(),
		longHours:$("#longHours").text(),
		address:$("#address").val()
	}
}
function setlongHours(){
	var s_time = $("#startTime").val();
	var e_time = $("#endTime").val();
	if(s_time != "" && e_time != ""){
		$("#longHours").text(dateCount(s_time,e_time));
	}
}
$(function(){
	$("#startTime").ligerDateEditor({ showTime: true,labelAlign: 'left',width:300,onChangeDate:function(value){
		setlongHours();
	}});
	$("#endTime").ligerDateEditor({ showTime: true,labelAlign: 'left',width:300 ,onChangeDate:function(value){
		setlongHours();
	}});
	$("#approver,#typeCode").ligerComboBox({width:300});
	$("#typeCode").change(function(){
		var value = $(this).val()
		if(value=='evection'){
			$("#address_tr").removeClass("none");
			$("#address").val('');
		}else{
			$("#address_tr").addClass("none");
			$("#address").val('————');
		}
	});
});

