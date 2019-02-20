package com.zxq.legao.controller;

import com.zxq.legao.entity.po.RelationPO;
import com.zxq.legao.entity.vo.RelationVO;
import com.zxq.legao.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author dengzhenxiang
 * @since 2018-11-27
 */
@Controller
public class RelationController {
    @Autowired
    private RelationService relationService;

    /**
     * 跳转到relationAdd
      */
    @RequestMapping("/relationAdd")
    public String jumpRelationAdd(HttpServletRequest request) {
        request.setAttribute("type", request.getAttribute("type"));
        return "relation/relationAdd";
    }

    /**
     * 查询签到
     */
    @RequestMapping("/selectRelation")
    public String selectRelation(RelationPO relationPO, HttpServletRequest request, Integer page) {

        return relationService.selectRelation(page, relationPO, request);
    }



    /**
     * 删除签到
      */
    @RequestMapping("/deleteRelations")
    public String deleteRelations(Integer[] caption, HttpServletRequest request) {

        relationService.deleteRelation(Arrays.asList(caption));
        return "forward:/selectRelation";


    }

    /**
     * 根据scheduleID查找签到记录
      */
    @RequestMapping("/editRelation")
    public String editRelation(@RequestParam("scheduleId") Integer scheduleId, HttpServletRequest request) {
        List<RelationVO> relationVOList = relationService.selectRelationByScheduleID(scheduleId);
        if (relationVOList.size()!=0) {
            request.setAttribute("relationEdit", relationVOList.get(0));
            request.setAttribute("relationVOList", relationVOList);
        }
        return "relation/relationEdit";

    }

    /**
     * 批量修改签到状态
     */
    @RequestMapping("/updateBatchRelation")
    public String updateBatchRelation(RelationPO relationPO,HttpServletRequest request) {
        relationService.updateBatchRelation(relationPO);
        List<RelationVO> relationVOList = relationService.selectRelationByScheduleID(relationPO.getScheduleID());
        request.setAttribute("relationEdit",relationVOList.get(0));
        request.setAttribute("relationVOList", relationVOList);
        return "relation/relationEdit";

    }


}
