package com.lx.lock;

public class Thread1 implements Runnable {
	User1 user1;
	User2 user2;

	public Thread1(User1 user1, User2 user2) {
		this.user1 = user1;
		this.user2 = user2;
	}

	public void run() {
		try {
			synchronized (user1) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

				synchronized (user2) {
					System.out.println("Thread1---获取了user2对象的锁");
				}
				 

			}
		} catch (Exception e) {
			System.err.println(Thread.currentThread().getName() + "获取锁异常。。。");
		}

	}

}
