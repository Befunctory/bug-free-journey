package com.lx.Threads;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Client {
	public static void main(String[] args) {

		ScheduledThreadPoolExecutor s2 = new ScheduledThreadPoolExecutor(10);
		s2.scheduleAtFixedRate(new Runnable() {

			public void run() {
				new ConsumerThreads().run();
			}

		}, 0, 1, TimeUnit.MILLISECONDS);

	}

}
