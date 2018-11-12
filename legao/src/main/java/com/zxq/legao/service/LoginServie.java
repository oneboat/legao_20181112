package com.zxq.legao.service;

import com.zxq.legao.entity.po.UserPO;
import org.springframework.stereotype.Service;


public interface LoginServie {
	UserPO  findUserByNameAndPass (UserPO user);
}
