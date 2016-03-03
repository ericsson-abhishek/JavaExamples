package com.reflect.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyReflection {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
		//NORMAL WAY
		//SomeClass s = new SomeClass(1);
//		s.setName(1);
//		s.name=1898;
//		System.out.println(s.getName());
		
		//Reflection way
		//SomeClass sRef = SomeClass.class.newInstance();
		Class someClassMetaData = Class.forName("com.reflect.example.SomeClass");
		Constructor [] constructors = someClassMetaData.getConstructors();
		Constructor c = constructors[0];
		Class[] paramTypes = c.getParameterTypes();
		
		SomeClass sRef =(SomeClass) c.newInstance(1);
		
		//Emulating s.name=1898; in reflection way START
		Field [] fileds = someClassMetaData.getDeclaredFields();
		Field f = fileds[0];
		System.err.println(f.getName());
		f.setAccessible(true);
		f.set(sRef, 10);
		// END
		
		//Emulating s.setName(1999) in reflection way START
		Method [] methods = someClassMetaData.getDeclaredMethods();
		Method setter = null;
		for(Method m:methods)
		{
			if (m.getName().equals("setName"))
			{
				setter=m;
				break;
			}
		}
		setter.invoke(sRef, 1999);
		//END
		
		//Some Task with Dynamic Proxying
		Service p  =(Service) Proxy.newProxyInstance(MyReflection.class.getClassLoader(), new Class[]{Service.class},new SomeProxy(new MyService()));
		p.doService("Abhishek");
		p.doCalc("Abhishek");
		
		//System.out.println(sRef.getName());
		
		//System.out.println(someClassMetaData);
	}	

}
