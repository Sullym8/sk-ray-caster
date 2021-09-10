package com.SK.Raycaster;

import java.util.ArrayList;

import javax.sound.midi.Soundbank;

public class particle {
	float posX;
	float posY;
	float heading;
	
	float intendedPosX;
	float intendedPosY;
	ArrayList<ray> arrayListofRays;
	
	public particle(float x, float y, int range) {
		// TODO Auto-generated constructor stub
		this.posX = x;
		this.posY = y;
		this.heading = 45;
		
		
		this.intendedPosX = calculateIntendedPos(posX, 'X');
		this.intendedPosY = calculateIntendedPos(posY, 'Y');
		
		arrayListofRays = new ArrayList<ray>();
		for (float i = 0 + range; i < 90+ range; i += 0.1f) {
			this.heading = (range + 90 + range)/2;
			arrayListofRays.add(new ray(posX, posY, i));
//			System.out.println(arrayListofRays.size());
		}
		
		
		
	}
	
	public float calculateIntendedPos(float value, char isXorY) {
		if (isXorY == 'X') {
			value = value - 400;
		} else if (isXorY == 'Y') {
			value = 300 - value;
		}
		return value;
		
	}
}
