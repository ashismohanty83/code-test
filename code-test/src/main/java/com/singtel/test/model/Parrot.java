package com.singtel.test.model;

public class Parrot extends Bird {
	
	private String frequentSound = "";
	private Animal animalLiveWith;

	public Parrot(String name) {
		super(name);
	}
	
	/**
	 * @param name
	 * @param frequentSound
	 * Parrot stays with  non living entity (Near to phone)
	 */
	public Parrot(String name, String frequentSound) {
		super(name);
		this.frequentSound = frequentSound;
	}
	
	/**
	 * @param name
	 * @param animalLiveWith
	 * 
	 * Parrot stays with Animals (Living entity)
	 */
	public Parrot(String name, Animal animalLiveWith) {
		super(name);
		this.animalLiveWith = animalLiveWith;
	}
	
	@Override
	public String sing() {
		return frequentSound.isEmpty() ? animalLiveWith.sing() : frequentSound;
	}

	@Override
	public boolean fly() {
		System.out.println("I can fly");
		return true;
	}
	
	@Override
	public boolean swim() {
		return false;
	}
	
	@Override
	public boolean walk() {
		return false;
	}

	public String getFrequentSound() {
		return frequentSound;
	}

	public void setFrequentSound(String frequentSound) {
		this.frequentSound = frequentSound;
	}

	public Animal getAnimalLiveWith() {
		return animalLiveWith;
	}

	public void setAnimalLiveWith(Animal animalLiveWith) {
		this.animalLiveWith = animalLiveWith;
	}

	@Override
	public String toString() {
		return "Parrot [frequentSound=" + frequentSound + ", sing()=" + sing()
				+ ", fly()=" + fly() + ", swim()=" + swim() + ", getFrequentSound()=" + getFrequentSound()
				+ ", getAnimalLiveWith()=" + getAnimalLiveWith() + ", getName()=" + getName() + ", walk()=" + walk() + "]";
	}
}
