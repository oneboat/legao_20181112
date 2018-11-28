package com.zxq.legao.controller;


import com.zxq.legao.entity.po.JobPO;
import com.zxq.legao.entity.vo.JobVO;
import com.zxq.legao.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dengzhenxiang
 * @since 2018-11-27
 */
@Controller
public class JobController {
	@Autowired
	private JobService jobService;
	// 跳转到jobAdd
	@RequestMapping("/jobAdd")
	public String jumpJobAdd(HttpServletRequest request) {
		request.setAttribute("type", request.getAttribute("type"));
		return "job/jobAdd";
	}

	//查询用户
	@RequestMapping("/selectJob")
	public String selectJob(JobPO jobPO, HttpServletRequest request, Integer page) {

		return jobService.selectJob(page, jobPO, request);
	}

	// 添加用户
	@RequestMapping("/insertJob")
	public String insertJob(JobPO job, HttpServletRequest request) {
		if (jobService.addJob(job) > 0) {
			request.setAttribute("type", "yes");
		} else {
			request.setAttribute("type", "no");
		}
		return "job/jobAdd";
	}

	// 判断登录名是否重复
	@RequestMapping("/isReJobName")
	@ResponseBody
	public String isReJobName(@RequestBody JobPO jobPO) {
		List<JobVO> hasJob = jobService.findJobName(jobPO);
		if (hasJob.size() > 0) {
			// 设置为false代表登录名重复
			return "false";
		} else {
			return "true";
		}

	}

	// 删除用户
	@RequestMapping("/deleteJobs")
	public String deleteJobs(Integer[] caption,HttpServletRequest request) {

			int flag = jobService.deleteJob(Arrays.asList(caption));
			if (flag==-1){
				request.setAttribute("delete_msg","不允许删除教师职位");
			}
			return "forward:/selectJob";


	}

	// 根据id查找用户
	@RequestMapping("/editJob")
	public String editJob(@RequestParam("jobId") Integer jobId, HttpServletRequest request) {
		JobVO jobVO = jobService.selectJobByID(jobId);
		request.setAttribute("jobByID", jobVO);
		return "forward:/editJobFrom";

	}

	// 根据给编辑页赋值
	@RequestMapping("/editJobFrom")
	public String editJobFrom(HttpServletRequest request) {
		JobVO jobVO = (JobVO) request.getAttribute("jobByID");
		request.setAttribute("jobEdit", jobVO);
		return "job/jobEdit";

	}

	// 保存编辑值
	@RequestMapping("/saveJob")
	public String saveJob(JobPO job) {
		jobService.updateJob(job);
		return "redirect:/selectJob";

	}


}

