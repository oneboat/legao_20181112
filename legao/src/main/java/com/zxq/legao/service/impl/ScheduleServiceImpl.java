package com.zxq.legao.service.impl;


import com.zxq.legao.dao.ScheduleDao;
import com.zxq.legao.entity.po.SchedulePO;
import com.zxq.legao.entity.vo.ScheduleVO;
import com.zxq.legao.service.ScheduleService;
import com.zxq.legao.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author dengzhenxiang
 * @since 2018-11-27
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleDao scheduleDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSchedule(SchedulePO schedulePO) {
        //计算星期
        int week = DateUtil.getWeek(schedulePO.getCourseDate());
        schedulePO.setCourseWeek(String.valueOf(week));
        return scheduleDao.insertSchedule(schedulePO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteSchedule(Integer scheduleID) {
        return scheduleDao.deleteSchedule(scheduleID);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateSchedule(SchedulePO schedulePO) {
        return scheduleDao.updateSchedule(schedulePO);
    }

    @Override
    public String selectSchedule( SchedulePO schedulePO, HttpServletRequest request) {

        return "schedule/scheduleList";
    }

    @Override
    public ScheduleVO selectScheduleByID(Integer scheduleID) {
        return scheduleDao.selectScheduleByID(scheduleID);
    }
}
