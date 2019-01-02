package com.zxq.legao.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelationVO {
    private Integer id;
    private ScheduleVO schedule;
    private StudentVO student;
    private Integer signInStatus;

}
