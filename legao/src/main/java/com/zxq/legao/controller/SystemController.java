package com.zxq.legao.controller;

import com.zxq.legao.dao.UserDao;
import com.zxq.legao.entity.po.StudentPO;
import com.zxq.legao.entity.vo.StudentVO;
import com.zxq.legao.entity.vo.UserVO;
import com.zxq.legao.service.SystemService;
import com.zxq.legao.util.ConverstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class SystemController {
	@Autowired
	private SystemService systemService;
	// 跳转到userAdd
	@RequestMapping("/fieldSet")
	public String jumpfieldSet() {
		return "system/fieldSet";
	}
	@RequestMapping("/selectStudentField")
	public String selectStudentField(StudentVO studentVO, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("user");
		if (userVO!=null){
			String fieldStr = ConverstUtil.strToDBStr(studentVO.getSelectFields());
			systemService.updateFieldsSet(fieldStr,userVO.getId());
			request.setAttribute("setStatus","设置成功");
		}else {
			request.setAttribute("setStatus","设置失败，请先登录");
		}
		return "system/fieldSet";
	}
}
