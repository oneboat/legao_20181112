package com.zxq.legao.entity.po;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DatePO {
    private Integer id;
    private String dateTime;
    private String week;
}
