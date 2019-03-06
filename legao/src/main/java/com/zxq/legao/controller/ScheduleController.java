package com.zxq.legao.controller;


import com.zxq.legao.entity.po.SchedulePO;
import com.zxq.legao.entity.vo.ScheduleVO;
import com.zxq.legao.service.ScheduleService;
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
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;


    /**
     * 跳转到ScheduleAdd
     */
    @RequestMapping("/scheduleAdd")
    public String jumpScheduleAdd(HttpServletRequest request) {
        request.setAttribute("type", request.getAttribute("type"));
        return "schedule/scheduleAdd";
    }

    /**
     * 查询排课
     */
    @RequestMapping("/selectSchedule")
    public String selectSchedule(SchedulePO SchedulePO, HttpServletRequest request, Integer page) {
        return scheduleService.selectSchedule(SchedulePO, request);
    }

    /**
     * 添加排课
     */
    @RequestMapping("/insertSchedule")
    public String insertSchedule(SchedulePO schedule, HttpServletRequest request) {
        if (scheduleService.insertSchedule(schedule) > 0) {
            request.setAttribute("type", "yes");
        } else {
            request.setAttribute("type", "no");
        }
        List<ScheduleVO> allWeekOfYear = scheduleService.findAllweekOfYear();
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("allWeekOfYear", allWeekOfYear);

        return "schedule/scheduleAdd";
    }

    /**
     * 删除排课
     */
    @RequestMapping("/deleteSchedules")
    public String deleteSchedules(Integer[] caption, HttpServletRequest request) {

        scheduleService.deleteSchedule(Arrays.asList(caption));

        List<ScheduleVO> allWeekOfYear = scheduleService.findAllweekOfYear();
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("allWeekOfYear", allWeekOfYear);
        return "forward:/selectSchedule";


    }

    /**
     * 根据id查找排课
     */
    @RequestMapping("/editSchedule")
    public String editSchedule(@RequestParam("scheduleId") Integer scheduleId, HttpServletRequest request) {
        ScheduleVO scheduleVO = scheduleService.selectScheduleByID(scheduleId);
        request.setAttribute("scheduleByID", scheduleVO);
        return "forward:/editScheduleFrom";

    }

    /**
     * 根据给编辑页赋值
     */
    @RequestMapping("/editScheduleFrom")
    public String editScheduleFrom(HttpServletRequest request) {
        ScheduleVO scheduleVO = (ScheduleVO) request.getAttribute("scheduleByID");
        request.setAttribute("scheduleEdit", scheduleVO);
        return "schedule/scheduleEdit";

    }

    /**
     * 保存编辑值
     */
    @RequestMapping("/saveSchedule")
    public String saveSchedule(SchedulePO Schedule, HttpServletRequest request) {
        scheduleService.updateSchedule(Schedule);
        List<ScheduleVO> allWeekOfYear = scheduleService.findAllweekOfYear();
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("allWeekOfYear", allWeekOfYear);
        return "redirect:/selectSchedule";
    }
}

