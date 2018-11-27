package com.zxq.legao.entity;


import java.time.LocalDateTime;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author dengzhenxiang
 * @since 2018-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class Series implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 年龄段
     */

    private String ageArea;

    /**
     * 教具
     */

    private String teacherTools;

    /**
     * 课时
     */

    private LocalDateTime courseTime;


    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String AGEAREA = "ageArea";

    public static final String TEACHERTOOLS = "teacherTools";

    public static final String COURSETIME = "courseTime";

}
