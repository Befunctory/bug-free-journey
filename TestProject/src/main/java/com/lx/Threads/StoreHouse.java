package com.lx.Threads;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class StoreHouse {
	public static Queue<Car> queue = null;
	public static int maxSize = 10;// 仓库最大容量
	public static AtomicInteger num = new AtomicInteger(0);

	public static Queue<Car> getInstance() {
		if (queue == null) {
			queue = new LinkedBlockingQueue<Car>();
		}
		return queue;
	}

}
