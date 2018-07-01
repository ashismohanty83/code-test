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
		String jsonInString = "";
		if (null != animal) {
			/*ObjectMapper mapper = new ObjectMapper();
			//Object to JSON in String
			jsonInString = mapper.writeValueAsString(details);*/
			
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
		String jsonInString = "";
		if (null != animal) {
			return animal.toString();
		}
		
		return null;
	}
	
	@RequestMapping(value = "/butterflyMetamorphosis", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String butterflyMetamorphosis(@RequestParam(value = "animalType", required=true) String animalType) throws Exception {
		
		Animal animal = animalService.getAnimalDetails(animalType, null);
		
		if (null != animal) {
			return animalService.butterFlyMetamorphosisProcess(animal);
		}
				
		return "Error in metamorphosis process from Caterpillar to Butterfly";
	}

}
