package com.zxq.legao.dao;


import com.zxq.legao.entity.po.SchedulePO;
import com.zxq.legao.entity.vo.ScheduleVO;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author dengzhenxiang
 * @since 2018-11-27
 */
public interface ScheduleDao {
    int insertSchedule(SchedulePO schedulePO);

    int deleteSchedule(List<Integer> scheduleIDs);

    int updateSchedule(SchedulePO schedulePO);

    List<ScheduleVO> selectSchedule(SchedulePO schedulePO);

    ScheduleVO selectScheduleByID(Integer scheduleID);

    List<ScheduleVO> findAllweekOfYear();

}
