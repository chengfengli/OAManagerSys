$(function() {
    var strongRegex = new RegExp(/^(?!(?:[^a-zA-Z]|\D|[a-zA-Z0-9])$).{16,}$/);
    var mediumRegex = new RegExp(/^(?!(?:[^a-zA-Z]|\D|[a-zA-Z0-9])$).{10,}$/);
    $("#newPwd").blur(function(){
    	if ($(this).val()!="" && $(this).val().length<=9) {
            $("#enough").addClass("enough");
            $("#medium").removeClass("medium");
        	$("#strong").removeClass("strong");
        } else if (strongRegex.test($(this).val())) {
        	$("#enough").addClass("enough");
        	$("#medium").addClass("medium");
        	$("#strong").addClass("strong");
        } else if (mediumRegex.test($(this).val())) {
        	$("#enough").addClass("enough");
        	$("#medium").addClass("medium");
        	$("#strong").removeClass("strong");
        }else{
        	$("#enough").removeClass("enough");
        	$("#medium").removeClass("medium");
        	$("#strong").removeClass("strong");
        }
    });
});
