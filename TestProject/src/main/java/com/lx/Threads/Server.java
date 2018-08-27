package com.lx.Threads;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Server {
	public static Logger logger = LoggerFactory.getLogger(Server.class);

	public static void main(String[] args) {
		/*
		 * try { System.out.println(1 / 0); } catch (Exception e) {
		 * logger.error("业务异常信息：[{}]", e.getMessage(), e); }
		 */

		ScheduledThreadPoolExecutor s = new ScheduledThreadPoolExecutor(2);
		s.scheduleAtFixedRate(new Runnable() {

			public void run() {
				try {
					client();
					server();
				} catch (Exception e) {
					logger.error("业务异常信息：[{}]", e.getMessage(), e);
				}

			}

		}, 0, 1, TimeUnit.DAYS);

	}

	public static void server() {
		System.out.println("调用生产者");
		final ScheduledThreadPoolExecutor s = new ScheduledThreadPoolExecutor(5);
		s.scheduleAtFixedRate(new Runnable() {

			public void run() {
				// new ProducterThreads().run();
				// new Thread(new ProducterThreads()).start();

				try {

					s.execute(new ProducterThreads());

				} catch (Exception e) {
					logger.error("业务异常信息：[{}]", e.getMessage(), e);
				}

			}

		}, 0, 10, TimeUnit.MILLISECONDS);

	}

	public static void client() {
		System.out.println("调用消费者");
		final ScheduledThreadPoolExecutor s = new ScheduledThreadPoolExecutor(10);
		s.scheduleAtFixedRate(new Runnable() {

			public void run() {
				// new ConsumerThreads().run();
				// new Thread(new ConsumerThreads()).start();
				s.execute(new ConsumerThreads());
			}

		}, 2000, 10, TimeUnit.MILLISECONDS);
	}

}
