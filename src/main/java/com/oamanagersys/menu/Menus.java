package com.oamanagersys.menu;

import com.oamanagersys.util.annotation.Menu;
/**
 * 配置首页的顶级菜单
 * @author 李明
 *
 */
public class Menus {
	@Menu(text="个人事务",id="personalissue")
	String personalissue;
	
	@Menu(text="员工管理",id="em")
	String em;
	
	@Menu(text="工作流",id="workflow")
	String workflow;
	
	@Menu(text="行政办公",id="administration")
	String administration;
	
	@Menu(text="知识管理",id="km")
	String km;
	
	@Menu(text="人力资源",id="hr")
	String hr;
	
	@Menu(text="档案管理",id="archives")
	String archives;
	
	@Menu(text="客户管理",id="cms")
	String cms;
	
	@Menu(text="系统报表",id="reportingsys")
	String reportingsys;
	
	@Menu(text="交流园地",id="exchange")
	String exchange;
	
	@Menu(text="公文管理",id="officialdocument")
	String officialdocument;
	
	@Menu(text="程序附件",id="procedure")
	String procedure;
	
	@Menu(text="系统管理",id="sysmanager")
	String sysmanager;
	
}
