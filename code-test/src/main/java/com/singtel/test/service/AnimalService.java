package com.singtel.test.service;

import com.singtel.test.exception.AnimalException;
import com.singtel.test.model.Animal;
import com.singtel.test.model.AnimalDetails;

public interface AnimalService {

	public Animal getAnimalDetails(String animalType, String liveWithAnimal) throws AnimalException;
	
	public Animal getChickenRooster(String animalType, String gender, int age) throws AnimalException;
	
}
