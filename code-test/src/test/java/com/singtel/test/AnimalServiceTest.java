package com.singtel.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import com.singtel.test.constant.AnimalType;
import com.singtel.test.exception.AnimalException;
import com.singtel.test.model.Animal;
import com.singtel.test.model.ButterFly;
import com.singtel.test.model.Cat;
import com.singtel.test.model.Chicken;
import com.singtel.test.model.Dog;
import com.singtel.test.model.Duck;
import com.singtel.test.model.Parrot;
import com.singtel.test.service.AnimalServiceImpl;

@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
public class AnimalServiceTest {
	
	@InjectMocks
	AnimalServiceImpl animalService = mock(AnimalServiceImpl.class);
	
	
	@Test
	public void getDuckAnimalDetailsTest() throws AnimalException {
		
		Animal animal = new Duck(AnimalType.DUCK.name());
		when(animalService.getAnimalDetails("DUCK", "")).thenReturn(animal);
		assertEquals("DUCK", animalService.getAnimalDetails("DUCK", "").getName());
	}
	
	@Test
	public void getRoosterAnimalDetailsTest() throws AnimalException {
		
		Animal animal = new Chicken(AnimalType.ROOSTER.name());
		when(animalService.getAnimalDetails("ROOSTER", "")).thenReturn(animal);
		assertEquals("ROOSTER", animalService.getAnimalDetails("ROOSTER", "").getName());
		assertEquals("Cock-a-doodle-doo", animalService.getAnimalDetails("ROOSTER", "").sing());
	}
	
	@Test
	public void getParrotWhoLivesWithDogTest()  throws AnimalException {
		
		String dogSing = new Dog("DOG").sing();
		Animal animal = new Parrot(AnimalType.PARROT.name(), dogSing);
		when(animalService.getAnimalDetails("PARROT", dogSing)).thenReturn(animal);
		assertEquals("Woof, woof", animalService.getAnimalDetails("PARROT", dogSing).sing());
	}
	
	@Test
	public void getParrotWhoLivesWithCatTest()  throws AnimalException {
		
		String catSing = new Cat("CAT").sing();
		Animal animal = new Parrot(AnimalType.PARROT.name(), catSing);
		when(animalService.getAnimalDetails("PARROT", catSing)).thenReturn(animal);
		assertEquals("Meow", animalService.getAnimalDetails("PARROT", catSing).sing());
	}
	
	@Test
	public void getParrotWhoLivesWithRoosterTest() throws AnimalException {
		
		String roosterSing = new Chicken("ROOSTER").sing();
		Animal animal = new Parrot(AnimalType.ROOSTER.name(), roosterSing);
		when(animalService.getAnimalDetails("PARROT", roosterSing)).thenReturn(animal);
		assertEquals("Cock-a-doodle-doo", animalService.getAnimalDetails("PARROT", roosterSing).sing());
	}
	
	@Test
	public void caterpillarToButterflyTest()throws AnimalException {
		
		Animal animal = new ButterFly(AnimalType.BUTTERFLY.name());
		when(animalService.getAnimalDetails("BUTTERFLY", "")).thenReturn(animal);
		ButterFly butterfly = (ButterFly) animalService.getAnimalDetails("BUTTERFLY", "");
		assertEquals(Boolean.FALSE, butterfly.fly());
		assertEquals(Boolean.FALSE, butterfly.isButterFly);
		assertEquals(AnimalType.CATERPILLAR.name(), butterfly.getName());
		butterfly.metamorphosisProcess();
		assertEquals(Boolean.TRUE, butterfly.fly());
		assertEquals(Boolean.TRUE, butterfly.isButterFly);
		assertEquals(AnimalType.BUTTERFLY.name(), butterfly.getName());
	}
	
	@Test
	public void isChickenOrRoosterAnimalTest()throws AnimalException {
		
		Chicken chicken = new Chicken(AnimalType.CHICKEN.name());
		chicken.setChickenProperties("MALE", 13);
		when(animalService.getChickenRooster(AnimalType.CHICKEN.name(), "MALE", 13)).thenReturn(chicken);
		assertEquals("Cock-a-doodle-doo", animalService.getChickenRooster(AnimalType.CHICKEN.name(), "MALE", 13).sing());
		Assert.assertNotEquals("Cluck, cluck", animalService.getChickenRooster(AnimalType.CHICKEN.name(), "MALE", 13).sing());
	}
	
	@Test
	public void countAnimalByFlyTest()throws AnimalException {
		String response = "Animals Can FLY : 1 [PARROT]";
		when(animalService.countAnimalProperties("FLY")).thenReturn(response);
		assertEquals("Animals Can FLY : 1 [PARROT]", animalService.countAnimalProperties("FLY"));
	}
	
	@Test
	public void countAnimalBySwimTest()throws AnimalException {
		String response = "Animals Can SWIM : 4 [DUCK,SHARK,CLOWNFISH,DOLPHIN]";
		when(animalService.countAnimalProperties("SWIM")).thenReturn(response);
		assertEquals("Animals Can SWIM : 4 [DUCK,SHARK,CLOWNFISH,DOLPHIN]", animalService.countAnimalProperties("SWIM"));
	}
	
	@Test
	public void countAnimalBySingTest()throws AnimalException {
		String response = "Animals Can SING : 6 [DUCK,CHICKEN,ROOSTER,PARROT,DOG,CAT]";
		when(animalService.countAnimalProperties("SING")).thenReturn(response);
		assertEquals("Animals Can SING : 6 [DUCK,CHICKEN,ROOSTER,PARROT,DOG,CAT]", animalService.countAnimalProperties("SING"));
	}
	

}
