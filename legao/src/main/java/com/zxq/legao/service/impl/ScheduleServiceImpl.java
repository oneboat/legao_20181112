package com.zxq.legao.service.impl;


import com.zxq.legao.common.ComputeCommon;
import com.zxq.legao.dao.RelationDao;
import com.zxq.legao.dao.ScheduleDao;
import com.zxq.legao.dao.StudentDao;
import com.zxq.legao.entity.po.RelationPO;
import com.zxq.legao.entity.po.SchedulePO;
import com.zxq.legao.entity.po.StudentPO;
import com.zxq.legao.entity.vo.DateVO;
import com.zxq.legao.entity.vo.RelationVO;
import com.zxq.legao.entity.vo.ScheduleVO;
import com.zxq.legao.entity.vo.UserVO;
import com.zxq.legao.service.ScheduleService;
import com.zxq.legao.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Calendar;
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
    @Autowired
    private StudentDao studentDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSchedule(SchedulePO schedulePO,HttpServletRequest request) {
        //计算星期
        ComputeCommon.computeWeek(schedulePO);
        //添加排课的同时，添加签到信息
        int flag = scheduleDao.insertSchedule(schedulePO);
        UserVO userVO = (UserVO) request.getSession().getAttribute("user");
        schedulePO.setModifyPerson(userVO.getUsername());
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
    public int updateSchedule(SchedulePO schedulePO,HttpServletRequest request) {
        //更改签到表
        if (schedulePO.getStudentList()!=null){
           List<RelationVO> relationVOList = relationDao.selectRelationByScheduleID(schedulePO.getId());
           List<Integer> sudentList = new ArrayList<>();
           if (!relationVOList.isEmpty()){
               for (RelationVO re:relationVOList) {
                   sudentList.add(re.getId());
               }
               relationDao.deleteRelation(sudentList);
               UserVO userVO = (UserVO) request.getSession().getAttribute("user");
               schedulePO.setModifyPerson(userVO.getUsername());
               relationDao.insertBatchRelation(schedulePO.getStudentList(), schedulePO);
           }
        }
        ComputeCommon.computeWeek(schedulePO);
        return scheduleDao.updateSchedule(schedulePO);
    }

    @Override
    public String selectSchedule(SchedulePO schedulePO, HttpServletRequest request) {
        //模糊查询保留值
        if (schedulePO != null) {
            request.setAttribute("blurSchedule", schedulePO);
            if ((schedulePO.getWeekOfYear() ==null) || (schedulePO.getWeekOfYear().equals(""))){
                Calendar calendar = Calendar.getInstance();
                calendar.setFirstDayOfWeek(Calendar.MONDAY);
                calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
                schedulePO.setWeekOfYear(calendar.get(Calendar.WEEK_OF_YEAR)+"");
            }
        }

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

                //查询排课对应的每个学生
                List<RelationPO> relationPOlist = relationDao.selectStudentNumByschID(scheduleVOs.getId());
                StringBuilder stringBuilder = new StringBuilder();
                if (!relationPOlist.isEmpty()){
                    for (RelationPO relation : relationPOlist) {
                        StudentPO studentPO = studentDao.selectStudentNameByID(relation.getStudentID());
                        stringBuilder.append(studentPO.getName()+",");
                    }
                    scheduleVOList.get(i).setStudengNames(stringBuilder.deleteCharAt(stringBuilder.length()-1).toString());
                }
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
