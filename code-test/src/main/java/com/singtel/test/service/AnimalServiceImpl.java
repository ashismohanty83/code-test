package com.singtel.test.service;

import org.springframework.stereotype.Service;

import com.singtel.test.exception.AnimalException;
import com.singtel.test.model.Animal;
import com.singtel.test.model.AnimalFactory;
import com.singtel.test.model.Chicken;
import com.singtel.test.model.Parrot;

/**
 * @author Ashis
 * 
 * get Animal details of different type
 *
 */
@Service
public class AnimalServiceImpl implements AnimalService {

	/* (non-Javadoc)
	 * @see com.singtel.test.service.AnimalService#getAnimalDetails(java.lang.String)
	 * return animal details depends on animalType
	 */
	public Animal getAnimalDetails(String animalType, String liveWithAnimal) throws AnimalException {

		AnimalFactory factory = new AnimalFactory();
		
		Animal animal = factory.getAnimal(animalType);
		
		if (null != animal) {
			if (animal instanceof Parrot) {
				Parrot parrot = (Parrot) animal;
				if (!liveWithAnimal.isEmpty()) {
					Animal leavingWithAnimal = factory.getAnimal(liveWithAnimal);
					if (null != leavingWithAnimal) {
						parrot.setAnimalLiveWith(leavingWithAnimal);
					} else { //leaving near phone
						parrot.setFrequentSound("ring ring");
					}
				} else { //leaving near phone
					parrot.setFrequentSound("ring ring");
				}
				
				return parrot;
			} else {
				return animal;
			}
		} else {
			throw new AnimalException("Provide correct Animal type");
		}
	}

	/* (non-Javadoc)
	 * @see com.singtel.test.service.AnimalService#getChickenRooster(java.lang.String, java.lang.String, int)
	 * Decide Chicken or Rooster depends on properties
	 */
	public Animal getChickenRooster(String animalType, String gender, int age) throws AnimalException {
		
		AnimalFactory factory = new AnimalFactory();
		
		Animal animal = factory.getAnimal(animalType);
		if (null != animal) {
			if (animal instanceof Chicken) {
				Chicken chicken = (Chicken) animal;
				chicken.setChickenProperties(gender, age);
				
				if (chicken.isChicken()) {
					chicken.setName(animalType);
				} else {
					chicken.setName("ROOSTER");
				}
			}
		}  else {
			throw new AnimalException("Provide correct Animal type");
		}
		
		return animal;
		
	}
}
