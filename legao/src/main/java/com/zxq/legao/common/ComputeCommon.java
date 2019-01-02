package com.zxq.legao.common;

import com.zxq.legao.entity.po.SchedulePO;
import com.zxq.legao.util.DateUtil;

import java.util.List;

public class ComputeCommon {
    /**
     * 计算星期
     */
    public static SchedulePO computeWeek(SchedulePO schedulePO){
        List<Integer> dateList = DateUtil.getWeek(schedulePO.getCourseDate());
        schedulePO.setCourseWeek(String.valueOf(dateList.get(0)));
        schedulePO.setWeekOfYear(String.valueOf(dateList.get(1)));
        return schedulePO;
    }
}
