package com.zxq.legao.dao;

import com.zxq.legao.entity.po.UserPO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {
	UserVO findUserByNameAndPass(UserPO user);
}
