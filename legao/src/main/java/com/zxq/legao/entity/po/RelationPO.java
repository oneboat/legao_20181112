package com.zxq.legao.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Description:
 * <p>
 *   对应关系
 * </p>
 * @author dengzhenxiang
 * @Date 2018/12/28 22:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelationPO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Integer id;

    /**
     * 校区id
     */
    private Integer scheduleID;

    /**
     * 学生id
     */
    private Integer studentID;

    /**
     * 签到状态：1准时，2未签到，3请假
     */
    private Integer signInStatus;

    /**
     * 接受页面选中的caption
     */
    private List<Integer> caption;
}
