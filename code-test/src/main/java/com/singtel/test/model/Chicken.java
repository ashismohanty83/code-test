package com.singtel.test.model;

public class Chicken extends Bird {
	
	private String gender;
	private int age;
	private boolean isChicken = true;

	public Chicken(String name) {
		super(name);
	}

	@Override
	public String sing() {
		
		if (isChicken) {
			return "Cluck, cluck";
		} else {
			return "Cock-a-doodle-doo";
		}
	}
	
	@Override
	public boolean fly() {
		System.out.println("I can't fly because my windgs are clipped");
		return false;
	}
	
	/**
	 * @param gender : MALE/FEMALE
	 * @param age in Months
	 */
	public void setChickenProperties(String gender, int age) {
		
		this.gender = gender;
		this.age = age;
		
		if ("MALE".equalsIgnoreCase(gender) && age >= 12) {
			isChicken = false;
		}
	}
	
	public boolean isChicken() {
		return isChicken;
	}

	@Override
	public boolean swim() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "Chicken [gender=" + gender + ", age=" + age + ", isChicken=" + isChicken + ", sing()=" + sing()
				+ ", fly()=" + fly() + ", isChicken()=" + isChicken() + ", swim()=" + swim() + ", getName()="
				+ getName() + ", walk()=" + walk() + "]";
	}
}
