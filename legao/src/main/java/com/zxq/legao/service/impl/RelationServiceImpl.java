package com.zxq.legao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxq.legao.dao.ContractDao;
import com.zxq.legao.dao.EmployDao;
import com.zxq.legao.dao.RelationDao;
import com.zxq.legao.entity.po.ContractPO;
import com.zxq.legao.entity.po.RelationPO;
import com.zxq.legao.entity.vo.EmployVO;
import com.zxq.legao.entity.vo.RelationVO;
import com.zxq.legao.service.RelationService;
import com.zxq.legao.util.ConstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RelationServiceImpl implements RelationService {

    @Autowired
    private RelationDao relationDao;
    @Autowired
    private EmployDao employDao;
    @Autowired
    private ContractDao contractDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertRelation(RelationPO relationPO) {
        return relationDao.insertRelation(relationPO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteRelation(List<Integer> relationIDs) {

        return relationDao.deleteRelation(relationIDs);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateRelation(RelationPO relationPO) {
        return relationDao.updateRelation(relationPO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateBatchRelation(RelationPO relationPO) {

        List<Integer> caption = relationPO.getCaption();
        if (caption.get(0) == null) {
            caption.remove(0);
        }
        int captionSize = caption.size();
        if (relationPO.getSignInStatus() == 1) {
            //计算老师和学生的课时，老师加课时，学生减课时
            EmployVO employVO = employDao.selectEmployById(relationPO.getTeacherID());
            String teacherTime = relationPO.getCaption().size() * Float.valueOf(relationPO.getClassTimes()) + Float.valueOf(employVO.getAllClassTime()) +"";
            employVO.setAllClassTime(teacherTime);
            employDao.updateAllClassTime(employVO);

            //学生减课时 批量签到
            ContractPO contractPO = null;
            String temClassTime = null;
            RelationPO relationPOByID = null;
            for (int i = 0; i < captionSize; i++) {
                relationPOByID = relationDao.selectRelationByID(relationPO.getCaption().get(i));
                contractPO = contractDao.selectContractByStudentId(relationPOByID.getStudentID());
                if (contractPO != null) {
                    temClassTime = Float.valueOf(contractPO.getRemainClassTime()) - Float.valueOf(1 * relationPO.getClassTimes()) +"";
                    contractPO.setRemainClassTime(temClassTime);
                    contractDao.updateRemainClassTime(contractPO);
                    relationDao.updateBatchRelation(relationPO, relationPO.getCaption().get(i));
                }
            }
        } else {
            for (int i = 0; i < captionSize; i++) {
                relationDao.updateBatchRelation(relationPO, relationPO.getCaption().get(i));
            }
        }
        return 2;
    }

    @Override
    public String selectRelation(Integer page, RelationPO relationPO, HttpServletRequest request) {
        //模糊查询保留值
        if (relationPO != null) {
            request.setAttribute("blurRelation", relationPO);
        }
        if (page == null) {
            page = 0;
        }
        //page为初始页，pageSize表一页显示多少条
        PageHelper.startPage(page, ConstUtil.PAGESIZE);
        List<RelationVO> list = relationDao.selectRelation(relationPO);


        //按周数来查
        if ((relationPO.getWeekOfYear() != null) && (!relationPO.getWeekOfYear().equals(""))) {
            list = list.stream().filter((RelationVO r) -> r.getSchedule() !=null).collect(Collectors.toList());
            list = list.stream().filter((RelationVO r) -> r.getSchedule().getWeekOfYear().equals(relationPO.getWeekOfYear())).collect(Collectors.toList());
        }

        //按老师来查
        if ((relationPO.getTeacherID() != null) && (!relationPO.getTeacherID().equals(""))) {
            list =list.stream().filter((RelationVO r) -> r.getSchedule() !=null).collect(Collectors.toList());
            list =list.stream().filter((RelationVO r) -> r.getSchedule().getTeacherVO() !=null).collect(Collectors.toList());
            list =list.stream().filter((RelationVO r) -> r.getSchedule().getTeacherVO().getId().equals(relationPO.getTeacherID())).collect(Collectors.toList());

        }
        //按时间段来查
        if ((relationPO.getTimeSection() != null) && (!relationPO.getTimeSection().equals(""))) {
            list = list.stream().filter((RelationVO r) -> r.getSchedule() !=null).collect(Collectors.toList());
            list =  list.stream().filter((RelationVO r) -> r.getSchedule().getDate() !=null).collect(Collectors.toList());
            list = list.stream().filter((RelationVO r) -> r.getSchedule().getDate().getTimeSection().equals(relationPO.getTimeSection())).collect(Collectors.toList());
        }


        PageInfo pageInfo = new PageInfo(list);
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("relationVOList", list);
        return "relation/relationList";

    }

    @Override
    public List<RelationVO> selectRelationByScheduleID(Integer scheduleID) {
        return relationDao.selectRelationByScheduleID(scheduleID);
    }
}
