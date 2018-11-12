package com.zxq.legao.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseVO implements Serializable {
	private Integer id;
	private String name;
	private String remark;
	private Integer score;
	private StudentVO studentVO;
	private Integer studentNumLimit;
	private TeacherVO teacherVO;//带课老师信息
	private Date createDate;
	private Integer studentNum;//已经报名课程人数


}
