package com.singtel.test.model;

public class Dog extends Animal {

	public Dog(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String sing() {
		return "Woof, woof";
	}

	@Override
	public boolean fly() {
		return false;
	}

	@Override
	public boolean swim() {
		return false;
	}

}
