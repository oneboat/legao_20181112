package com.zxq.legao.dao;

import com.zxq.legao.entity.po.UserPO;
import com.zxq.legao.entity.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;
@Mapper
public interface UserDao {
	int insertUser(UserPO userPO);

	int deleteUser(List<Integer> userIDs);

	int updateUser(UserPO userPO);

	List<UserVO> selectUser(UserPO userPO);

	UserVO selectUserByID(UserPO userPO);
}
