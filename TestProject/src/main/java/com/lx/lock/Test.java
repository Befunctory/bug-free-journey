package com.lx.lock;

public class Test {
	public static void main(String[] args) {
		User1 user1 = new User1();
		User2 user2 = new User2();
		Thread t1 = new Thread(new Thread1(user1, user2));
		Thread t2 = new Thread(new Thread2(user1, user2));

		t1.start();
		t2.start();

	}

}
