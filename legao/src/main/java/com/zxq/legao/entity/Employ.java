package com.zxq.legao.entity;


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

public class Employ implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    private String name;

    private String sex;

    private String telphone;

    private Date birthday;

    /**
     * 入职日期
     */

    private Date entryDate;

    /**
     * 关联legao_job表
     */

    private Integer jobID;

    /**
     * 基本工资
     */

    private String basicSalary;

    /**
     * 是否全勤
     */

    private String fullWork;

    /**
     * 餐补
     */

    private String EatAllow;

    /**
     * 课时费
     */

    private String classPay;

    /**
     * 总课时
     */

    private Integer allClassTime;

    /**
     * 提成
     */

    private String extraPay;

    /**
     * 校区
     */
    private String area;

    private Integer status;


    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String SEX = "sex";

    public static final String TELPHONE = "telphone";

    public static final String BIRTHDAY = "birthday";

    public static final String ENTRYDATE = "entryDate";

    public static final String JOBID = "jobID";

    public static final String BASICSALARY = "basicSalary";

    public static final String FULLWORK = "fullWork";

    public static final String EATALLOW = "EatAllow";

    public static final String CLASSPAY = "classPay";

    public static final String ALLCLASSTIME = "allClassTime";

    public static final String EXTRAPAY = "extraPay";

    public static final String AREA = "area";

    public static final String STATUS = "status";

}
