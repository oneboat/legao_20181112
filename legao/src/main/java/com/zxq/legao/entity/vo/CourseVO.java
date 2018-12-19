package com.zxq.legao.entity.vo;

import com.zxq.legao.entity.po.ClassRoomPO;
import com.zxq.legao.entity.po.CoursePO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseVO {
    private Integer id;
    private String name;
    private String ageArea;
    private String teacherTools;
    private String courseTime;
    private SeriesVO series;
    /**
     * 学生总人数
     */
    private Integer studentNum;


}
