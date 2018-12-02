package com.zxq.legao.dao;

import com.zxq.legao.entity.po.FollowPO;
import com.zxq.legao.entity.vo.FollowVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FollowDao {
	int insertFollow(FollowPO followPO);
	int deleteFollow(List<Integer> followIDs);
	int updateFollow(FollowPO followPO);
	List<FollowPO> selectFollow(FollowPO followPO);
	FollowPO selectFollowByID(Integer followID);
	List<FollowVO> findAllFollowName();
}
