package com.zxq.legao.service.impl;

import com.zxq.legao.dao.SystemDao;
import com.zxq.legao.dao.UserDao;
import com.zxq.legao.service.SystemService;
import com.zxq.legao.util.ConverstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SystemServiceImpl implements SystemService {
	@Autowired
	private SystemDao systemDao;

	@Transactional
	@Override
	public int updateFieldsSet(String fieldList,Integer userId) {

		return systemDao.updateFieldsSet(fieldList,userId);
	}
}
