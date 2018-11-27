package com.zxq.legao.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployVO implements Serializable {
	private Integer id;
	private String name;
	private String telphone;
	private String sex;
	private Date birthday;
	private Date entryDate;
	private String basicSalary;
	private String fullWork;
	private String EatAllow;
	private String classPay;
	private Integer allClassTime;
	private String extraPay;
	private String area;
	private Integer status;
	private DeptVO deptVO;
	private JobVO jobVO;

}
