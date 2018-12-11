package com.zxq.legao.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowPO implements Serializable {
    private Integer id;
    private String studentName;
    private String advisor;
    private Date date;
    private String mode;
    private String content;


}
