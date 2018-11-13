package com.zxq.legao.service.impl;

import com.zxq.legao.dao.UserDao;
import com.zxq.legao.entity.po.UserPO;
import com.zxq.legao.entity.vo.UserVO;
import com.zxq.legao.service.UserService;
import com.zxq.legao.util.ConstUtil;
import com.zxq.legao.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDao userDao;

	@Override
	public int insertUser(UserPO userPO) {
		if (userPO == null || userPO.toString().equals("")){
			logger.info("UserPO为空");
			return 0;
		}else {
			String saltDB = (new ConstUtil()).MD5_SALT;
			userPO.setPassword(MD5Util.inputPassToDBpass(userPO.getPassword(),saltDB));
			return userDao.insertUser(userPO);
		}

	}

	@Override
	public int deleteUser(List<Integer> userIDs) {
		return userDao.deleteUser(userIDs);
	}

	@Override
	public int updateUser(UserPO userPO) {
		return userDao.updateUser(userPO);
	}

	@Override
	public List<UserVO> selectUser(UserPO userPO) {
		return userDao.selectUser(userPO);
	}

	@Override
	public UserVO selectUserByID(UserPO userPO) {
		return userDao.selectUserByID(userPO);
	}
}
