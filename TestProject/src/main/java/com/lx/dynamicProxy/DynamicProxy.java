package com.lx.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//每一个动态代理类都要事先InvocationHandler这个类
public class DynamicProxy implements InvocationHandler {

	// 我们需要代理的真实对象
	private Object subject;

	public DynamicProxy(Object subject) {
		this.subject = subject;
	}

	public Object invoke(Object object, Method method, Object[] args) throws Throwable {

		System.out.println("在代理真实对象前，我们可以添加一些自己的操作");
		System.out.println("before rent my house.");
		System.out.println("Method:" + method);

		// 当代理对象调用真实对象的方法时，其会自动跳转到代理对象关联的handler对象的invoke方法来进行调用
		method.invoke(subject, args);

		// 在代理真实对象后我们也可以做一些其他操作
		System.out.println("after rent my house.");

		return null;
	}

}
