package com.zxq.legao.service;

import com.zxq.legao.entity.po.UserPO;
import com.zxq.legao.entity.vo.UserVO;
import org.springframework.stereotype.Service;


public interface LoginService {
	UserVO findUserByNameAndPass (UserPO user);
}
