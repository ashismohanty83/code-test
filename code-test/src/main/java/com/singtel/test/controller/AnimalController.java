package com.singtel.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.singtel.test.model.Animal;
import com.singtel.test.service.AnimalService;

@RestController
public class AnimalController {
	
	@Autowired
	private AnimalService animalService;
	
	@RequestMapping(value = "/getAnimalDetails", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAnimalDetails(@RequestParam(value = "animalType", required=true) String animalType,
			@RequestParam(value = "liveWith", required=false) String liveWithAnimal) throws Exception {
		
		Animal animal = animalService.getAnimalDetails(animalType.toUpperCase(), liveWithAnimal);
		if (null != animal) {
			return animal.toString();
		}
		
		return null;
	}
	
	@RequestMapping(value = "/getChickenType/{animalType}", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String getChickenRooster(@PathVariable(value = "animalType") String animalType, 
			@RequestParam(value = "gender", required=true) String gender,
			@RequestParam(value = "age", required=true) int age) throws Exception {
		
		Animal animal = animalService.getChickenRooster(animalType, gender, age);
		if (null != animal) {
			return animal.toString();
		}
		
		return "Error while getting Rooster entity from chicken";
	}
	
	@RequestMapping(value = "/butterflyMetamorphosis", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String butterflyMetamorphosis(@RequestParam(value = "animalType", required=true) 
									String animalType) throws Exception {
		
		Animal animal = animalService.getAnimalDetails(animalType, null);
		
		if (null != animal) {
			return animalService.butterFlyMetamorphosisProcess(animal);
		}
				
		return "Error in metamorphosis process from Caterpillar to Butterfly";
	}
	
	/*
	 * propertyType request param
	 * FLY,SWIM,WALK,SING
	 * 
	 * 
	 **/
	
	@RequestMapping(value = "/getAnimalCountByProperty", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAnimalCountByProperty(@RequestParam(value = "propertyType", required=true) 
						String propertyType) throws Exception {
		
		return animalService.countAnimalProperties(propertyType);
		
	}

}
