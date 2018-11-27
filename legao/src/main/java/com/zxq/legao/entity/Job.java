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

public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String remark;


    private Date createDate;


    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String REMARK = "remark";

    public static final String CREATEDATE = "createDate";

}
