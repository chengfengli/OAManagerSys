var tree;
var constans = 0;

function data(){
	var data={parentMenu:"",childMenu:""};
	data.parentMenu=JSON.stringify(existParentMenu);
	data.childMenu=JSON.stringify(existChildMenu);
	return data;
}

function f_selectNode(parmas){
	var para = function(data){
		for(var i in data){
			for(var j in parmas){
				if(data.id == parmas[j].id){
					return true;
				}
				if(parmas[j].children){
    				f_selectNode(parmas[j].children);
    			}
			}
		}
	}
	tree.selectNode(para);
}

//取消勾选，移除,key:主菜单id，canacelMenus：当前主菜单下的所有子菜单，canacelNodeId：要取消的节点id
function removeMenu(key,canacelMenus,canacelNodeId){
	for(var i in canacelMenus){
		if(canacelMenus[i].id==canacelNodeId){
			canacelMenus.splice(i,1);
		}else if(canacelMenus[i].children){
			removeMenu(key,canacelMenus[i].children,canacelNodeId)
		}
	}
	existChildMenu[key] = canacelMenus;
	console.log(existChildMenu);
}

function addChildMenu(currentCheckedNode,parentId,currentNodeId){
	for(var i in existChildMenu[currentNodeId]){
		if(existChildMenu[currentNodeId][i].id == parentId){
			var isExtis = false;
			for(var j in existChildMenu[currentNodeId][i].children){
				if(existChildMenu[currentNodeId][i].children[j].id == currentCheckedNode.id){
					isExtis = true;
				}
			}
			if(!isExtis){
				existChildMenu[currentNodeId][i].children.push(currentCheckedNode);
			}
		}
	}
}

$(function(){
	for(var i in parentMenu){
		if(existParentMenu.length>0){
			var isExtis = false;
			for(var j=0;j<existParentMenu.length;j++){
				if(existParentMenu[j].id==parentMenu[i].id){
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
		constans = 0;
		var id=$(this).data("id");
		var text=$(this).text();
		$("#key").val(id);
		$("#text").val(text);
		tree = $("#childMenuTree").ligerTree({
			data:childMenu[id],
			onCheck:function(node,checked){
				//勾选的节点
				var currentCheckedNode = node.data;
				//勾选的节点的父节点
				var parentNode = tree.getParentTreeItem(node.target);
				//勾选的节点的主菜单id
				var currentNodeId = $("#key").val();
				if(checked && constans == 0){
					if(parentNode!=null){//如果有父节点
						//勾选的节点的父节点id
						var parentId = parentNode.id;
						addChildMenu(currentCheckedNode,parentId,currentNodeId)
					}else{//最顶级的子菜单
						var isExtis = false;
						for(var i in existParentMenu){
							//已有主菜单中存在勾选的菜单
							if(existParentMenu[i].id==currentNodeId){
								isExtis = true;
								break;
							}
						}
						if(isExtis){
							isExtis = false;
							for(var i in existChildMenu[currentNodeId]){
								if(currentCheckedNode.id == existChildMenu[currentNodeId][i].id){
									isExtis = true;
									break;
								}
							}
							if(!isExtis){
								existChildMenu[currentNodeId].push(currentCheckedNode);
							}
						}else{
							parent.$.ligerDialog.warn("选择一个主菜单!");
							constans+=1;
						}
					}
				}else if(!checked){//取消勾选
					var canacelMenus = existChildMenu[currentNodeId];
					var canacelNodeId = node.target.id;
					removeMenu(currentNodeId,canacelMenus,canacelNodeId)
				}
			}
		});
		f_selectNode(existChildMenu[id])
	});
	
	//勾选主菜单
	$("input[type=checkbox]").change(function(){
		constans = 0;
		var isChick=$(this).prop("checked");
		var id=$(this).next().data("id");
		var text=$(this).next().text();
		$("#key").val(id);
		$("#text").val(text);
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
					existChildMenu[id]=[];
				}
			}else{
				existParentMenu.push(json);
				existChildMenu[id]=[];
			}
		}else{//取消菜单
			for(var i in existParentMenu){
				//如果已选择的主菜单中存在要取消的菜单，则删除该主菜单
				if(existParentMenu[i].id==id){
					existParentMenu.splice(i,1);
				}
			}
			delete existChildMenu[id];
		}
		$(this).next().click();
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
