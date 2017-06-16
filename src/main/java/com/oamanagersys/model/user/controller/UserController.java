package com.oamanagersys.model.user.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oamanagersys.model.user.entity.Emp;
import com.oamanagersys.model.user.service.UserService;
import com.oamanagersys.util.response.Message;
import com.oamanagersys.util.validation.ValidationCode;

/**
 * 创建人： 李明
 * 时    间：2017年3月23日
 * 联    系：17310545652
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	/**
	 * 添加员工页面
	 */
	@RequestMapping("/adduser")
	public ModelAndView addUser(){
		ModelAndView mav = new ModelAndView("pages/usermanager/adduser");
		return mav;
	}
	/**
	 * 员工信息管理
	 */
	@RequestMapping("/userlist")
	public String staffInfor(){
		return "pages/usermanager/userlist";
	}
	
	/**
	 * 编辑信息页面
	 */
	@RequestMapping("/editinfomation")
	public ModelAndView infoMationPage(){
		ModelAndView mav = new ModelAndView("pages/manageset/editinfomation");
		return mav;
	}
	
	/**
	 * 账号与安全
	 */
	@RequestMapping("/accountsecurity")
	public ModelAndView accountSecurityPage(){
		ModelAndView mav = new ModelAndView("pages/manageset/accountsecurity");
		return mav;
	}
	
	/**
	 * 账号信息页面
	 */
	@RequestMapping("/accountinfo")
	public ModelAndView accountInfo(){
		ModelAndView mav = new ModelAndView("pages/manageset/accountinfo");
		return mav;
	}
	
	/**
	 * 设置密码页面
	 */
	@RequestMapping("/setpwd")
	public ModelAndView setPwd(){
		ModelAndView mav = new ModelAndView("pages/manageset/setpwd");
		return mav;
	}
	
	/**
	 * 登录日志页面
	 */
	@RequestMapping("/loginlog")
	public ModelAndView loginLog(){
		ModelAndView mav = new ModelAndView("pages/manageset/loginlog");
		return mav;
	}
	
	/**
	 * 创建验证码
	 * 
	 * @param req
	 * @param resp
	 */
	@RequestMapping("/code")
	public void getCode(HttpServletRequest req, HttpServletResponse resp) {
		ValidationCode code = new ValidationCode();
		// 禁止图像缓存。
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);

		resp.setContentType("image/png");
		req.getSession().setAttribute("code", code.getCode());
		try {
			ServletOutputStream sos = resp.getOutputStream();
			ImageIO.write(code.getBuffImg(), "jpeg", sos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 刷新验证码
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/recode")
	@ResponseBody
	public Object getReCode(HttpServletRequest req, HttpServletResponse resp) {
		//创建验证码工具类对象
		ValidationCode code = new ValidationCode();
		Message msg = new Message();
		try {
			Date data = new Date();
			Long time = data.getTime();
			String imgName = time + "code.png";
			String path = req.getSession().getServletContext().getRealPath("") + "/icon/" + imgName;
			msg.strMessage = imgName;
			code.write(path);
			//获取验证码
			req.getSession().setAttribute("code", code.getCode());

		} catch (IOException e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	/**
	 * 登录
	 * 
	 * @param req
	 * @param user
	 * @param code
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Object getUserByAccountPwd(HttpServletRequest req,String account,String password, String code) {
		Message msg = new Message();
		String oldCode = req.getSession().getAttribute("code").toString();
		if (!oldCode.equals(code.toUpperCase())) {
			msg.isSuccess = false;
			msg.strMessage = "验证码错误";
			msg.errorType = "codeError";
		}else{
			msg.isSuccess = true;
			req.getSession().setAttribute("userId", account);
		}
		
//		try {
//			if(!"admin".equals(account)) {
//				msg.isSuccess = false;
//				msg.strMessage = "账号错误";
//				msg.errorType = "accountError";
//			}else if(!"admin".equals(password)) {
//				msg.isSuccess = false;
//				msg.strMessage = "密码错误";
//				msg.errorType = "pwdError";
//			}else if (!oldCode.equals(code.toUpperCase())) {
//				msg.isSuccess = false;
//				msg.strMessage = "验证码错误";
//				msg.errorType = "codeError";
//			}else{
//				msg.isSuccess = true;
//				req.getSession().setAttribute("user", account);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return msg;
	}
	
	/**
	 * 自动加载在本机上登录过的并记住密码的账号
	 * @param req
	 * @return
	 */
//	@RequestMapping("/loadAccount")
//	@ResponseBody
//	public Object selectUserLoacl(HttpServletRequest req){
//		List<User> users = userService.selectUserLoacl(req);
//		return null;
//	}
	/**
	 * 自动查询密码
	 * @param userAccount
	 * @return
	 */
//	@RequestMapping("/loadPwd")
//	@ResponseBody
//	public Object selectUserPwd(String userAccount){
//		String password = userService.selectUserPwd(userAccount);
//		Message msg = new Message();
//		msg.strMessage = password;
//		return msg;
//	}
	@RequestMapping("/getallemp")
	public List<Emp> getAllEmp(){
		List<Emp> list = userService.getAllEmp();
		return list;
	}
	
}
