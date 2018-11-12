package com.zxq.legao.dao;


import com.zxq.legao.entity.po.DeptPO;

import java.util.List;

public interface DeptDao {
	int insertDept(DeptPO deptPO);

	int deleteDept(List<Integer> deptIDs);

	int updateDept(DeptPO deptPO);

	List<DeptPO> selectDept(DeptPO deptPO);

}