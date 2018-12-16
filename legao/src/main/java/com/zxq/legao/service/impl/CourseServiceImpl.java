package com.zxq.legao.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxq.legao.dao.CourseDao;
import com.zxq.legao.dao.StudentDao;
import com.zxq.legao.entity.po.CoursePO;
import com.zxq.legao.entity.vo.CourseVO;
import com.zxq.legao.service.CourseService;
import com.zxq.legao.util.ConstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author dengzhenxiang
 * @since 2018-11-27
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

    @Autowired
    private StudentDao studentDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertCourse(CoursePO coursePO) {
        return courseDao.insertCourse(coursePO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteCourse(List<Integer> courseIDs) {
        return courseDao.deleteCourse(courseIDs);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateCourse(CoursePO coursePO) {
        return courseDao.updateCourse(coursePO);
    }

    @Override
    public String selectCourse(Integer page, CoursePO coursePO, HttpServletRequest request) {
        //模糊查询保留值
        if (coursePO != null) {
            request.setAttribute("blurCourse", coursePO);
        }
        if (page == null) {
            page = 0;
        }
        //page为初始页，pageSize表一页显示多少条
        PageHelper.startPage(page, ConstUtil.PAGESIZE);
        List<CourseVO> list = courseDao.selectCourse(coursePO);
        if (list.size()>0){
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setStudentNum(studentDao.selectCourseAllNum(list.get(i).getId()));
        }}
        PageInfo pageInfo = new PageInfo(list);
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("courseVOList", list);
        return "course/courseList";
    }


    @Override
    public CourseVO selectCourseByID(Integer courseID) {
        return courseDao.selectCourseByID(courseID);
    }

    @Override
    public List<CoursePO> findAllCourseName() {
        return courseDao.findAllCourseName();
    }
}
