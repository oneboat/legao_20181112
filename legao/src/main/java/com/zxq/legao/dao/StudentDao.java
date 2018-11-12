package com.zxq.legao.dao;

import com.zxq.legao.entity.po.StudentPO;
import com.zxq.legao.entity.vo.StudentVO;

import java.util.List;

public interface StudentDao {
	int insertStudent(StudentPO studentPO);
	int deleteStudent(List<Integer> studentIDs);
	int updateStudent(StudentPO studentPO);
	List<StudentVO> selectStudent(StudentPO studentPO);
	StudentVO selectStudentByID(StudentPO studentPO);
}
