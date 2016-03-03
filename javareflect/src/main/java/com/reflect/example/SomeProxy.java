package com.reflect.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SomeProxy implements InvocationHandler {
	
	final Object target;
	
	public SomeProxy(Object targetIn) {
		// TODO Auto-generated constructor stub
		this.target=targetIn;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		Object result = null;
		if (method.getAnnotation(TrackInvocationTime.class) != null) {
			long currentTime = System.nanoTime();
			result = method.invoke(target, args);
			System.out.println("Time taken for method " + method.getName() + "() to invoke was "
					+ (System.nanoTime() - currentTime)+" nano secs");
		} else {
			result = method.invoke(target, args);
		}
		return result;
	}

}
