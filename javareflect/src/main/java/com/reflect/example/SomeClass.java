package com.reflect.example;

public class SomeClass {
	
	private int name;
	
	public SomeClass(int ip)
	{
		this.name=ip;
	}
	public SomeClass()
	{
		this.name=10;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

}
