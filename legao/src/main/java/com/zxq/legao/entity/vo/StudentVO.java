package com.zxq.legao.entity.vo;

import com.zxq.legao.entity.po.FollowPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentVO implements Serializable {
	private Integer id;
	private String nickName;
	private String name;
	private String parentName;
	private String parentRelat;
	private String sex;
	private String telphone;
	private String weChatID;
	private String education;
	private Date birthday ;
	private Date createDate;
	private String sparePhone;
	private String markPeople;
	private String advisor;
	private String area;
	private Date willDate ;
	private String baseSituation;
	private Integer status;
	private String source;
	private Integer importanceGrade;
	private String teacherName ;
	private SchoolAreaVO schoolAreaID;
	private FollowPO followID;
	private String age;
	private List<String> selectFields;


}
