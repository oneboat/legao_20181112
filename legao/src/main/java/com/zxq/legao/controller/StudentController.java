package com.zxq.legao.controller;

import com.zxq.legao.entity.po.StudentPO;
import com.zxq.legao.entity.vo.StudentVO;
import com.zxq.legao.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    // 跳转到studentAdd
    @RequestMapping("/studentAdd")
    public String jumpStudentAdd(HttpServletRequest request) {
        request.setAttribute("type", request.getAttribute("type"));
        return "student/studentAdd";
    }

    //查询学员
    @RequestMapping("/selectStudent")
    public String selectStudent(StudentPO studentPO, HttpServletRequest request, Integer page) {
        return studentService.selectStudent(page, studentPO, request);
    }

    // 添加学员
    @RequestMapping("/insertStudent")
    public String insertStudent(StudentPO student, HttpServletRequest request) {
        if (studentService.insertStudent(student) > 0) {
            request.setAttribute("type", "yes");
        } else {
            request.setAttribute("type", "no");
        }
        return "student/studentAdd";
    }


    // 删除学员
    @RequestMapping("/deleteStudents")
    public String deleteStudents(Integer[] caption) {

        studentService.deleteStudent(Arrays.asList(caption));
        return "redirect:/selectStudent";


    }

    // 根据id查找学员
    @RequestMapping("/editStudent")
    public String editStudent(@RequestParam("studentId") Integer studentId, HttpServletRequest request) {
        StudentVO studentVO = studentService.selectStudentByID(studentId);
        request.setAttribute("studentByID", studentVO);
        return "forward:/editStudentFrom";

    }

    // 根据给编辑页赋值
    @RequestMapping("/editStudentFrom")
    public String editStudentFrom(HttpServletRequest request) {
        StudentVO studentVO = (StudentVO) request.getAttribute("studentByID");
        request.setAttribute("studentEdit", studentVO);
        return "student/studentEdit";

    }

    // 保存编辑值
    @RequestMapping("/saveStudent")
    public String saveStudent(StudentPO student) {
        studentService.updateStudent(student);
        return "redirect:/selectStudent";

    }
}
