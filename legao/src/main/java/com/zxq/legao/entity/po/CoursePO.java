package com.zxq.legao.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoursePO implements Serializable {
	private Integer id;
	private String name;
	private String remark;
	private Integer score;
	private Integer studentID;
	private Integer studentNumLimit;
	private Integer teacherID;
	private Date createDate;

}
