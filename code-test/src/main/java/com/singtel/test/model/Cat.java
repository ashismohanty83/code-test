package com.singtel.test.model;

public class Cat extends Animal {

	public Cat(String name) {
		super(name);
	}

	@Override
	public String sing() {
		return "Meow";
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
