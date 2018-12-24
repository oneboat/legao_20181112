package com.zxq.legao.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelationVO {
    private Integer id;
    private SchoolAreaVO schedule;
    private StudentVO student;
    private Integer signInStatus;
}
