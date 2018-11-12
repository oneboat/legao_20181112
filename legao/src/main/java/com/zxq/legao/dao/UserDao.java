package com.zxq.legao.dao;

import com.zxq.legao.entity.po.UserPO;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

public interface UserDao {
	int insertUser(UserPO userPO);

	int deleteUser(List<Integer> userIDs);

	int updateUser(UserPO userPO);

	List<UserPO> selectUser(UserPO userPO);

	UserPO selectUserByID(UserPO userPO);
}
