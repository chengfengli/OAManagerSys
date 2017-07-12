var formData = null;
var fileArray = [];
(function($){
	$.fn.fileListener=function(fun){
		var selector = this.selector.substring(1);
		var input = document.getElementById(selector);
		formData=new FormData();
		// 文件域选择文件时, 执行readFile函数
		input.addEventListener('change', readFile, false);
		function readFile() {
			var file = this.files;
			for(var i=0;i<file.length;i++){
				var time = Math.floor(Math.random()*new Date().getTime()*100000);
					file[i].id=time;
					if(typeof fun == 'function'){
						fun(file[i]);
					}
					fileArray.push(file[i]);
			}
		}
	}
	//移除文件
	$.fileRemove=function(id){
		for(var i in fileArray){
			if(fileArray[i].id == id){
				fileArray.splice(i,1);
			}
		}
	}
	//上传方法
	$.upload = function(url,fun){
		for(var i in fileArray){
			formData.append("file",fileArray[i]);
		}
		$.ajax({
			url: url ,
			type: 'post',
			dataType:"json",
			data: formData,
			processData: false,  // 告诉jQuery不要去处理发送的数据
			contentType: false,  // 告诉jQuery不要去设置Content-Type请求头
			cache:false,
			async:false,
			success: function (result) {
				if(typeof fun == 'function'){
					fun(result);
				}
			},
			error: function (result) {  
				$.ligerDialog.warn('上传：系统错误');
			}
		});
	}
})(jQuery)
