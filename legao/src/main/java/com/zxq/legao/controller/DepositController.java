package com.zxq.legao.controller;


import com.zxq.legao.entity.po.DepositPO;
import com.zxq.legao.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 订金表 前端控制器
 * </p>
 *
 * @author dengzhenxiang
 * @since 2019-02-18
 */
@Controller
public class DepositController {
    @Autowired
    private DepositService depositService;

    /**
     * 跳转到DepositAdd
     */
    @RequestMapping("/depositAdd")
    public String jumpDepositAdd(HttpServletRequest request) {
        request.setAttribute("type", request.getAttribute("type"));
        return "deposit/depositAdd";
    }

    /**
     * 查询订金
     */
    @RequestMapping("/selectDeposit")
    public String selectDeposit(DepositPO DepositPO, HttpServletRequest request, Integer page) {

        return depositService.selectDeposit(page, DepositPO, request);
    }

    /**
     * 添加订金
     */
    @RequestMapping("/insertDeposit")
    public String insertDeposit(DepositPO Deposit, HttpServletRequest request) {
        if (depositService.insertDeposit(Deposit) > 0) {
            request.setAttribute("type", "yes");
        } else {
            request.setAttribute("type", "no");
        }
        ServletContext servletContext = request.getServletContext();
        List<DepositPO> allDeposit = depositService.findAllDepositName();
        servletContext.setAttribute("allDeposit",allDeposit);
        return "deposit/depositAdd";
    }

    /**
     * 删除订金
     */
    @RequestMapping("/deleteDeposits")
    public String deleteDeposits(Integer[] caption, HttpServletRequest request) {

        depositService.deleteDeposit(Arrays.asList(caption));
        ServletContext servletContext = request.getServletContext();
        List<DepositPO> allDeposit = depositService.findAllDepositName();
        servletContext.setAttribute("allDeposit",allDeposit);
        return "forward:/selectDeposit";


    }

    /**
     * 根据id查找订金
     */
    @RequestMapping("/editDeposit")
    public String editDeposit(@RequestParam("depositId") Integer depositId, HttpServletRequest request) {
        DepositPO DepositPO = depositService.selectDepositByID(depositId);
        request.setAttribute("depositByID", DepositPO);
        return "forward:/editDepositFrom";

    }

    /**
     * 根据给编辑页赋值
     */
    @RequestMapping("/editDepositFrom")
    public String editDepositFrom(HttpServletRequest request) {
        DepositPO DepositPO = (DepositPO) request.getAttribute("depositByID");
        request.setAttribute("depositEdit", DepositPO);
        return "deposit/depositEdit";

    }

    /**
     * 保存编辑值
     */
    @RequestMapping("/saveDeposit")
    public String saveDeposit(DepositPO Deposit,HttpServletRequest request) {
        depositService.updateDeposit(Deposit);
        ServletContext servletContext = request.getServletContext();
        List<DepositPO> allDeposit = depositService.findAllDepositName();
        servletContext.setAttribute("allDeposit",allDeposit);
        return "redirect:/selectDeposit";

    }
}

