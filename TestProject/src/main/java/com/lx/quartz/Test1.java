package com.lx.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
//what meanning?
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.DateBuilder.newDate;
import static org.quartz.JobBuilder.newJob;

public class Test1 {
	public static void main(String[] args) {
		try {
			// 创建 scheduler----->调度器
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			// 定义一个Trigger----->定义触发条件
			Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startNow()
					// 一旦加入schedule，立即生效，使用simpleSchedule,每隔一秒执行，永远执行下去
					.withSchedule(simpleSchedule().withIntervalInHours(1).repeatForever()).build();
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
