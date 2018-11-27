package com.zxq.legao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxq.legao.dao.FollowDao;
import com.zxq.legao.entity.po.FollowPO;
import com.zxq.legao.entity.vo.FollowVO;
import com.zxq.legao.entity.vo.FollowVO;
import com.zxq.legao.service.FollowService;
import com.zxq.legao.util.ConstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Service
public class FollowServiceImpl implements FollowService {
	@Autowired
	private FollowDao followDao;
	@Override
	public int insertFollow(FollowPO followPO) {
		return followDao.insertFollow(followPO);
	}

	@Override
	public int deleteFollow(List<Integer> followIDs) {
		return followDao.deleteFollow(followIDs);
	}

	@Override
	public int updateFollow(FollowPO followPO) {
		return followDao.updateFollow(followPO);
	}

	@Override
	public String selectFollow(Integer page, FollowPO followPO, HttpServletRequest request) {
		//模糊查询保留值
		if (followPO!=null){
			request.setAttribute("blurFollow",followPO);
		}
		if (page == null){ page = 0;}
		//page为初始页，pageSize表一页显示多少条
		PageHelper.startPage(page, ConstUtil.PAGESIZE);
		List<FollowVO> list = followDao.selectFollow(followPO);

		PageInfo pageInfo = new PageInfo(list);
		request.setAttribute("pageInfo",pageInfo);
		request.setAttribute("followVOList",list);
		return "follow/followList";
	}

	@Override
	public List<FollowVO> findAllFollowName(FollowPO follow) {
		return followDao.selectFollow(follow);
	}

	@Override
	public FollowVO selectFollowByID(Integer followID) {
		return null;
	}
}
