package com.zxq.legao.controller;

import com.zxq.legao.entity.po.UserPO;
import com.zxq.legao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/aa")
	public String aa() {
		return "index";
	}

	@RequestMapping("/insertUser")
	public String aa(UserPO userPO) {
		int flag = (userService.insertUser(userPO));
		return "login";
	}


}
