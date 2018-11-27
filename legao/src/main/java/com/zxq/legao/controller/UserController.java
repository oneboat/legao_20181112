package com.zxq.legao.controller;

import com.zxq.legao.entity.po.FollowPO;
import com.zxq.legao.entity.po.SchoolAreaPO;
import com.zxq.legao.entity.po.UserPO;
import com.zxq.legao.entity.vo.EmployVO;
import com.zxq.legao.entity.vo.FollowVO;
import com.zxq.legao.entity.vo.SchoolAreaVO;
import com.zxq.legao.entity.vo.UserVO;
import com.zxq.legao.service.FollowService;
import com.zxq.legao.service.SchoolAreaService;
import com.zxq.legao.service.StudentService;
import com.zxq.legao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private SchoolAreaService schoolAreaService;

	@Autowired
	private FollowService followService;

	@Autowired
	private StudentService studentService;

	@RequestMapping("/")
	public String view() {
		return "login";
	}

	//登录
	@RequestMapping("/toLogin")
	public String toLogin(UserPO userPO, HttpServletRequest request) {
		UserVO userVO1 = userService.selectUserByNameAndPass(userPO);
		if (userVO1 == null || userVO1.getUsername().equals("")) {
			request.setAttribute("msg", "登录名或者密码错误！");
			return "login";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", userVO1);
			//初始化
			List<SchoolAreaVO> allSchoolArea = schoolAreaService.findAllSchoolAreaName(new SchoolAreaPO());
			List<FollowVO> allFollow = followService.findAllFollowName(new FollowPO());
			List<EmployVO> allTeacherName = studentService.selectTeacherName();
			ServletContext servletContext = request.getServletContext();
			servletContext.setAttribute("allSchoolArea", allSchoolArea);
			servletContext.setAttribute("allFollow", allFollow);
			servletContext.setAttribute("allTeacherName", allTeacherName);
			return "main";
		}

	}

	//注销退出
	@RequestMapping("/logOff")
	public String logOff(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "login";
	}

	//跳转各个页面
	@RequestMapping("/{view}")
	public String jump(@PathVariable String view) {
		return view;
	}


	// 跳转到userAdd
	@RequestMapping("/userAdd")
	public String jumpUserAdd(HttpServletRequest request) {
		request.setAttribute("type", request.getAttribute("type"));
		return "user/userAdd";
	}

	//查询用户
	@RequestMapping("/selectUser")
	public String selectUser(UserPO userPO, HttpServletRequest request, Integer page) {

		return userService.selectUser(page, userPO, request);
	}

	// 添加用户
	@RequestMapping("/insertUser")
	public String insertUser(UserPO user, HttpServletRequest request) {
		if (userService.insertUser(user) > 0) {
			request.setAttribute("type", "yes");
		} else {
			request.setAttribute("type", "no");
		}
		return "user/userAdd";
	}

	// 判断登录名是否重复
	@RequestMapping("/isReLoginname")
	@ResponseBody
	public String isReLoginname(@RequestBody UserPO userPO) {
		List<UserVO> hasUser = userService.findUsername(userPO);
		if (hasUser.size() > 0) {
			// 设置为false代表登录名重复
			return "false";
		} else {
			return "true";
		}

	}

	// 删除用户
	@RequestMapping("/deleteUsers")
	public String deleteUsers(Integer[] caption, HttpServletRequest request) {
		UserVO userVO = (UserVO) request.getSession().getAttribute("user");
		Integer userID = userVO.getId();
		boolean flag = userService.isDeleteItself(caption, userID);

		if (flag) {
			request.setAttribute("isDeleteItself", flag);
			return "forward:/selectUser";
		} else {
			userService.deleteUser(Arrays.asList(caption));
			return "redirect:/selectUser";
		}

	}

	// 根据id查找用户
	@RequestMapping("/editUser")
	public String editUser(@RequestParam("userId") Integer userId, HttpServletRequest request) {
		UserVO userVO = userService.selectUserByID(userId);
		request.setAttribute("userByID", userVO);
		return "forward:/editUserFrom";

	}

	// 根据给编辑页赋值
	@RequestMapping("/editUserFrom")
	public String editUserFrom(HttpServletRequest request) {
		UserVO userVO = (UserVO) request.getAttribute("userByID");
		request.setAttribute("userEdit", userVO);
		return "user/userEdit";

	}

	// 保存编辑值
	@RequestMapping("/saveUser")
	public String saveUser(UserPO user) {
		userService.updateUser(user);
		return "redirect:/selectUser";

	}

}
