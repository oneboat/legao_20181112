package com.zxq.legao.dao;

import com.zxq.legao.entity.po.CoursePO;

import java.util.List;

public interface CourseDao {
	int insertCourse(CoursePO coursePO);

	int deleteCourse(List<Integer> courseIDs);

	int updateCourse(CoursePO coursePO);

	List<CoursePO> selectCourse(CoursePO coursePO);

	CoursePO selectCourseByID(CoursePO coursePO);
}