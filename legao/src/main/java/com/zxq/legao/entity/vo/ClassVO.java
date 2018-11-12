package com.zxq.legao.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassVO implements Serializable {
	private Integer id;
	private String name;
	private String remark;
	private Date createDate;
	private TeacherVO teacherVO;//班主任信息
	private Integer classAllNum;//班级总人数


}
