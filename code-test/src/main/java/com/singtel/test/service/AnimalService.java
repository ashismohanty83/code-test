package com.singtel.test.service;

import com.singtel.test.exception.AnimalException;
import com.singtel.test.model.AnimalDetails;

public interface AnimalService {

	public AnimalDetails getAnimalDetails(String animalType, String liveWithAnimal) throws AnimalException;
	
	public AnimalDetails getChickenRooster(String animalType, String gender, int age) throws AnimalException;
	
}
