package com.zxq.legao.entity.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleVO {
    private  Integer id;
    private  SchoolAreaVO schoolArea;
    private  DateVO  date;
    private CourseVO course;
    private ClassRoomVO classroom;
    private List<ScheduleVO> student;
    private Date courseDate;
    private  EmployVO teacherVO;
    private String courseWeek;
    private String weekOfYear;
    private SeriesVO series;
    /**
     * 学生总人数
     */
    private Integer totalStu;


}
