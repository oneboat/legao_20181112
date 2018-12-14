package com.zxq.legao.controller;

import com.zxq.legao.entity.po.SchoolAreaPO;
import com.zxq.legao.entity.vo.SchoolAreaVO;
import com.zxq.legao.service.SchoolAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author dengzhenxiang
 * @since 2018-11-27
 */
@Controller

public class SchoolAreaController {
    @Autowired
    private SchoolAreaService schoolAreaService;

    // 跳转到schoolAreaAdd
    @RequestMapping("/schoolAreaAdd")
    public String jumpSchoolAreaAdd(HttpServletRequest request) {
        request.setAttribute("type", request.getAttribute("type"));
        return "schoolArea/schoolAreaAdd";
    }

    //查询跟进人
    @RequestMapping("/selectSchoolArea")
    public String selectSchoolArea(SchoolAreaPO schoolAreaPO, HttpServletRequest request, Integer page) {

        return schoolAreaService.selectSchoolArea(page, schoolAreaPO, request);
    }

    // 添加跟进人
    @RequestMapping("/insertSchoolArea")
    public String insertSchoolArea(SchoolAreaPO schoolArea, HttpServletRequest request) {
        if (schoolAreaService.insertSchoolArea(schoolArea) > 0) {
            request.setAttribute("type", "yes");
        } else {
            request.setAttribute("type", "no");
        }
        return "schoolArea/schoolAreaAdd";
    }

    // 删除跟进人
    @RequestMapping("/deleteSchoolAreas")
    public String deleteSchoolAreas(Integer[] caption, HttpServletRequest request) {

        schoolAreaService.deleteSchoolArea(Arrays.asList(caption));

        return "forward:/selectSchoolArea";


    }

    // 根据id查找跟进人
    @RequestMapping("/editSchoolArea")
    public String editSchoolArea(@RequestParam("schoolAreaId") Integer schoolAreaId, HttpServletRequest request) {
        SchoolAreaVO schoolAreaVO = schoolAreaService.selectSchoolAreaByID(schoolAreaId);
        request.setAttribute("schoolAreaByID", schoolAreaVO);
        return "forward:/editSchoolAreaFrom";

    }

    // 根据给编辑页赋值
    @RequestMapping("/editSchoolAreaFrom")
    public String editSchoolAreaFrom(HttpServletRequest request) {
        SchoolAreaVO schoolAreaVO = (SchoolAreaVO) request.getAttribute("schoolAreaByID");
        request.setAttribute("schoolAreaEdit", schoolAreaVO);
        return "schoolArea/schoolAreaEdit";

    }

    // 保存编辑值
    @RequestMapping("/saveSchoolArea")
    public String saveSchoolArea(SchoolAreaPO schoolArea) {
        schoolAreaService.updateSchoolArea(schoolArea);
        return "redirect:/selectSchoolArea";
    }
}
