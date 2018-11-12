package com.zxq.legao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping("/aa")
	public String aa() {
		return "index";
	}

}
