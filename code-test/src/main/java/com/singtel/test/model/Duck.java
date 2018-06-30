package com.singtel.test.model;

public class Duck extends Bird implements Swimmer {

	public Duck(String name) {
		super(name);
	}
	
	@Override
	public String sing() {
		System.out.println("Quack, quack");
		return "Quack, quack";
	}
	
	public boolean isSwim() {
		System.out.println("I can swim");
		return true;
	}
}
