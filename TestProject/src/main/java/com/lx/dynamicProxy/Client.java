package com.lx.dynamicProxy;

import java.util.Date;

public class Client {

	public static void main(String[] args) {

		/*// 我们要代理的真实对象
		Subject realSubject = new RealSubject();
		// 我们要代理那个真实对象,就把该对象传进去，最后是通过该真实对象来调用其方法的
		InvocationHandler handler = new DynamicProxy(realSubject);
		*//**
		 * 通过proxy的newProcyInatsnce方法来帮我们创建代理的对象，
		 * 第一个参数handler.getClass().getClassLoader(),
		 * 我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
		 * 第二个参数realsubject.getclass().getIntefaces(),我们这里为代理对象提供的接口是真实对象所实现的接口，
		 * 表示我们要代理的是真实对象，这样我们就能调用这组接口内的方法。 第三个参数
		 * handler,我们这里将这个代理对象关联到了上方的Invocationhandler这个对象上。
		 * 
		 * 
		 *//*
		Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
				realSubject.getClass().getInterfaces(), handler);

		System.out.println("subject.getClass().getName():" + subject.getClass().getName());
		subject.rent();
		subject.hello("world");*/
		System.out.println(new Date());

	}
}
