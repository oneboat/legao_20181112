package com.zxq.legao.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassPO implements Serializable {
	private Integer id;
	private String name;
	private Integer teacherID;
	private Date createDate;

}
