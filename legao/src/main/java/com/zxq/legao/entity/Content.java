package com.zxq.legao.entity;

import java.time.LocalDateTime;

import java.io.Serializable;
import java.util.Date;

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

public class Content implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 课程系列id
     */

    private Integer courseSeriesID;

    /**
     * 年龄段
     */

    private String ageArea;

    /**
     * 课时
     */

    private Date courseTime;

    /**
     * 学生id,查出总人数
     */

    private Integer studentID;


    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String COURSESERIESID = "courseSeriesID";

    public static final String AGEAREA = "ageArea";

    public static final String COURSETIME = "courseTime";

    public static final String STUDENTID = "studentID";

}
