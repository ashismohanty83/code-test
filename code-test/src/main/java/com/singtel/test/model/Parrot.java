package com.singtel.test.model;

public class Parrot extends Bird implements Flyer {
	
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

	public boolean fly() {
		System.out.println("I can fly");
		return true;
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
}
