package com.zxq.legao.dao;


import com.zxq.legao.entity.po.DeptPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DeptDao {
	int insertDept(DeptPO deptPO);

	int deleteDept(List<Integer> deptIDs);

	int updateDept(DeptPO deptPO);

	List<DeptPO> selectDept(DeptPO deptPO);

}