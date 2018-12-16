package com.zxq.legao.entity.po;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ClassRoomPO implements Serializable {
    private Integer id;
    private String name;
    private String ageArea;
    private String responsePersonName;

}
