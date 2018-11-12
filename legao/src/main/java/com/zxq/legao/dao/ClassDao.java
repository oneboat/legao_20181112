package com.zxq.legao.dao;

import com.zxq.legao.entity.po.ClassPO;

import java.util.List;

public interface ClassDao {

	int insertClass(ClassPO ClassPO);

	int deleteClass(List<Integer> ClassIDs);

	int updateClass(ClassPO ClassPO);

	List<ClassPO> selectClass(ClassPO ClassPO);

	ClassPO selectClassByID(ClassPO ClassPO);

}