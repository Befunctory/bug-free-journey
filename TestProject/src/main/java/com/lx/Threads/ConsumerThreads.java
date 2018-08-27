package com.lx.Threads;

import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lx.utils.ThreadUtil;

/**
 * 消费者
 * 
 * @author 凌雄
 *
 */
public class ConsumerThreads implements Runnable {
	public static Logger logger = LoggerFactory.getLogger(ConsumerThreads.class);

	public void run() {
		pop();
	}

	public void pop() {
		Queue<Car> queue = StoreHouse.queue;
		if (queue != null && queue.size() > 0) {
			logger.info("-------购买了[" + queue.poll() + "]");
			ThreadUtil.waitTime(2000);
		} else {
			logger.info("没库存了，等下再来。");
			ThreadUtil.waitTime(5000);
		}

	}

}
