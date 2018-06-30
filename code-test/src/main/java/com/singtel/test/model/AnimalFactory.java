package com.singtel.test.model;

import com.singtel.test.constant.AnimalType;

/**
 * @author Ashis
 * 
 *         Factory of Animals
 *
 */
public class AnimalFactory {

	public Animal getAnimal(String animalType) {

		if (animalType == null) {
			return null;
		} else if (animalType.equalsIgnoreCase(AnimalType.DUCK.name())) {
			return new Duck("DUCK");
		} else if (animalType.equalsIgnoreCase(AnimalType.CHICKEN.name())) {
			return new Chicken("CHICKEN");
		} else if (animalType.equalsIgnoreCase(AnimalType.PARROT.name())) {
			return new Parrot("PARROT");
		} else if (animalType.equalsIgnoreCase(AnimalType.DOG.name())) {
			return new Dog("DOG");
		} else if (animalType.equalsIgnoreCase(AnimalType.CAT.name())) {
			return new Cat("CAT");
		}
		
		return null;
	}
}