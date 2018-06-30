package com.singtel.test.model;

public abstract class Animal {

	private String name;

	public Animal(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean walk() {
		System.out.println("I am walking");
		return true;
	}
	
	public abstract String sing();
	public abstract boolean fly();
	public abstract boolean swim();

}
