package com.singtel.test.service;

import org.springframework.stereotype.Service;

import com.singtel.test.exception.AnimalException;
import com.singtel.test.model.Animal;
import com.singtel.test.model.AnimalDetails;
import com.singtel.test.model.AnimalFactory;
import com.singtel.test.model.Chicken;
import com.singtel.test.model.Duck;
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
	public AnimalDetails getAnimalDetails(String animalType, String liveWithAnimal) throws AnimalException {

		AnimalFactory factory = new AnimalFactory();
		
		Animal animal = factory.getAnimal(animalType);
		
		AnimalDetails details = null;
		
		if (null != animal) {
			if (animal instanceof Duck) {
				Duck duck = (Duck) animal;
				details = new AnimalDetails();
				details.setName(duck.getName());
				details.setSing(duck.sing());
				details.setSwim(duck.swim());
			} else if (animal instanceof Chicken) {
				Chicken chicken = (Chicken) animal;
				details = new AnimalDetails();
				details.setName(chicken.getName());
				details.setSing(chicken.sing());
				details.setFly(chicken.fly());
			} 
			/* (non-Javadoc)
			 * @see com.singtel.test.service.AnimalService#getParrotDetailsLeavingWithDifferentEntities(java.lang.String, java.lang.String)
			 * Get Parrot details depends on living with different entities
			 * LIVING Entities details (DOG, CAT, DUCK, etc...) IF Not Parrot living near to telephone.
			 */
			else if (animal instanceof Parrot) {
				Parrot parrot = (Parrot) animal;
				details = new AnimalDetails();
				details.setName(parrot.getName());
				details.setFly(parrot.fly());
				if (!liveWithAnimal.isEmpty()) {
					Animal leavingWithAnimal = factory.getAnimal(liveWithAnimal);
					if (null != leavingWithAnimal) {
						parrot.setAnimalLiveWith(leavingWithAnimal);
						details.setSing(parrot.sing());
					} else { //leaving near phone
						parrot.setFrequentSound("ring ring");
						details.setSing(parrot.sing());
					}
				} else { //leaving near phone
					parrot.setFrequentSound("ring ring");
					details.setSing(parrot.sing());
				}
			}
		} else {
			throw new AnimalException("Provide correct Animal type");
		}
		
		return details;
	}

	/* (non-Javadoc)
	 * @see com.singtel.test.service.AnimalService#getChickenRooster(java.lang.String, java.lang.String, int)
	 * Decide Chicken or Rooster depends on properties
	 */
	public AnimalDetails getChickenRooster(String animalType, String gender, int age) throws AnimalException {
		
		AnimalFactory factory = new AnimalFactory();
		
		Animal animal = factory.getAnimal(animalType);
		AnimalDetails details = null;
		if (null != animal) {
			if (animal instanceof Chicken) {
				Chicken chicken = (Chicken) animal;
				chicken.setChickenProperties(gender, age);
				details = new AnimalDetails();
				details.setName(chicken.getName());
				details.setSing(chicken.sing());
				details.setFly(chicken.fly());
				if (chicken.isChicken()) {
					details.setType(animalType);
				} else {
					details.setType("ROOSTER");
				}
			}
		}  else {
			throw new AnimalException("Provide correct Animal type");
		}
		
		return details;
		
	}
}
