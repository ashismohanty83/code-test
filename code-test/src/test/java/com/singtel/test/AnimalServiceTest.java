package com.singtel.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.singtel.test.service.AnimalService;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class AnimalServiceTest {
	
	@Autowired
	AnimalService animalService;

}
