package com.singtel.test.model;

public class AnimalDetails {
	
	private String name;
	private String type;
	private String sing;
	private boolean isSwim;
	private boolean isFly;
	private boolean isWalk;
	
	public AnimalDetails() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSing() {
		return sing;
	}
	public void setSing(String sing) {
		this.sing = sing;
	}
	public boolean isSwim() {
		return isSwim;
	}
	public void setSwim(boolean isSwim) {
		this.isSwim = isSwim;
	}
	public boolean isFly() {
		return isFly;
	}
	public void setFly(boolean isFly) {
		this.isFly = isFly;
	}

	@Override
	public String toString() {
		return "AnimalDetails [name=" + name + ", type=" + type + ", "
				+ "sing=" + sing + ", isSwim=" + isSwim + ", isFly="
				+ isFly + "]";
	}

	public boolean isWalk() {
		return isWalk;
	}

	public void setWalk(boolean isWalk) {
		this.isWalk = isWalk;
	}
}
