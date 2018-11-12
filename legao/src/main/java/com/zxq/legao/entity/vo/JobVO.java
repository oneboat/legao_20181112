package com.zxq.legao.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.omg.PortableInterceptor.INACTIVE;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobVO implements Serializable {
	private Integer id;
	private String name;
	private String remark;
	private Date createDate;
	private Integer jobAllNum;// 获得该职称总人数

}