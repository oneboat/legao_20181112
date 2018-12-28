package com.zxq.legao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxq.legao.dao.StudentDao;
import com.zxq.legao.dao.UserDao;
import com.zxq.legao.entity.po.StudentPO;
import com.zxq.legao.entity.vo.EmployVO;
import com.zxq.legao.entity.vo.StudentVO;
import com.zxq.legao.entity.vo.UserVO;
import com.zxq.legao.service.StudentService;
import com.zxq.legao.util.ConstUtil;
import com.zxq.legao.util.ConverstUtil;
import com.zxq.legao.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
/**
 * Description:
 * <p>
 *     用户前端控制器
 * </p>
 * @author dengzhenxiang
 * @Date 2018/11/11 17:41
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertStudent(StudentPO studentPO) {

        return studentDao.insertStudent(studentPO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteStudent(List<Integer> studentIDs) {
        return studentDao.deleteStudent(studentIDs);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateStudent(StudentPO studentPO) {
        return studentDao.updateStudent(studentPO);
    }

    @Override
    public String selectStudent(Integer page, StudentPO studentPO, HttpServletRequest request) {
        //模糊查询保留值
        if (studentPO != null) {
            request.setAttribute("blurStudent", studentPO);
        }
        if (page == null) {
            page = 0;
        }

        //查询当前登录用户选择展示的字段
        HttpSession session = request.getSession();
        UserVO userVO = (UserVO) session.getAttribute("user");
        String fields = userDao.selectFieldsByUserID(userVO.getId()).getSelectStudentFields();
        List<StudentVO> list = null;
        List<String> defaultStudentFieldsDB = Arrays.asList(ConstUtil.DEFAULT_STUDENT_FIELDS_DB);
        List<String> defaultStudentFieldsZH = Arrays.asList(ConstUtil.DEFAULT_STUDENT_FIELDS_ZH);
        List<String> studentFieldsDB = ConverstUtil.stringToList(fields, ConstUtil.STUDENT_FIELDS_DB);
        List<String> studentFieldsZH = ConverstUtil.stringToList(fields, ConstUtil.STUDENT_FIELDS_ZH);

        //page为初始页，pageSize表一页显示多少条
        PageHelper.startPage(page, ConstUtil.PAGESIZE);
        if (fields == null) {
            list = studentDao.selectStudent(studentPO, defaultStudentFieldsDB);
            request.setAttribute("FieldZH", defaultStudentFieldsZH);
        } else {
            list = studentDao.selectStudent(studentPO, studentFieldsDB);
            if (list.get(0).getBirthday() != null) {
                studentFieldsZH.add("年龄");
            }
            request.setAttribute("FieldZH", studentFieldsZH);
        }

        //计算年龄
        if (list.size() > 0 && list.get(0).getBirthday() != null) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getBirthday() != null) {
                    Date date = list.get(i).getBirthday();
                    String age = DateUtil.getAge(date);
                    list.get(i).setAge(age);
                }

            }
        }
        //给页面赋值
        PageInfo pageInfo = new PageInfo(list);
        request.setAttribute("studentVOList", list);
        request.setAttribute("pageInfo", pageInfo);
        return "student/studentList";
    }


    @Override
    public StudentVO selectStudentByID(Integer studentID) {
        return studentDao.selectStudentByID(studentID);
    }

    @Override
    public List<EmployVO> selectTeacherName() {
        return studentDao.selectTeacherName();
    }

    @Override
    public List<StudentVO> selectAllStudentName() {
        return studentDao.selectAllStudentName();
    }
}
