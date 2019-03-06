package com.zxq.legao.controller;


import com.alibaba.fastjson.JSON;
import com.zxq.legao.entity.po.ClasstimepackPO;
import com.zxq.legao.entity.po.ContractPO;
import com.zxq.legao.service.ClasstimepackService;
import com.zxq.legao.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * <p>
 * 合同表 前端控制器
 * </p>
 *
 * @author dengzhenxiang
 * @since 2019-02-18
 */
@Controller
public class ContractController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private ClasstimepackService classtimepackService;

    /**
     * 跳转到contractAdd
     */
    @RequestMapping("/contractAdd")
    public String jumpContractAdd(HttpServletRequest request) {
        request.setAttribute("type", request.getAttribute("type"));
        return "contract/contractAdd";
    }

    /**
     * 查询合同
     */
    @RequestMapping("/selectContract")
    public String selectContract(ContractPO contractPO, HttpServletRequest request, Integer page) {
        return contractService.selectContract(page, contractPO, request);
    }

    /**
     * 添加合同
     */
    @RequestMapping("/insertContract")
    public String insertContract(ContractPO contract, HttpServletRequest request) {
        if (contractService.insertContract(contract) > 0) {
            request.setAttribute("type", "yes");
        } else {
            request.setAttribute("type", "no");
        }
        return "contract/contractAdd";
    }


    /**
     * 删除合同
     */
    @RequestMapping("/deleteContracts")
    public String deleteContracts(Integer[] caption,HttpServletRequest request) {
        contractService.deleteContract(Arrays.asList(caption));
        return "redirect:/selectContract";

    }

    /**
     * 根据id查找合同
     */
    @RequestMapping("/editContract")
    public String editContract(@RequestParam("contractId") Integer contractId, HttpServletRequest request) {
        ContractPO contractPO = contractService.selectContractByID(contractId);
        request.setAttribute("contractByID", contractPO);
        return "forward:/editContractFrom";

    }

    /**
     * 根据给编辑页赋值
     */
    @RequestMapping("/editContractFrom")
    public String editContractFrom(HttpServletRequest request) {
        ContractPO contractPO = (ContractPO) request.getAttribute("contractByID");
        request.setAttribute("contractEdit", contractPO);
        return "contract/contractEdit";

    }

    /**
     * 保存编辑值
     */
    @RequestMapping("/saveContract")
    public String saveContract(ContractPO contract,HttpServletRequest request) {
        contractService.updateContract(contract);
        return "redirect:/selectContract";

    }

    @RequestMapping("/selectPackByPackId")
    @ResponseBody
    public String selectPackByPackId(@RequestBody ClasstimepackPO classtimepackPO) {
        String courseStr = null;
        ClasstimepackPO classtimepackPO1 = classtimepackService.selectClasstimepackByID(classtimepackPO.getId());
        if (classtimepackPO1 !=null) {

            courseStr = JSON.toJSONString(classtimepackPO1);
            return courseStr;
        } else {
            courseStr = JSON.toJSONString("");
            return courseStr;
        }

    }

}

