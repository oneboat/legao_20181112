package com.zxq.legao.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class DocPO implements Serializable {
	private Integer id;
	private String title;
	private String fileName;
	private String remark;
	private Date createDate;
	private Integer userID;


}
