package com.singtel.test.model;

public class Fish extends Animal {
	
	private String size;
	private String color;

	public Fish(String name) {
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
	public boolean walk() {
		System.out.println("I cant walkss");
		return false;
	}
	
	public void setSize(String size){
		this.size = size;
	}
	
	public String getSize() {
		return size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
