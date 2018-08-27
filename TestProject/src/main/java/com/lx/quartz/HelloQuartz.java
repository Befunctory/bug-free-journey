package com.lx.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloQuartz implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {

		JobDetail jobDetail = context.getJobDetail();
		String name = jobDetail.getJobDataMap().getString("name");
		System.out.println("say hello to " + name + "  " + new Date());
	}

}
