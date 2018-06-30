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

	@Override
	public String toString() {
		return "Cat [sing()=" + sing() + ", fly()=" + fly() + ", swim()=" + swim() + ", getName()=" + getName()
				+ ", walk()=" + walk() + "]";
	}
}
