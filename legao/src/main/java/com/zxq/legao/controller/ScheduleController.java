package com.zxq.legao.controller;


import com.zxq.legao.entity.po.SchedulePO;
import com.zxq.legao.entity.vo.ScheduleVO;
import com.zxq.legao.service.ScheduleService;
import com.zxq.legao.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;


    // 跳转到ScheduleAdd
    @RequestMapping("/scheduleAdd")
    public String jumpScheduleAdd(HttpServletRequest request) {
        request.setAttribute("type", request.getAttribute("type"));
        return "schedule/scheduleAdd";
    }

    //查询排课人
    @RequestMapping("/selectSchedule")
    public String selectSchedule(SchedulePO SchedulePO, HttpServletRequest request, Integer page) {
        return scheduleService.selectSchedule(SchedulePO, request);
    }

    // 添加排课人
    @RequestMapping("/insertSchedule")
    public String insertSchedule(SchedulePO schedule, HttpServletRequest request) {
        if (scheduleService.insertSchedule(schedule) > 0) {
            request.setAttribute("type", "yes");
        } else {
            request.setAttribute("type", "no");
        }
        return "schedule/scheduleAdd";
    }

    // 删除排课
    @RequestMapping("/deleteSchedules")
    public String deleteSchedules(Integer[] caption, HttpServletRequest request) {

        scheduleService.deleteSchedule(Arrays.asList(caption));

        return "forward:/selectSchedule";


    }

    // 根据id查找排课人
    @RequestMapping("/editSchedule")
    public String editSchedule(@RequestParam("scheduleId") Integer scheduleId, HttpServletRequest request) {
        ScheduleVO scheduleVO = scheduleService.selectScheduleByID(scheduleId);
        request.setAttribute("scheduleByID", scheduleVO);
        return "forward:/editScheduleFrom";

    }

    // 根据给编辑页赋值
    @RequestMapping("/editScheduleFrom")
    public String editScheduleFrom(HttpServletRequest request) {
        ScheduleVO scheduleVO = (ScheduleVO) request.getAttribute("scheduleByID");
        request.setAttribute("scheduleEdit", scheduleVO);
        return "Schedule/ScheduleEdit";

    }

    // 保存编辑值
    @RequestMapping("/saveSchedule")
    public String saveSchedule(SchedulePO Schedule) {
        scheduleService.updateSchedule(Schedule);
        return "redirect:/selectSchedule";
    }
}

