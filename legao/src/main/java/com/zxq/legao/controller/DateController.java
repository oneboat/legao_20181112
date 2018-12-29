package com.zxq.legao.controller;

import com.zxq.legao.entity.po.DatePO;
import com.zxq.legao.entity.vo.DateVO;
import com.zxq.legao.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * <p>
 * 日期前端控制器
 * </p>
 *
 * @author dengzhenxiang
 * @Date 2018/11/11 17:41
 */
@Controller
public class DateController {
    @Autowired
    private DateService dateService;

    /**
     * 跳转到dateAdd
     */
    @RequestMapping("/dateAdd")
    public String jumpDateAdd(HttpServletRequest request) {
        request.setAttribute("type", request.getAttribute("type"));
        return "date/dateAdd";
    }

    /**
     * 查询时间段
     */
    @RequestMapping("/selectDate")
    public String selectDate(DatePO datePO, HttpServletRequest request, Integer page) {

        return dateService.selectDate(page, datePO, request);
    }

    /**
     * 添加时间段
     */
    @RequestMapping("/insertDate")
    public String insertDate(DatePO date, HttpServletRequest request) {
        if (dateService.insertDate(date) > 0) {
            request.setAttribute("type", "yes");
        } else {
            request.setAttribute("type", "no");
        }
        ServletContext servletContext = request.getServletContext();
        List<DateVO> allDate = dateService.findAllDate();
        servletContext.setAttribute("allDate", allDate);

        return "date/dateAdd";
    }

    /**
     * 删除时间段
     */
    @RequestMapping("/deleteDates")
    public String deleteDates(Integer[] caption, HttpServletRequest request) {

        dateService.deleteDate(Arrays.asList(caption));
        ServletContext servletContext = request.getServletContext();
        List<DateVO> allDate = dateService.findAllDate();
        servletContext.setAttribute("allDate", allDate);
        return "forward:/selectDate";


    }

    /**
     * 根据id查找时间段
     */
    @RequestMapping("/editDate")
    public String editDate(@RequestParam("dateId") Integer dateId, HttpServletRequest request) {
        DateVO dateVO = dateService.selectDateByID(dateId);
        request.setAttribute("dateByID", dateVO);
        return "forward:/editDateFrom";

    }

    /**
     * 根据给编辑页赋值
     */
    @RequestMapping("/editDateFrom")
    public String editDateFrom(HttpServletRequest request) {
        DateVO dateVO = (DateVO) request.getAttribute("dateByID");
        request.setAttribute("dateEdit", dateVO);
        return "date/dateEdit";

    }

    /**
     * 保存编辑值
     */
    @RequestMapping("/saveDate")
    public String saveDate(DatePO date, HttpServletRequest request) {
        dateService.updateDate(date);
        ServletContext servletContext = request.getServletContext();
        List<DateVO> allDate = dateService.findAllDate();
        servletContext.setAttribute("allDate", allDate);
        return "redirect:/selectDate";

    }
}
