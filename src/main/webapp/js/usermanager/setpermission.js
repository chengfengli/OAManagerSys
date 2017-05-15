var html ="";
function get(obj){
	for(var i=0;i<obj.length;i++){
		
		if(obj[i].children){
			get(obj[i]);
		}else{
			html+='<input type="checkbox" data-id="" class="liger-checkbox" />'+obj[i].text+'<br>';
		}
	}
}
$(function(){
	$(".hide").hide();
	for(var key in childMenu){
		html ="";
		for(var i=0;i<childMenu[key].length;i++){
			if(childMenu[key][i].children){
				get(childMenu[key][i].children);
				
			}else{
				html+='<input type="checkbox" data-id="" class="liger-checkbox" />'+childMenu[key][i].text+'<br>';
			}
			
		}
		$("#"+key+" .checklist").html(html)
	}
	
});

