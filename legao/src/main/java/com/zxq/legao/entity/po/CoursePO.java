package com.zxq.legao.entity.po;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CoursePO {
    private Integer id;
    private String name;
    private String ageArea;
    private String teacherTools;
    private String courseTime;
    private Integer classRoomID;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;


}
