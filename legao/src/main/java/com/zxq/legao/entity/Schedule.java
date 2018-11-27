package com.zxq.legao.entity;



;
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
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 校区
     */
    private String schoolName;

    private Date DateID;

    private String teacherName;

    /**
     * 关联到课程系列表legao_courseSeries
     */
    private Integer courseSeriesID;

    /**
     * 关联到课程内容表courseContent
     */
    private Integer courseContentID;

    /**
     * 关联到课室表classRoom
     */
    private Integer classRoomID;

    private String studentName;


    public static final String ID = "id";

    public static final String SCHOOLNAME = "schoolName";

    public static final String DATEID = "DateID";

    public static final String TEACHERNAME = "teacherName";

    public static final String COURSESERIESID = "courseSeriesID";

    public static final String COURSECONTENTID = "courseContentID";

    public static final String CLASSROOMID = "classRoomID";

    public static final String STUDENTNAME = "studentName";

}
