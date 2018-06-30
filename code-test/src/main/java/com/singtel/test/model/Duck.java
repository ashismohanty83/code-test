package com.singtel.test.model;

public class Duck extends Bird {

	public Duck(String name) {
		super(name);
	}
	
	@Override
	public String sing() {
		System.out.println("Quack, quack");
		return "Quack, quack";
	}

	@Override
	public boolean fly() {
		return false;
	}

	@Override
	public boolean swim() {
		System.out.println("I can swim");
		return true;
	}

	@Override
	public String toString() {
		return "Duck [sing()=" + sing() + ", fly()=" + fly() + ", swim()=" + swim() + ", getName()=" + getName()
				+ ", walk()=" + walk()+ "]";
	}
	
	
}
