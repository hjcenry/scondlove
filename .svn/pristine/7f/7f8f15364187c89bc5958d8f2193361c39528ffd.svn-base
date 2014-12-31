package com.mochasoft.admin.login;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mochasoft.admin.user.User;
import com.mochasoft.admin.user.UserService;
import com.mochasoft.util.Constants;
import com.mochasoft.util.DESedeCoder;


@Controller
@RequestMapping(value="/admin")
public class LoginAdminController {
	
	@Autowired
	private UserService userService;//登录用户
	
	/** 自动跳转到登录页面 **/
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login(){
		
	}
	
	/* 提交账户密码登录 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Login login,HttpSession session,Model model){
		Assert.notNull(login.getLoginname());
		Assert.notNull(login.getPassword());
		String username = login.getLoginname();
		String password = Base64.encodeBase64String(DESedeCoder.encrypt(login.getPassword().getBytes())).replaceAll("\r\n", "");
		User user = userService.getUserByUP(username,password);
		if(user ==null){
			return "redirect:login";
		}
		session.setMaxInactiveInterval(144000);
		session.setAttribute(Constants.SESSION_USERVO, user);
		return "redirect:../deal/purchase";
	}
	
	/* 退出登录  */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:login";
	}
	
	/*
	 * 登录完成首页
	 * */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void index(){
		
	}
	/*
	 * top
	 * */
	@RequestMapping(value = "/top", method = RequestMethod.GET)
	public void top(Model model,HttpSession session){
		//person.getAdminflag()
		User user = (User)session.getAttribute(Constants.SESSION_USERVO);
		model.addAttribute("personname", user.getName());
	}
	/*
	 * 左边
	 * */
	@RequestMapping(value = "/left", method = RequestMethod.GET)
	public void left(Model model,HttpSession session){
		User user = (User)session.getAttribute(Constants.SESSION_USERVO);
		model.addAttribute("user", user);
	}
	/*
	 * 左边
	 * */
	@RequestMapping(value = "/content", method = RequestMethod.GET)
	public void content(Model model,HttpSession session){
		
	}
	/*
	 * 底层
	 * */
	@RequestMapping(value = "/bottom", method = RequestMethod.GET)
	public void bottom(Model model,HttpSession session){
		
	}
}
