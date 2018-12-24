package com.zxq.legao.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelationPO implements Serializable {
    private Integer id;
    private Integer scheduleID;
    private Integer studentID;
    private Integer signInStatus;
}
