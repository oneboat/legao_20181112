package com.zxq.legao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxq.legao.dao.SchoolAreaDao;
import com.zxq.legao.entity.po.SchoolAreaPO;
import com.zxq.legao.entity.vo.SchoolAreaVO;
import com.zxq.legao.entity.vo.SchoolAreaVO;
import com.zxq.legao.service.SchoolAreaService;
import com.zxq.legao.util.ConstUtil;
import com.zxq.legao.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class SchoolAreaServiceImpl implements SchoolAreaService {
    @Autowired
    private SchoolAreaDao schoolAreaDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSchoolArea(SchoolAreaPO schoolAreaPO) {
        return schoolAreaDao.insertSchoolArea(schoolAreaPO);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteSchoolArea(List<Integer> schoolAreaIDs) {
        return schoolAreaDao.deleteSchoolArea(schoolAreaIDs);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateSchoolArea(SchoolAreaPO schoolAreaPO) {
        return schoolAreaDao.updateSchoolArea(schoolAreaPO);
    }

    @Override
    public String selectSchoolArea(Integer page, SchoolAreaPO schoolAreaPO, HttpServletRequest request) {
        //模糊查询保留值
        if (schoolAreaPO != null) {
            request.setAttribute("blurSchoolArea", schoolAreaPO);
        }
        if (page == null) {
            page = 0;
        }
        //page为初始页，pageSize表一页显示多少条
        PageHelper.startPage(page, ConstUtil.PAGESIZE);
        List<SchoolAreaVO> list = schoolAreaDao.selectSchoolArea(schoolAreaPO);

        PageInfo pageInfo = new PageInfo(list);
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("schoolAreaVOList", list);
        return "schoolArea/schoolAreaList";
    }

    @Override
    public List<SchoolAreaVO> findAllSchoolAreaName(SchoolAreaPO schoolArea) {
        return schoolAreaDao.selectSchoolArea(schoolArea);
    }

    @Override
    public SchoolAreaVO selectSchoolAreaByID(Integer schoolAreaID) {
        return schoolAreaDao.selectSchoolAreaByID(schoolAreaID);
    }
}
