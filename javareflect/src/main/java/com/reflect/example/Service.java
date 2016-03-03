package com.reflect.example;

public interface Service {
	@TrackInvocationTime
	String doService(String request);
	
	
	String doCalc(String request);

}
