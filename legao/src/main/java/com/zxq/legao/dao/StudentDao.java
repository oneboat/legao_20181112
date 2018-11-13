package com.zxq.legao.dao;

import com.zxq.legao.entity.po.StudentPO;
import com.zxq.legao.entity.vo.StudentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface StudentDao {
	int insertStudent(StudentPO studentPO);
	int deleteStudent(List<Integer> studentIDs);
	int updateStudent(StudentPO studentPO);
	List<StudentVO> selectStudent(StudentPO studentPO);
	StudentVO selectStudentByID(StudentPO studentPO);
}
