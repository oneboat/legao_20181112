package com.zxq.legao.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchedulePO {
    private  Integer id;
    private  Integer schoolAreaID;
    private  Integer dateID;
    private  String teacherName;
    private  Integer courseID;
    private  Integer classRoomID;
    private  String studentName;
    private String className;
}
