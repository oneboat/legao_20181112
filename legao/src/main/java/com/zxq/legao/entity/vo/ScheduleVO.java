package com.zxq.legao.entity.vo;


import com.zxq.legao.entity.po.DatePO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleVO {
    private  Integer id;
    private  SchoolAreaVO schoolArea;
    /**
     * Date实体只有po展示部分，没有前台vo
     */
    private  DatePO  datePO;
    private  String teacherName;
    private CourseVO courseVO;
    private ClassRoomVO classRoomVO;
    private  String studentNameVO;
    private String className;

}
