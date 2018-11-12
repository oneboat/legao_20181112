package com.zxq.legao.controller;

import com.zxq.legao.entity.po.UserPO;
import com.zxq.legao.service.LoginServie;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
	@Autowired
	private LoginServie loginServie;

	@RequestMapping("/toLogin")
	public String toLogin(UserPO userPO){
		UserPO userPO1 = loginServie.findUserByNameAndPass(userPO);
		return userPO1.toString();
	}
}
