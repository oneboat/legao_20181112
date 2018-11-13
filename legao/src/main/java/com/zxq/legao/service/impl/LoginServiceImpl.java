package com.zxq.legao.service.impl;

import com.zxq.legao.dao.LoginDao;
import com.zxq.legao.entity.po.UserPO;
import com.zxq.legao.entity.vo.UserVO;
import com.zxq.legao.service.LoginService;
import com.zxq.legao.util.ConstUtil;
import com.zxq.legao.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
	private Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	@Autowired
	private LoginDao loginDao;

	@Override
	public UserVO findUserByNameAndPass(UserPO userPO) {
		if (userPO == null || userPO.toString().equals("")){
			logger.info("UserPO为空");
			return null;
		}else {
			String saltDB = (new ConstUtil()).MD5_SALT;
			userPO.setPassword(MD5Util.inputPassToDBpass(userPO.getPassword(),saltDB));
			return loginDao.findUserByNameAndPass(userPO);
		}
	}
}
