package com.SK.Raycaster;

import java.util.Scanner;

public class Maze {
	int sizeX;
	int sizeY;
	int Cells[][];

	public Maze(int x ,int y) {
		this.sizeX = x;
		this.sizeY = y;
		this.Cells = new int[sizeX][sizeY];
	}
	
	public void display(int[][] map) {
		for (int i = 0; i < sizeX; i++) {
			for (int j = 0; j < sizeY; j++) {
				System.out.print("[" + map[i][j] + "]");
			}
			System.out.println();
			
		}
	}
	public int[][] editor() {
		Scanner userInputScanner = new Scanner(System.in);
		int[][] filledMap = new int[sizeX][sizeY];
		for (int i = 0; i < sizeX; i++) {
			for (int j = 0; j < sizeY; j++) {
				System.out.println("Location" + j + ", " + i);
				filledMap[i][j] = userInputScanner.nextInt();
			}
		}
		return filledMap;
	}
	
	public static void main(String[] args) {
		Maze maze = new Maze(5, 5);
		maze.editor();
//		maze.display(map);
		
	}
}
