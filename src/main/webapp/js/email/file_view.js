function dowload(id){
	
}
$(function(){
	$("#file_list").ligerGrid({
		usePager:false,
		selectRowButtonOnly:true,
        columns: [
	        { display: 'id', name: 'id',hide : true, },
	        { display: '文件名', name: 'fileName', width: "40%"},
	        { display: '大小', name: 'fileSize', width:"20%"},
	        { display: '时间', name: 'createTime', width:"30%"},
	        { display: '下载', name: 'fileId', width:"10%",render:function(row){
	        	return '<img class="fileId" onclick="download('+row.id+')" style="margin-top:6px;cursor:pointer;" src="/Source/lib/ligerUI/skins/icons/down.gif" />';
	        }}
        ],
        url:path+"/file/list?fileId="+$("#fileId").val(),
        width: '100%'
	});
});

