package com.zxq.legao.service.impl;


import com.zxq.legao.common.ComputeCommon;
import com.zxq.legao.dao.RelationDao;
import com.zxq.legao.dao.ScheduleDao;
import com.zxq.legao.entity.po.SchedulePO;
import com.zxq.legao.entity.vo.DateVO;
import com.zxq.legao.entity.vo.ScheduleVO;
import com.zxq.legao.service.ScheduleService;
import com.zxq.legao.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    @Autowired
    private RelationDao relationDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSchedule(SchedulePO schedulePO) {
        //计算星期
        ComputeCommon.computeWeek(schedulePO);
        //添加排课的同时，添加签到信息
        int flag = scheduleDao.insertSchedule(schedulePO);
        relationDao.insertBatchRelation(schedulePO.getStudentList(), schedulePO);
        return flag;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteSchedule(List<Integer> scheduleIDs) {
        return scheduleDao.deleteSchedule(scheduleIDs);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateSchedule(SchedulePO schedulePO) {
        ComputeCommon.computeWeek(schedulePO);
        return scheduleDao.updateSchedule(schedulePO);
    }

    @Override
    public String selectSchedule(SchedulePO schedulePO, HttpServletRequest request) {
        List<ScheduleVO> scheduleVOList = scheduleDao.selectSchedule(schedulePO);
        DateVO dateVO = new DateVO();
        if (scheduleVOList.size() != 0) {
            //取第一条设置本周的起始时间
            ScheduleVO scheduleVO = scheduleVOList.get(0);
            List<String> startAndEndWeekDateList = DateUtil.getStartAndEndWeekDate(scheduleVO.getCourseDate());
            String startWeekDate = startAndEndWeekDateList.get(0);
            String endWeekDate = startAndEndWeekDateList.get(1);
            dateVO.setWeekOfYear(scheduleVO.getWeekOfYear());
            dateVO.setStartWeekDate(startWeekDate);
            dateVO.setEndWeekDate(endWeekDate);

            //得出每个课程的总人数，方案有待改善
            int scheListSize = scheduleVOList.size();
            for (int i = 0; i < scheListSize; i++) {
                ScheduleVO scheduleVOs = scheduleVOList.get(i);
                int totalCount = relationDao.selectStuTotalByScheID(scheduleVOs.getId());
                scheduleVOs.setTotalStu(totalCount);
            }
        }
        request.setAttribute("scheduleVOList", scheduleVOList);
        request.setAttribute("dateVO", dateVO);
        return "schedule/scheduleList";
    }

    @Override
    public ScheduleVO selectScheduleByID(Integer scheduleID) {
        return scheduleDao.selectScheduleByID(scheduleID);
    }

    @Override
    public List<ScheduleVO> findAllweekOfYear() {
        return scheduleDao.findAllweekOfYear();
    }
}
