﻿//一级菜单
var menus = [];
//子菜单
var childMenus={};
var tree;
function data(){
	var data={parentMenu:"",childMenu:""};
	data.parentMenu=JSON.stringify(existParentMenu);
	data.childMenu=JSON.stringify(childMenus);
	return data;
}

$(function(){
	for(var i in parentMenu){
		if(existParentMenu.length>0){
			var jsonParentMenu = JSON.parse(existParentMenu);
			var isExtis = false;
			for(var j=0;j<jsonParentMenu.length;j++){
				if(jsonParentMenu[j].id==parentMenu[i].id){
					isExtis = true;
				}
			}
			if(isExtis){
				$("#menu").append('<input type="checkbox" checked id="'+parentMenu[i].id+'" class="liger-checkbox" /><span class="menutxt" data-id="'+parentMenu[i].id+'">'+parentMenu[i].text+'</span><br>');
			}else{
				$("#menu").append('<input type="checkbox" id="'+parentMenu[i].id+'" class="liger-checkbox" /><span class="menutxt" data-id="'+parentMenu[i].id+'">'+parentMenu[i].text+'</span><br>');
			}
		}else{
			$("#menu").append('<input type="checkbox" id="'+parentMenu[i].id+'" class="liger-checkbox" /><span class="menutxt" data-id="'+parentMenu[i].id+'">'+parentMenu[i].text+'</span><br>');
		}
	}
	
	$(".menutxt").click(function(){
		var id=$(this).data("id");
		var text=$(this).text();
		$("#key").val(id);
		$("#text").val(text);
		tree = $("#childMenuTree").ligerTree({
			data:childMenu[id],
			onCheck:function(node,checked){
				var parentNode = tree.getParentTreeItem(node.target);
				if(checked){
					if(parentNode!=null){//如果有父节点
						var parentId = parentNode.id
					}else{
						var isExtis = false;
						for(var i in existParentMenu){
							//存在
							if(existParentMenu[i].id==id){
								isExtis = true;
								break;
							}
						}
						if(isExtis){
							console.log(node.data)
						}else{
							parent.$.ligerDialog.warn("选择一个主菜单!");
						}
					}
				}
			}
		});
		tree.selectNode(d);
	});
	
	//勾选主菜单
	$("input[type=checkbox]").change(function(){
		$(this).next().click();
		var isChick=$(this).prop("checked");
		var id = $("#key").val();
		var text = $("#text").val();
		//勾选菜单
		if(isChick){
			var json = {};
			json.id=id;
			json.text=text;
			if(existParentMenu.length>0){
				var isExtis = false;
				//循环判断在已有的菜单中是否存在勾选的菜单，默认不存在
				for(var i in existParentMenu){
					//存在
					if(existParentMenu[i].id==id){
						isExtis = true;
						break;
					}
				}
				//如果不存在
				if(!isExtis){
					existParentMenu.push(json);
				}
			}else{
				existParentMenu.push(json);
			}
		}else{//取消菜单
			for(var i in existParentMenu){
				//存在
				if(existParentMenu[i].id==id){
					existParentMenu.splice(i,1);
				}
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
