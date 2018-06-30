package com.singtel.test.model;

public abstract class Animal {

	private String name;

	public Animal(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	void walk() {
		System.out.println("I am walking");
	}
	
	public abstract String sing();

}
