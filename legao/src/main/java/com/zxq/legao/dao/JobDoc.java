package com.zxq.legao.dao;

import com.zxq.legao.entity.po.JobPO;
import com.zxq.legao.entity.vo.JobVO;

import java.util.List;

public interface JobDoc {

	int insertJob(JobPO jobPO);

	int deleteJob(List<Integer> jobIDs);

	int updateJob(JobPO jobPO);

	List<JobVO> selectJob(JobPO jobPO);

	JobVO selectJobByID(JobPO jobPO);

}
