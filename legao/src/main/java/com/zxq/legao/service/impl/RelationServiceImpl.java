package com.zxq.legao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxq.legao.dao.RelationDao;
import com.zxq.legao.entity.po.RelationPO;
import com.zxq.legao.entity.vo.RelationVO;
import com.zxq.legao.service.RelationService;
import com.zxq.legao.util.ConstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Service
public class RelationServiceImpl implements RelationService {
    @Autowired
    private RelationDao relationDao;

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

       if (caption.get(0) == null){caption.remove(0);}
        int captionSize =relationPO.getCaption().size();
        for (int i = 0; i <captionSize; i++) {
            relationDao.updateBatchRelation(relationPO,relationPO.getCaption().get(i));
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
