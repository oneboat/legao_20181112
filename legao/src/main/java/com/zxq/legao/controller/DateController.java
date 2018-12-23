package com.zxq.legao.controller;

import com.zxq.legao.entity.po.DatePO;
import com.zxq.legao.entity.vo.DateVO;
import com.zxq.legao.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
public class DateController {
    @Autowired
    private DateService dateService;

    // 跳转到dateAdd
    @RequestMapping("/dateAdd")
    public String jumpDateAdd(HttpServletRequest request) {
        request.setAttribute("type", request.getAttribute("type"));
        return "date/dateAdd";
    }

    //查询跟进人
    @RequestMapping("/selectDate")
    public String selectDate(DatePO datePO, HttpServletRequest request, Integer page) {

        return dateService.selectDate(page, datePO, request);
    }

    // 添加跟进人
    @RequestMapping("/insertDate")
    public String insertDate(DatePO date, HttpServletRequest request) {
        if (dateService.insertDate(date) > 0) {
            request.setAttribute("type", "yes");
        } else {
            request.setAttribute("type", "no");
        }
        return "date/dateAdd";
    }

    // 删除跟进人
    @RequestMapping("/deleteDates")
    public String deleteDates(Integer[] caption, HttpServletRequest request) {

        dateService.deleteDate(Arrays.asList(caption));

        return "forward:/selectDate";


    }

    // 根据id查找跟进人
    @RequestMapping("/editDate")
    public String editDate(@RequestParam("dateId") Integer dateId, HttpServletRequest request) {
        DateVO dateVO = dateService.selectDateByID(dateId);
        request.setAttribute("dateByID", dateVO);
        return "forward:/editDateFrom";

    }

    // 根据给编辑页赋值
    @RequestMapping("/editDateFrom")
    public String editDateFrom(HttpServletRequest request) {
        DateVO dateVO = (DateVO) request.getAttribute("dateByID");
        request.setAttribute("dateEdit", dateVO);
        return "date/dateEdit";

    }

    // 保存编辑值
    @RequestMapping("/saveDate")
    public String saveDate(DatePO date) {
        dateService.updateDate(date);
        return "redirect:/selectDate";

    }
}
