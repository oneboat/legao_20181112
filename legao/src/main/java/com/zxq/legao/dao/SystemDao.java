package com.zxq.legao.dao;

import org.apache.ibatis.annotations.Param;

public interface SystemDao {
	int updateFieldsSet(@Param(value = "fieldList") String fieldList, @Param(value = "userId") Integer userId);
}
