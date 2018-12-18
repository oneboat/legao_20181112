package com.zxq.legao.service.impl;


import com.zxq.legao.dao.ScheduleDao;
import com.zxq.legao.entity.po.SchedulePO;
import com.zxq.legao.entity.vo.ScheduleVO;
import com.zxq.legao.service.ScheduleService;
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
        return scheduleDao.insertSchedule(schedulePO);
    }

    @Override
    public int deleteSchedule(Integer scheduleID) {
        return scheduleDao.deleteSchedule(scheduleID);
    }

    @Override
    public int updateSchedule(SchedulePO schedulePO) {
        return scheduleDao.updateSchedule(schedulePO);
    }

    @Override
    public String selectSchedule(Integer page, SchedulePO schedulePO, HttpServletRequest request) {

        return null;
    }

    @Override
    public ScheduleVO selectScheduleByID(Integer scheduleID) {
        return scheduleDao.selectScheduleByID(scheduleID);
    }
}
