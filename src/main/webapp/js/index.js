var tab = null;
var accordion = null;
var tree = null;
var tabItems = [];
function f_addTab(tabid, text, url){
    tab.addTabItem({
        tabid: tabid,
        text: text,
        url: url
    });
}
$(function(){
	$("#role").change(function(){
		var positionCode = $(this).val();
		location.href = hostURL+"index/switchrole?positionCode="+positionCode;
	});
	//退出
	$("#exit").click(function(){
		$.ligerDialog.confirm('确定退出？', function (yes) {
			if(yes){
				location.href = hostURL+"user/loginout";
			}
		});
	});
	//布局
	$("#layout1").ligerLayout({
		leftWidth: 190,
		height: '100%',
		heightDiff: -34,
	});

	var height = $(".l-layout-center").height();

	//Tab
	tab = $("#framecenter").ligerTab({
		height: height,
		showSwitchInTab : true,
		showSwitch: true,
		onAfterAddTabItem: function (tabdata){
			tabItems.push(tabdata);
		},
		onAfterRemoveTabItem: function (tabid){ 
			for (var i = 0; i < tabItems.length; i++){
				var o = tabItems[i];
				if (o.tabid == tabid){
					tabItems.splice(i, 1);
					break;
				}
			}
		},
		onReload: function (tabdata)
		{
			var tabid = tabdata.tabid;
		}
	});

	//菜单面板
	$("#menu").ligerAccordion({
		height: height - 24, speed: null
	});

	//树
	for(var key in childMenu){
		$("#"+key).ligerTree({
			data : childMenu[key],
			checkbox: false,
			slide: false,
			nodeWidth: 120,
			attribute: ['nodename', 'url'],
			render : function(a){
				if (!a.isnew) return a.text;
				return '<a href="' + hostURL+a.url + '" target="_blank">' + a.text + '</a>';
			},
			onSelect: function (node)
			{
				if (!node.data.url){
					return;
				}
				if (node.data.isnew){ 
					return;
				}
				var tabid = $(node.target).attr("tabid");
				if (!tabid){
					tabid = new Date().getTime();
					$(node.target).attr("tabid", tabid)
				}
				f_addTab(tabid, node.data.text, node.data.url);
			}
		});
	}
	tab = liger.get("framecenter");
	accordion = liger.get("accordion1");
	tree = liger.get("tree1");
	$("#pageloading").hide();
	
});

