$(function(){
	$("#startTime").ligerDateEditor({ showTime: true,labelAlign: 'left',width:300 });
	$("#endTime").ligerDateEditor({ showTime: true,labelAlign: 'left',width:300 });
	$("#approve").ligerComboBox({width:300});
	/*选择附件*/
	$("#browse").click(function(){
		$("#file").click();
	});
	/*选择文件后*/
	$("#file").change(function(){
		var files = this.files;
		var li="";
		for(var i=0;i<files.length;i++){
			li+="<li>"+files[i].name+"</li>";
		}
		$("#file_count").text(files.length+" 个");
		$("#file_list").html(li);
	});
	/*添加收件人*/
	$(".group_send").click(function(){
		alert(JSON.stringify($(".group_send")));
	});
	
	/*提交*/
	$("#submit").click(function(){
		
	});
});

