package com.singtel.test.service;

import org.springframework.stereotype.Service;

import com.singtel.test.constant.AnimalPropertyType;
import com.singtel.test.constant.AnimalType;
import com.singtel.test.exception.AnimalException;
import com.singtel.test.model.Animal;
import com.singtel.test.model.AnimalFactory;
import com.singtel.test.model.ButterFly;
import com.singtel.test.model.Cat;
import com.singtel.test.model.Chicken;
import com.singtel.test.model.Clownfish;
import com.singtel.test.model.Dog;
import com.singtel.test.model.Dolphin;
import com.singtel.test.model.Duck;
import com.singtel.test.model.Parrot;
import com.singtel.test.model.Shark;

/**
 * @author Ashis
 * 
 * get Animal details of different type
 *
 */
@Service
public class AnimalServiceImpl implements AnimalService {
	
	private static final Animal[] animalArr = new Animal[] {
			
			new Duck(AnimalType.DUCK.name()),
			new Chicken(AnimalType.CHICKEN.name()),
			new Chicken(AnimalType.ROOSTER.name()),
			new Parrot(AnimalType.PARROT.name(), new Chicken(AnimalType.ROOSTER.name()).sing()),
			new Shark(AnimalType.SHARK.name()),
			new Clownfish(AnimalType.CLOWNFISH.name()),
			new Dolphin(AnimalType.DOLPHIN.name()),
			new Dog(AnimalType.DOG.name()),
			new ButterFly(AnimalType.BUTTERFLY.name()),
			new Cat(AnimalType.CAT.name())
	};

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
				if (null != liveWithAnimal && !liveWithAnimal.isEmpty()) {
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
			} if(animal instanceof ButterFly) {
				ButterFly butterfly = (ButterFly) animal;
				if (!butterfly.isButterFly) {
					butterfly.setName("CATERPILLAR");
				}
				return butterfly;
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
	
	public String butterFlyMetamorphosisProcess(Animal animal) throws AnimalException {
		
		if (null == animal) {
			throw new AnimalException("Provide the proper animal details");
		} else {
			ButterFly butterfly = (ButterFly) animal;
			if (!butterfly.isButterFly) {
				butterfly = butterfly.metamorphosisProcess();
				butterfly.setName("BUTTERFLY");
			}
			
			return butterfly.toString();
		}
	}
	
	public String countAnimalProperties(String propertyType) throws AnimalException  {
		
		int count = 0;
		StringBuffer buffer = new StringBuffer(" [");
		
		if (null != propertyType && !propertyType.isEmpty()) {
			
			for (Animal animal : animalArr) {
				
				if (AnimalPropertyType.FLY.name().equalsIgnoreCase(propertyType)) {
					
					if (animal.fly()) {
						++count;
						buffer.append(animal.getName()).append(",");
					}
					
				} else if (AnimalPropertyType.WALK.name().equalsIgnoreCase(propertyType)) {
					
					if (animal.walk()) {
						++count;
						buffer.append(animal.getName()).append(",");
					}
					
				} else if (AnimalPropertyType.SWIM.name().equalsIgnoreCase(propertyType)) {
					
					if (animal.swim()) {
						++count;
						buffer.append(animal.getName()).append(",");
					}
					
				} else if (AnimalPropertyType.SING.name().equalsIgnoreCase(propertyType)) {
					
					if (null != animal.sing() && !animal.sing().isEmpty()) {
						++count;
						buffer.append(animal.getName()).append(",");
					}
				}
				
			}
			buffer.setLength(buffer.length() - 1);
			buffer.append("]");
			return "Animals Can " + propertyType.toUpperCase() + " : " + count + buffer.toString();
			
		} else {
			return "Invalid Animal PropertyType";
		}
	}
}
