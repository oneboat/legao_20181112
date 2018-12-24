package com.zxq.legao.dao;

import com.zxq.legao.entity.po.RelationPO;
import com.zxq.legao.entity.vo.RelationVO;

import java.util.List;

public interface RelationDao {
    int insertRelation(RelationPO relationPO);

    int deleteRelation(Integer relationID);

    int updateRelation(RelationPO relationPO);

    List<RelationVO> selectRelation(RelationPO relationPO);

    RelationVO selectRelationByID(Integer relationID);
}
