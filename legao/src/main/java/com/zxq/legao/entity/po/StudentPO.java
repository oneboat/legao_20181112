package com.zxq.legao.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentPO implements Serializable {
	private Integer id;
	private String nickName;
	private String name;
	private String parentName;
	private String parentRelat;
	private String sex;
	private String telphone;
	private String weChatID;
	private String education;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate;
	private String sparePhone;
	private String markPeople;
	private String advisor;
	private String area;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date willDate;
	private String baseSituation;
	private Integer status;
	private String source;
	private Integer importanceGrade;
	private String teacherName;
	private Integer schoolAreaID;
	private Integer followID;
	//排序字段
	private String ifImportanceGradeOrder;



}
