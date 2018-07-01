package com.singtel.test.model;

public class Dolphin extends Animal {

	public Dolphin(String name) {
		super(name);
	}

	@Override
	public String sing() {
		return "";
	}

	@Override
	public boolean fly() {
		return false;
	}

	@Override
	public boolean swim() {
		return true;
	}

	@Override
	public String toString() {
		return "Dolphin [sing()=" + sing() + ", fly()=" + fly() + ", swim()=" + swim() + ", getName()=" + getName()
				+ ", walk()=" + walk()+ "]";
	}
}
