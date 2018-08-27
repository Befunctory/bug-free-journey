package com.lx.quartz;

import static org.quartz.JobBuilder.newJob;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class Test2 {
	public static void main(String[] args) {
		try {
			// 创建 scheduler----->调度器
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			// 定义一个Trigger----->定义触发条件
			CronTrigger trigger = (CronTrigger) TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
					// 一旦加入schedule，立即生效，使用simpleSchedule,每隔一秒执行，永远执行下去
					// simpleSchedule().withIntervalInHours(1).repeatForever()
					//每秒钟执行一次，如果需要特定业务的cron表达式，搜索百度生成
					.withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ? ")).build();
			// 任务细节------>具体的业务逻辑 每次执行都创建一个新的任务实例
			JobDetail jobDetail = newJob(HelloQuartz.class).withIdentity("job1", "group1")
					.usingJobData("name", "quartz").build();

			scheduler.scheduleJob(jobDetail, trigger);
			// 启动
			scheduler.start();
			Thread.sleep(10000);
			// 默认为true
			scheduler.shutdown();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
