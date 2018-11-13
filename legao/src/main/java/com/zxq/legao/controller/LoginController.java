package com.zxq.legao.controller;

import com.zxq.legao.entity.po.UserPO;
import com.zxq.legao.entity.vo.UserVO;
import com.zxq.legao.service.LoginService;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {
	@Autowired
	private LoginService loginServie;

	@RequestMapping("/")
	public String view(){
		return "login";
	}
	//登录
	@RequestMapping("/toLogin")
	public String toLogin(UserPO userPO, HttpServletRequest request){
		UserVO userVO1 = loginServie.findUserByNameAndPass(userPO);
		if (userVO1 == null || userVO1.getUsername().equals("")){
			request.setAttribute("msg","登录名或者密码错误！");
			return "login";
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("user",userVO1);
			return "main";
		}

	}
	//注销退出
	@RequestMapping("/logOff")
	public String logOff(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.invalidate();
		return "login";
	}
	//跳转各个页面
	@RequestMapping("/{view}")
	public String jump(@PathVariable String view){
		return view;
	}


}
