function _import(){
	var s=$.upload(path+"/kaoqin/import",function(result){
		return result;
	});
}
$(function(){
	$("#file").fileListener(function(file){
		$("#file_list").html('<p class="item">'+file.name+'</p>');
	});
	$("#select").click(function(){
		$("#file").click();
	});
});