package com.lx.lock;

public class Thread2 implements Runnable {
	User1 user1;
	User2 user2;

	public Thread2(User1 user1, User2 user2) {
		this.user1 = user1;
		this.user2 = user2;
	}

	public void run() {
		try {
			synchronized (user2) {
				try {
					Thread.sleep(2000);
					System.out.println(1 / 0);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				synchronized (user1) {
					System.out.println("Thread2---获取了user1对象的锁");
				}

			}
		} catch (Exception e) {
			System.err.println(Thread.currentThread().getName() + "获取锁异常。。。");
		}

	}

}
