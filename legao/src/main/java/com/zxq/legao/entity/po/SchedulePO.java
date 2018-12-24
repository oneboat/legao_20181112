package com.zxq.legao.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchedulePO implements Serializable {
    private Integer id;
    private Integer schoolAreaID;
    private Integer dateID;
    private Integer courseID;
    private Integer classroomID;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date courseDate;
    private String courseWeek;
    private String teacherName;
}
