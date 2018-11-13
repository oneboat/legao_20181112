package com.zxq.legao.dao;

import com.zxq.legao.entity.po.TeacherPO;
import com.zxq.legao.entity.vo.TeacherVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TeacherDao {
	int insertTeacher(TeacherPO teacherPO);
	int deleteTeacher(List<Integer> teacherIDs);
	int updateTeacher(TeacherPO teacherPO);
	List<TeacherVO> selectTeacher(TeacherPO teacherPO);
	TeacherVO selectTeacherByID(TeacherPO teacherPO);
}