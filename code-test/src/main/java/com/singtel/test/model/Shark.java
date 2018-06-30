package com.singtel.test.model;

public class Shark extends Fish {

	public Shark(String name) {
		super(name);
		setSize("LARGE");
		setColor("GREY");
	}
	
	public boolean canEat(Fish fish) {
		System.out.println("Now I am eating" + fish.getName());
		return true;
	}

	@Override
	public String toString() {
		return "Shark [sing()=" + sing() + ", fly()=" + fly() + ", swim()=" + swim() + ", walk()=" + walk()
				+ ", getSize()=" + getSize() + ", getColor()=" + getColor() + ", getName()=" + getName()+ "]";
	}

}
