package com.zxq.legao.controller;

import com.alibaba.fastjson.JSON;
import com.zxq.legao.dao.UserDao;
import com.zxq.legao.entity.po.StudentPO;
import com.zxq.legao.entity.vo.StudentVO;
import com.zxq.legao.entity.vo.UserVO;
import com.zxq.legao.service.EmployService;
import com.zxq.legao.service.SystemService;
import com.zxq.legao.util.ConverstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class SystemController {
    @Autowired
    private SystemService systemService;

    @Autowired
    private EmployService employService;

    // 跳转到userAdd
    @RequestMapping("/fieldSet")
    public String jumpfieldSet() {
        return "system/fieldSet";
    }

    @PostMapping("/selectStudentField")
    @ResponseBody
    public String selectStudentField(@RequestBody List<String> caption, HttpServletRequest request) {
        return systemService.updateFieldsSet("selectStudentFields", caption, request);
    }

    @PostMapping("/selectEmployField")
    @ResponseBody
    public String selectEmployFieldForm(@RequestBody List<String> caption, HttpServletRequest request) {
        return systemService.updateFieldsSet("selectEmployFields", caption, request);

    }
}
