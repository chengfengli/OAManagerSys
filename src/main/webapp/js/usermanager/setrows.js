//一级菜单
var menus = [];
//子菜单
var childMenus={};
function data(){
	var data={};
	data.parentMenu=JSON.stringify(menus);
	data.childMenu=JSON.stringify(childMenus);
	return data;
}
$(function(){
	$("input[type=checkbox]").change(function(){
		var isChick=$(this).prop("checked");
		var id=$(this).prop("id");
		var text=$(this).data("text");
		if(isChick){
			$("#key").val(id);
			$("#text").val(text);
			$("textarea").val(JSON.stringify(childMenu[id],null, 4));
		}else{
			if(id==$("#key").val()){
				$("textarea").val("");
			}
		}
	});
	/*添加*/
	$("#add").click(function(){
		var json = {};
		//主菜单id
		var id=$("#key").val();
		//主菜单文本
		var text=$("#text").val();
		var value=JSON.parse($("textarea").val());
		json.id=id;
		json.text=text;
		var exist = false;
		for(var i=0;i<menus.length;i++){
			if(menus[i].id==id){
				exist = true;
			}
		}
		if(!exist){
			menus.push(json);
			childMenus[id]=value;
		}else{
			childMenus[id]=value;
		}
	});
	/*验证json格式*/
	$("textarea").keyup(function(){
		try{
			JSON.parse($(this).val());
			$("#error").text('');
		}catch(err){
			$("#error").text('格式错误!');
		}
	});
});
