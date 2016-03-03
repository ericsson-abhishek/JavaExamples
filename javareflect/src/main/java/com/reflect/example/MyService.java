package com.reflect.example;

public class MyService implements Service{

	@Override
	public String doService(String request) {
		// TODO Auto-generated method stub
		System.out.println("Do service has been called by "+request.toUpperCase());
		return request.toUpperCase();
	}

	@Override
	public String doCalc(String request) {
		// TODO Auto-generated method stub
		System.out.println("Do calc is called by "+request.toUpperCase());
		return null;
	}

}
