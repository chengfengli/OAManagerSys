var formData = null;
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
					if(typeof fun == 'function'){
						fun(file[i]);
					}
					formData.append("file",file[i]);
			}
		}
	}
	//上传方法
	$.upload = function(url,fun){
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
