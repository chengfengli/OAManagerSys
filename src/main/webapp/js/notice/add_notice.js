var E = window.wangEditor;
var editor = new E('content');
var dep = null;
/*工具栏*/
function toolbar() {
	var items = [];
	items.push({text: "发布",icon:'up',click: function () {send()}});
	items.push({ line:true });
	items.push({text: "重置",icon:'reset',click: function () {}});
	$("#toolbar").ligerToolBar({
		items: items
	});
}
function send(){
	var title = $("#title").val();
	var format = $("#format").val();
	var type = $("#type").val();
	var content = editor.$txt.html();
	var text = editor.$txt.formatText();
	if(text == "" || text.trim() == ""){
		parent.$.ligerDialog.warn('填写内容!');
		return;
	}
	var data={
			title:title,
			format:format,
			typeId:type,
			content:content
	}
	if(dep != null){
		data.depId = dep.getValue();
	}
	var wait = parent.$.ligerDialog.waitting('发布中,请稍候...');
	var files = $("#file_list li");
	if(files.length > 0){
		$.upload(path+"/file/upload",function(result){
			data.fileId = result.strMessage;
			$.ajax({
				url:path+"/notice/add_notice",
				type:"post",
				dataType:"json",
				data:data,
				success:function(response){
					wait.close();
					if(response.isSuccess){
						parent.$.ligerDialog.success(response.strMessage);
						send_websocket(response.acceptNo,response.tips);
					}else{
						parent.$.ligerDialog.warn(response.strMessage);
					}
				},
				error:function(response){
					wait.close();
					parent.$.ligerDialog.error("系统错误!");
				}
			});
		})
	}else{
		$.ajax({
			url:path+"/notice/add_notice",
			type:"post",
			dataType:"json",
			data:data,
			success:function(response){
				wait.close();
				if(response.isSuccess){
					parent.$.ligerDialog.success(response.strMessage);
					send_websocket(response.acceptNo,response.tips);
				}else{
					parent.$.ligerDialog.warn(response.strMessage);
				}
			},
			error:function(response){
				wait.close();
				parent.$.ligerDialog.error("系统错误!");
			}
		});
	}
}
$(function(){
	$("#picker").click(function(){
		$("#file").click();
	});
	$("#file").fileListener(function(file){
		$("#file_list").append('<li class="item">'+file.name+'&nbsp;&nbsp;<a class="remove" href="javascript:void(0)" data-id="'+file.id+'">移除</a></li>');
		$(".remove").on("click",function(){
			var id = $(this).data("id");
			$.fileRemove(id);
			$(this).parent().remove();
		})
	});
	$("#format,#type").ligerComboBox({width:300});
	toolbar();
	/*初始化富文本编辑器*/
	editor.create();
	$("#type").change(function(){
		var value = $(this).val();
		if(value == "5"){
			$("#dep_tr").removeClass("none");
			dep = $("#dep").ligerComboBox({
				url:path+"/department/deplist2",
				valueField : 'id',
				textField: 'depName',
				isMultiSelect:true,
				isShowCheckBox:true,
				width:300
			});
		}else{
			$("#dep_tr").addClass("none");
			dep = null;
		}
	});
});

