package com.zxq.legao.service;

import com.zxq.legao.entity.po.UserPO;
import com.zxq.legao.entity.vo.UserVO;

import java.util.List;

public interface UserService {
	int insertUser(UserPO userPO);

	int deleteUser(List<Integer> userIDs);

	int updateUser(UserPO userPO);

	List<UserVO> selectUser(UserPO userPO);

	UserVO selectUserByID(UserPO userPO);
}
