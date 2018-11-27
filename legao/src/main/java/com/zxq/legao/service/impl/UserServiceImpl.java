package com.zxq.legao.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import org.springframework.transaction.annotation.Transactional;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserServiceImpl  implements UserService  {
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDao userDao;

	@Override
	@Transactional()
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
	@Transactional()
	public int deleteUser(List<Integer> userIDs) {
		return userDao.deleteUser(userIDs);
	}

	@Override
	@Transactional()
	public int updateUser(UserPO userPO) {
		return userDao.updateUser(userPO);
	}

	@Override
	public String selectUser(Integer page,UserPO userPO,HttpServletRequest request) {
		//模糊查询保留值
		if (userPO!=null){
			if (userPO.getUsername()!=null|| userPO.getStatus()!=null)
			request.setAttribute("blurUser",userPO);
		}
		if (page == null){ page = 0;}
		//page为初始页，pageSize表一页显示多少条
		PageHelper.startPage(page,ConstUtil.PAGESIZE);
		List<UserVO> list =userDao.selectUser(userPO);
		PageInfo pageInfo = new PageInfo(list);
		request.setAttribute("pageInfo",pageInfo);
		request.setAttribute("userVOList",list);
		return "user/userList";
	}


	@Override
	public List<UserVO> findUsername(UserPO userPO) {
		if (userPO == null || userPO.toString().equals("")){
			logger.info("UserPO为空");
			return null;
		}else {
			return userDao.findUsername(userPO);
		}

	}

	@Override
	public boolean isDeleteItself(Integer[] caption,Integer userID) {
		boolean flag = false;
		for (int i = 0; i < caption.length; i++) {
			if(caption[i].equals(userID)){
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public UserVO selectUserByID(Integer userID) {
		return userDao.selectUserByID(userID);
	}

	@Override
	public UserVO selectFieldsByUserID(Integer userID) {
		return userDao.selectFieldsByUserID(userID);
	}

	@Override
	public UserVO selectUserByNameAndPass(UserPO userPO) {
		if (userPO == null || userPO.toString().equals("")){
			logger.info("UserPO为空");
			return null;
		}else {
			String saltDB = (new ConstUtil()).MD5_SALT;
			userPO.setPassword(MD5Util.inputPassToDBpass(userPO.getPassword(),saltDB));
			return userDao.selectUserByNameAndPass(userPO);
		}
	}
}
