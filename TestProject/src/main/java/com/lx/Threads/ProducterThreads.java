package com.lx.Threads;

import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lx.utils.DateUtil;
import com.lx.utils.ThreadUtil;

public class ProducterThreads implements Runnable {
	public static Logger logger = LoggerFactory.getLogger(ProducterThreads.class);

	public void run() {
		addToQueue();
	}

	public void addToQueue() {
		Queue<Car> queue = StoreHouse.getInstance();
		if (queue.size() < StoreHouse.maxSize) {
			Car car = new Car();
			car.setCreateTime("生产日期：[" + StoreHouse.num.incrementAndGet() + "]" + DateUtil.formatDate());
			car.setID("生产商：" + Thread.currentThread().getName());
			queue.offer(car);
			logger.info("生产了[" + car + "],已送往仓库。停顿1s");

			ThreadUtil.waitTime(1000);

		} else {
			/*
			 * for (Car c : queue) { logger.info("仓库已有car:" + c); }
			 */

			logger.info("仓库满了，停止10s生产。");
			ThreadUtil.waitTime(10000);
		}

	}

}
