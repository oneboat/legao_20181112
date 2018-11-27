package com.zxq.legao.entity;


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

public class Classroom implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 课室
     */
    private String name;

    private String ageArea;

    private String responsePersonName;


    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String AGEAREA = "ageArea";

    public static final String RESPONSEPERSONNAME = "responsePersonName";

}
