package com.singtel.test.model;

import com.singtel.test.constant.AnimalType;

public class ButterFly extends Animal {
	
	//To Check initially The butterfly condition as it is in stage of Caterpillar 
	public boolean isButterFly = false;
	
	//Stage 2 as Caterpillar as stage 1 is egg
	public int stageToButterFlyFromCaterpillar = 2; 
	
	//Process to form butterfly from Caterpillar
	public boolean isMolt = false;
	
	public ButterFly(String name) {
		super(name);
		setName(isButterFly ? AnimalType.BUTTERFLY.name() : AnimalType.CATERPILLAR.name());
	}
	
	public ButterFly metamorphosisProcess() {
		
		if (!isButterFly) {
			
			int daysSpent = 1;
			int instarStage = 1; // Caterpillar is the 1st instar
			
			//Initiate the process
			//Caterpillar requires 5 stages to become Butterfly
			while(stageToButterFlyFromCaterpillar < 5) { 
				
				while (!isMolt && instarStage <= 5) {
					
					if(instarStage == 5) {
						isMolt = true;
						break;
					}
						
					instarStage ++;
				}
				
				if (isMolt && stageToButterFlyFromCaterpillar < 3) {
					stageToButterFlyFromCaterpillar = 3;  //Pupa stage(Chrysails stage)
				}
				
				if (daysSpent == 10) {
					stageToButterFlyFromCaterpillar = 4; // Metamorphosis stage
				}
				
				if (daysSpent == 14) {
					stageToButterFlyFromCaterpillar = 5; // Adult stage of butterfly
					isButterFly = true;
					fly();
					walk();
					setName(AnimalType.BUTTERFLY.name());
				}
				
				daysSpent++;
			}
			
		} else {
			fly();
			walk();
		}
		
		return this;
	}

	@Override
	public String sing() {
		return "";
	}

	@Override
	public boolean fly() {
		
		if (!isButterFly) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean swim() {
		return false;
	}
	
	
	//Caterpillar can walk  but Butterfly can't
	@Override
	public boolean walk() {
		if(!isButterFly)
			return super.walk();
		else
			return false;
	}

	@Override
	public String toString() {
		return "ButterFly [isButterFly=" + isButterFly + ", sing()=" + sing() + ", fly()=" + fly() + ", swim()="
				+ swim() + ", walk()=" + walk() + ", getName()=" + getName() + "]";
	}
	
	
	
	

}
