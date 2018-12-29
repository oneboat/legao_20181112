package com.zxq.legao.controller;


import com.zxq.legao.entity.po.EmployPO;
import com.zxq.legao.entity.vo.EmployVO;
import com.zxq.legao.service.EmployService;
import com.zxq.legao.service.EmployService;
import com.zxq.legao.service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author dengzhenxiang
 * @since 2018-11-27
 */
@Controller
public class EmployController {
    @Autowired
    private EmployService employService;

    /**
     * 跳转到employAdd
     */
    @RequestMapping("/employAdd")
    public String jumpEmployAdd(HttpServletRequest request) {
        request.setAttribute("type", request.getAttribute("type"));
        return "employ/employAdd";
    }

    /**
     * 查询员工
     */
    @RequestMapping("/selectEmploy")
    public String selectEmploy(EmployPO employPO, HttpServletRequest request, Integer page) {
        return employService.selectEmploy(page, employPO, request);
    }

    /**
     * 添加员工
     */
    @RequestMapping("/insertEmploy")
    public String insertEmploy(EmployPO employ, HttpServletRequest request) {
        if (employService.insertEmploy(employ) > 0) {

            request.setAttribute("type", "yes");
        } else {
            request.setAttribute("type", "no");
        }
        ServletContext servletContext = request.getServletContext();
        List<EmployPO> allemploy = employService.selectAllEmploy();
        servletContext.setAttribute("allemploy", allemploy);
        return "employ/employAdd";
    }


    /**
     * 删除员工
     */
    @RequestMapping("/deleteEmploys")
    public String deleteEmploys(Integer[] caption, HttpServletRequest request) {

        employService.deleteEmploy(Arrays.asList(caption));
        ServletContext servletContext = request.getServletContext();
        List<EmployPO> allemploy = employService.selectAllEmploy();
        servletContext.setAttribute("allemploy", allemploy);
        return "redirect:/selectEmploy";


    }

    /**
     * 根据id查找员工
     */
    @RequestMapping("/editEmploy")
    public String editEmploy(@RequestParam("employId") Integer employId, HttpServletRequest request) {
        EmployPO employPO = employService.selectEmployByID(employId);
        request.setAttribute("employByID", employPO);
        return "forward:/editEmployFrom";

    }

    /**
     * 根据给编辑页赋值
     */
    @RequestMapping("/editEmployFrom")
    public String editEmployFrom(HttpServletRequest request) {
        EmployPO employPO = (EmployPO) request.getAttribute("employByID");
        request.setAttribute("employEdit", employPO);
        return "employ/employEdit";

    }

    /**
     * 保存编辑值
     */
    @RequestMapping("/saveEmploy")
    public String saveEmploy(EmployPO employ, HttpServletRequest request) {
        employService.updateEmploy(employ);
        ServletContext servletContext = request.getServletContext();
        List<EmployPO> allemploy = employService.selectAllEmploy();
        servletContext.setAttribute("allemploy", allemploy);
        return "redirect:/selectEmploy";

    }


}

