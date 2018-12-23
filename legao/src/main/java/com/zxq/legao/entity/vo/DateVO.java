package com.zxq.legao.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DateVO {
    private Integer id;
    private Integer status;
    private String timeSection;
    private String remark;
}
