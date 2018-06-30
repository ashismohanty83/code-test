package com.singtel.test.model;

public class Cat extends Animal {

	public Cat(String name) {
		super(name);
	}

	@Override
	public String sing() {
		return "Meow";
	}

}
