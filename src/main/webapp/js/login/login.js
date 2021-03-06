/*提示*/
$.fn.tip = function(text) {
	if (!text) {
		text = "";
	}
	var input_width = this.width();
	var left = this.offset().left + 10;
	var top = this.offset().top + 26;
	$("body").append(
					'<div class="tips" style="background: #A7D1F7;position: absolute;left:'
							+ left
							+ 'px;top:'
							+ top
							+ 'px">'
							+ '<div style="border-right:6px solid transparent;border-top:0 solid transparent;border-left:6px solid transparent;border-bottom:10px solid #A7D1F7;position: absolute;top:-10px;left:13px;"></div>'
							+ '<div style="padding:3px 5px;font-size: 12px;min-width:14px;min-height: 16px;">'
							+ text + '</div>' + '</div>');
	this.click(function() {
		$(".tips").remove();
	});
}

/* 非空验证 */
function check() {
	$(".tips").remove();
	var id = $("#id").val();
	var password = $("#password").val();
	var code = $("#code").val();
	if (id == "") {
		$("#id").tip("用户名不能为空!");
		$("#id").focus();
		return false;
	}
	if (password == "") {
		$("#password").tip("密码不能为空!");
		$("#password").focus();
		return false;
	}
	if (code == "") {
		$("#code").tip("请输入验证码!");
		$("#code").focus();
		return false;
	}
	return true;
}

$(function() {
	$("#canvas").canvas1();
	/* 显示其他账号 */
	$("#downmenu_ico").click(function() {
		$("#account-list").toggle();
	});

	/* 双击显示其他账号 */
	$("#id").dblclick(function() {
		$("#downmenu_ico").click();
	});

	/* 回车键登录 */
	$(document).keypress(function(e) {
		if (e.keyCode == 13) {
			$("#loginbtn").click();
		}
	})

	/* 登录 */
	$("#loginbtn").click(function() {
		var id = $("#id").val();
		var password = $("#password").val();
		var code = $("#code").val();
		var remember = 0;
		if ($("#remember").is(":checked")) {
			remember = 1;
		}
		if (check()) {
			var manager = $.ligerDialog.waitting('登录中,请稍候...');
			$.ajax({
				url : path + "/user/login",
				type : "post",
				dataType : "json",
				data : {
					id : id,
					password : password,
					code : code,
					rememberPassword : remember
				},
				success : function(result) {
					manager.close();
					if (result.isSuccess) {
						location.href = path + "/index/toindex?positionCode="+result.strMessage;
					} else {
						if(result.errorType == "passwordError") {
							$("#id").tip(result.strMessage);
						}else if(result.errorType == "pwdError"){
							$("#password").tip(result.strMessage);
						} else if(result.errorType == "codeError"){
							$("#code").tip(result.strMessage);
							$("#code_content").click();
						}
						
					}
				},
				error : function(result) {
					manager.close();
					parent.$.ligerDialog.success("系统错误!");
				}
			})
		}
	});
	
	$("#code_content").click(function(){
		$.ajax({
			url:path + "/user/recode",
			type:"post",
			dataType:"json",
			success:function(result){
				$("#code_content").css("background","url("+path+"/icon/"+result.strMessage+")");
			}
		})
	});
	
	/*自动加载在本机上登录过的并记住密码的账号*/
//	$.ajax({
//		url:path + "/user/loadAccount",
//		type:"post",
//		dataType:"json",
//		success:function(result){
//			$("#password").attr("type","password");
//			if(result.length>0){
//				$("#account").val(result[0].userAcount);
//				$.ajax({
//					url:path + "/user/loadPwd",
//					type:"post",
//					dataType:"json",
//					data:{userAccount:result[0].userAcount},
//					success:function(result){
//						$("#password").val(result.strMessage);
//					}
//				})
//			}
//			for(var i = 0;i<result.length;i++){
//				$("#account-list").append("<li>"+result[i].userAcount+"</li>");
//			}
//			/* 切换其他账号 */
//			$("#account-list li").on("click",function() {
//				var other_account = $(this).text();
//				$("#account").val(other_account);
//				$("#account-list").toggle();
//				$.ajax({
//					url:path + "/user/loadPwd",
//					type:"post",
//					dataType:"json",
//					data:{userAccount:other_account},
//					success:function(result){
//						$("#password").val(result.strMessage);
//					}
//				})
//			});
//		}
//	});
});