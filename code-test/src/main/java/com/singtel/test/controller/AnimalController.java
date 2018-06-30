package com.singtel.test.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.singtel.test.model.AnimalDetails;
import com.singtel.test.service.AnimalService;

@RestController
public class AnimalController {
	
	@Autowired
	private AnimalService animalService;
	
	@RequestMapping(value = "/getAnimalDetails", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAnimalDetails(@RequestParam(value = "animalType", required=true) String animalType,
			@RequestParam(value = "liveWith", required=false) String liveWithAnimal) throws Exception {
		
		AnimalDetails details = animalService.getAnimalDetails(animalType.toUpperCase(), liveWithAnimal);
		String jsonInString = "";
		if (null != details) {
			ObjectMapper mapper = new ObjectMapper();
			//Object to JSON in String
			jsonInString = mapper.writeValueAsString(details);
		}
		
		return jsonInString;
	}
	
	@RequestMapping(value = "/getChickenType/{animalType}", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String getChickenRooster(@PathVariable(value = "animalType") String animalType, 
			@RequestParam(value = "gender", required=true) String gender,
			@RequestParam(value = "age", required=true) int age) throws Exception {
		
		AnimalDetails details = animalService.getChickenRooster(animalType, gender, age);
		String jsonInString = "";
		if (null != details) {
			ObjectMapper mapper = new ObjectMapper();
			//Object to JSON in String
			jsonInString = mapper.writeValueAsString(details);
		}
		
		return jsonInString;
	}

}
