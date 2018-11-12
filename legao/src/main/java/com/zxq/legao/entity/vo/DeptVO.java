package com.zxq.legao.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptVO implements Serializable {
	private Integer id;
	private String name;
	private String remark;//部门职能
	private Date createDate;
	private Integer deptAllNum;//部门人数


}
