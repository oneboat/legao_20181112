package com.zxq.legao.controller;

import com.zxq.legao.entity.po.FollowPO;
import com.zxq.legao.entity.vo.FollowVO;
import com.zxq.legao.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
public class FollowController {
    @Autowired
    private FollowService followService;

    // 跳转到followAdd
    @RequestMapping("/followAdd")
    public String jumpFollowAdd(HttpServletRequest request) {
        request.setAttribute("type", request.getAttribute("type"));
        return "follow/followAdd";
    }

    //查询跟进人
    @RequestMapping("/selectFollow")
    public String selectFollow(FollowPO followPO, HttpServletRequest request, Integer page) {

        return followService.selectFollow(page, followPO, request);
    }

    // 添加跟进人
    @RequestMapping("/insertFollow")
    public String insertFollow(FollowPO follow, HttpServletRequest request) {
        if (followService.insertFollow(follow) > 0) {
            request.setAttribute("type", "yes");
        } else {
            request.setAttribute("type", "no");
        }
        return "follow/followAdd";
    }

    // 删除跟进人
    @RequestMapping("/deleteFollows")
    public String deleteFollows(Integer[] caption, HttpServletRequest request) {

        followService.deleteFollow(Arrays.asList(caption));

        return "forward:/selectFollow";


    }

    // 根据id查找跟进人
    @RequestMapping("/editFollow")
    public String editFollow(@RequestParam("followId") Integer followId, HttpServletRequest request) {
        FollowPO followPO = followService.selectFollowByID(followId);
        request.setAttribute("followByID", followPO);
        return "forward:/editFollowFrom";

    }

    // 根据给编辑页赋值
    @RequestMapping("/editFollowFrom")
    public String editFollowFrom(HttpServletRequest request) {
        FollowPO followPO = (FollowPO) request.getAttribute("followByID");
        request.setAttribute("followEdit", followPO);
        return "follow/followEdit";

    }

    // 保存编辑值
    @RequestMapping("/saveFollow")
    public String saveFollow(FollowPO follow) {
        followService.updateFollow(follow);
        return "redirect:/selectFollow";

    }
}
