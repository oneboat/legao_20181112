package com.zxq.legao.service.impl;

import com.zxq.legao.dao.LoginDao;
import com.zxq.legao.entity.po.UserPO;
import com.zxq.legao.service.LoginServie;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServieImpl implements LoginServie {

	@Autowired
	private LoginDao loginDao;

	@Override
	public UserPO  findUserByNameAndPass(UserPO  user) {
		return loginDao.findUserByNameAndPass(user);
	}
}
