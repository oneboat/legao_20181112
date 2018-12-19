package com.zxq.legao.controller;


import com.zxq.legao.entity.po.CoursePO;
import com.zxq.legao.entity.vo.CourseVO;
import com.zxq.legao.service.CourseService;
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

public class CourseController {
    @Autowired
    private CourseService courseService;

    // 跳转到courseAdd
    @RequestMapping("/courseAdd")
    public String jumpCourseAdd(HttpServletRequest request) {
        request.setAttribute("type", request.getAttribute("type"));
        return "course/courseAdd";
    }

    //查询课程
    @RequestMapping("/selectCourse")
    public String selectCourse(CoursePO coursePO, HttpServletRequest request, Integer page) {

        return courseService.selectCourse(page, coursePO, request);
    }

    // 添加课程
    @RequestMapping("/insertCourse")
    public String insertCourse(CoursePO course, HttpServletRequest request) {
        if (courseService.insertCourse(course) > 0) {
            request.setAttribute("type", "yes");
        } else {
            request.setAttribute("type", "no");
        }
        return "course/courseAdd";
    }

    // 删除课程
    @RequestMapping("/deleteCourses")
    public String deleteCourses(Integer[] caption, HttpServletRequest request) {

        courseService.deleteCourse(Arrays.asList(caption));

        return "forward:/selectCourse";


    }

    // 根据id查找课程
    @RequestMapping("/editCourse")
    public String editCourse(@RequestParam("courseId") Integer courseId, HttpServletRequest request) {
        CourseVO courseVO = courseService.selectCourseByID(courseId);
        request.setAttribute("courseByID", courseVO);
        return "forward:/editCourseFrom";

    }

    // 根据给编辑页赋值
    @RequestMapping("/editCourseFrom")
    public String editCourseFrom(HttpServletRequest request) {
        CourseVO courseVO = (CourseVO) request.getAttribute("courseByID");
        request.setAttribute("courseEdit", courseVO);
        return "course/courseEdit";

    }

    // 保存编辑值
    @RequestMapping("/saveCourse")
    public String saveCourse(CoursePO course) {
        courseService.updateCourse(course);
        return "redirect:/selectCourse";

    }
}

