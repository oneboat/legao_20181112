package com.zxq.legao.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentVO implements Serializable {
	private Integer id;
	private String name;
	private String telphone;
	private String sex;
	private Integer qqNum;
	private String education;
	private Date createDate;
	private Date birthday;
	private ClassVO classVO;//学生选择的课程信息

}