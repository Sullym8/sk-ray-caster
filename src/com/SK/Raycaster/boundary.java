package com.SK.Raycaster;

public class boundary {
	float xPoint1;
	float yPoint1;
	float xPoint2;
	float yPoint2;
	
	float intendedXPoint1;
	float intendedYPoint1;
	float intendedXPoint2;
	float intendedYPoint2;
	
	public boundary(float x1, float y1, float x2, float y2) {
		this.xPoint1 = x1;
		this.yPoint1 = y1;
		this.xPoint2 = x2;
		this.yPoint2 = y2;
		
		this.intendedXPoint1 = intendedPos(xPoint1, 'X');
//		System.out.println(intendedXPoint1);
		this.intendedYPoint1 = intendedPos(yPoint1, 'Y');
//		System.out.println(intendedYPoint1);
		this.intendedXPoint2 = intendedPos(xPoint2, 'X');
//		System.out.println(intendedXPoint2);
		this.intendedYPoint2 = intendedPos(yPoint2, 'Y');
//		System.out.println(intendedYPoint2);
	}
	
	public float intendedPos(float value, char isXorY) {
		if (isXorY == 'X') {
			value = value - 400;
		} else if (isXorY == 'Y') {
			value = 300 -value ;
		}
		return value;
		
	}
	
	

}
