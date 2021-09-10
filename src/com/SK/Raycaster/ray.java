package com.SK.Raycaster;

import java.util.ArrayList;

public class ray {
	
	float originX;
	float originY;
	
	float intendedOriginX;
	float intendedOriginY;
	
	float maxX;
	float maxY;
	
	float intendedMaxX;
	float intendedMaxY;
	
	double dirAngle;
	int distLimit;
	
	float intendedPointX;
	float intendedPointY;
	
	boolean casting;
	
	
	public ray(float x1, float y1, double ang) {
		this.originX = x1 ;
//		System.out.println(originX);
		this.originY = y1;
//		System.out.println(originY);
		this.intendedOriginX = calculateIntendedPos(originX, 'X');
//		System.out.println(intendedOriginX);
		this.intendedOriginY = calculateIntendedPos(originY, 'Y');
//		System.out.println(intendedOriginY);
		
		this.distLimit = 1;
		this.dirAngle = Math.toRadians(ang);
		
		this.maxX = (float) (originX + Math.cos(dirAngle)*distLimit); 
		this.maxY = (float) (originY + Math.sin(dirAngle)*distLimit);
		
		this.intendedMaxX = calculateIntendedPos(maxX, 'X');
		this.intendedMaxY = calculateIntendedPos(maxY, 'Y');
	}

	public boolean cast(boundary b) {
		
			double x1 = b.intendedXPoint1;
			double y1 = b.intendedYPoint1;
			double x2 = b.intendedXPoint2;
			double y2 = b.intendedYPoint2;
		
			double x3 = intendedOriginX;
			double y3 = intendedOriginY;
			double x4 = intendedMaxX;
			double y4 = intendedMaxY;
		
		
			double den = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
			if (den == 0) {
//				System.out.println("parallel");
				return false;
			} 
			
			double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / den;
	//		System.out.println(t);
			double u = - ((x1 - x2) * (y1 - y3) - (y1 - y2) * (x1 - x3)) / den;
	//		System.out.println(u);
			
			if (t > 0 && t < 1 && u > 0) {
				
				intendedPointX = (float) (x1 + t*(x2-x1));
				intendedPointY = (float) (y1 + t*(y2-y1));
				return true;
			} else {
				return false;
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
	
	public float distCalc(float x1, float y1, float x2, float y2) {
		
		return (float) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
		
	}

}
