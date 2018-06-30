package com.singtel.test.model;

public class Clownfish extends Fish {

	public Clownfish(String name) {
		super(name);
		setSize("SMALL");
		setColor("ORANGE");
	}
	
	public boolean makeJoke() {
		System.out.println("I can make jokes");
		return true;
	}

	@Override
	public String toString() {
		return "Clownfish [makeJoke()=" + makeJoke() + ", sing()=" + sing() + ", fly()=" + fly() + ", swim()=" + swim()
				+ ", walk()=" + walk() + ", getSize()=" + getSize() + ", getColor()=" + getColor() + ", getName()="
				+ getName() + "]";
	}
}
