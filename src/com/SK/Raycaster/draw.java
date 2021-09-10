package com.SK.Raycaster;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class draw extends JFrame {
	
	public draw() {
		setLayout(new BorderLayout());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFocusable(true);
		this.requestFocusInWindow(true);
		this.setTitle("RayCasterDemo");
		
		DrawStuff stuff = new DrawStuff();
		this.add(stuff, "Center");
		
		this.setSize(1600, 640);
		this.setResizable(false);
		
//		this.add(new JPanel(), BorderLayout.EAST);
		
		
		DrawStuff lolDrawStuff = new DrawStuff();
		
		
		this.addKeyListener(new KeyListener() {
			int turning = (int) ((45*Math.PI)/180);
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				switch (e.getKeyCode()) {
				case KeyEvent.VK_A:
//					lolDrawStuff.xPos -= 5;
					break;
				case KeyEvent.VK_D:
//					lolDrawStuff.xPos += 5;
					break;
				case KeyEvent.VK_W:
//					lolDrawStuff.xPos += 5*Math.cos(turning);
//					lolDrawStuff.yPos += 5*Math.sin(turning);
//					lolDrawStuff.yPos -= 5;
					
					break;
				case KeyEvent.VK_S:
//					lolDrawStuff.yPos += 5;
					break;
				case KeyEvent.VK_RIGHT:
					lolDrawStuff.turn += 2;
					turning += 5;
					break;
				case KeyEvent.VK_LEFT:
					lolDrawStuff.turn -= 2	;
					turning -= 5;
					break;
				default:
					break;
				}
				lolDrawStuff.repaint();
				
			}
		});
		
		
		
		this.add(lolDrawStuff, BorderLayout.CENTER);
		this.setVisible(true);
		
	}
	
	@SuppressWarnings("serial")
	public class DrawStuff extends JComponent{
		
		Shape aShape;
		Point mouseLocation;
		int xPos;
		int yPos;
		int turn;
		
		ArrayList<java.lang.Float> boundaryValues;
		public  DrawStuff() {
			this.setFocusable(true);
			this.requestFocusInWindow(true);
			this.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseMoved(MouseEvent e) {
//					System.out.println("YUS");
					mouseLocation = e.getPoint();
					if (mouseLocation.x >= 800 || mouseLocation.y >= 600) {
						mouseLocation.x = 400;
						mouseLocation.y = 300;
						repaint();
					}else {
						repaint();
					}
					
				}
			});
			
			
			
			
			
			boundaryValues = new ArrayList<java.lang.Float>();
			for (int i = 0; i < 10; i++) {
			boundaryValues.add((float) Math.random() * 800 - 400);
			boundaryValues.add((float) Math.random() * 600 - 300);
			boundaryValues.add((float) Math.random() * 800 - 400);
			boundaryValues.add((float) Math.random() * 600 - 300);
			}
			
		}
		
		
		
		@Override
		public void paint(Graphics g) {

			
			Graphics2D graphics2d = (Graphics2D)g;
			
//			graphics2d.translate(JFrame.WIDTH/2, JFrame.HEIGHT/2);
//			graphics2d.scale(1.0, 1.0);
			graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			
			
			Shape rectangleShape = new Rectangle2D.Float(0, 0, getWidth(), getHeight());
			graphics2d.setColor(Color.BLACK);
			graphics2d.fill(rectangleShape);
			Shape rectangleShape1 = new Rectangle2D.Float(800, 0, getWidth()/2, getHeight());
			graphics2d.setColor(Color.gray);
			graphics2d.fill(rectangleShape1);
			Shape rectangleShape2 = new Rectangle2D.Float(800, 300, getWidth()/2, getHeight());
			graphics2d.setColor(Color.darkGray);
			graphics2d.fill(rectangleShape2);
			
			
			graphics2d.setPaint(Color.WHITE);
			
//			graphics2d.setBackground(Color.BLACK);
			
//			boundary wall = new boundary(200, 300, 150, 450);
//			boundary wall = new boundary(PositionCorrector(-100f, 'X'), PositionCorrector(-100f, 'Y'),
//					PositionCorrector(-100f, 'X'), PositionCorrector(100f, 'Y'));
			ArrayList<boundary> arrayListofBoundaries = new ArrayList<boundary>();
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < boundaryValues.size(); j = j + 4) {
					arrayListofBoundaries.add(new boundary(PositionCorrector((boundaryValues.get(j)), 'X'),
							PositionCorrector(boundaryValues.get(j+1) , 'Y'),
							PositionCorrector(boundaryValues.get(j+2), 'X'),
							PositionCorrector(boundaryValues.get(j+3), 'Y')));
					Shape shapeBoundary= new Line2D.Double(arrayListofBoundaries.get(i).xPoint1, arrayListofBoundaries.get(i).yPoint1,
							arrayListofBoundaries.get(i).xPoint2, arrayListofBoundaries.get(i).yPoint2);
					graphics2d.draw(shapeBoundary);
					
				}
				boundary wall = new boundary(PositionCorrector((-400), 'X'),
				PositionCorrector(-300 , 'Y'),
				PositionCorrector(-400, 'X'),
				PositionCorrector(300, 'Y'));
				arrayListofBoundaries.add(wall);
//		Shape shapeBoundary2 = new Line2D.Double(wall1.xPoint1, wall1.yPoint1, wall1.xPoint2, wall1.yPoint2);
//		graphics2d.draw(shapeBoundary2);
		
		boundary wall1 = new boundary(PositionCorrector((-400), 'X'),
				PositionCorrector(300 , 'Y'),
				PositionCorrector(400, 'X'),
				PositionCorrector(300, 'Y'));
		arrayListofBoundaries.add(wall1);
//		Shape shapeBoundary3 = new Line2D.Double(wall1.xPoint1, wall1.yPoint1, wall1.xPoint2, wall1.yPoint2);
//		graphics2d.draw(shapeBoundary3);
		
		boundary wall2 = new boundary(PositionCorrector((400), 'X'),
				PositionCorrector(300 , 'Y'),
				PositionCorrector(400, 'X'),
				PositionCorrector(-300, 'Y'));
		arrayListofBoundaries.add(wall2);
//		Shape shapeBoundary4 = new Line2D.Double(wall1.xPoint1, wall1.yPoint1, wall1.xPoint2, wall1.yPoint2);
//		graphics2d.draw(shapeBoundary4);
		
		boundary wall3 = new boundary(PositionCorrector((400), 'X'),
				PositionCorrector(-300 , 'Y'),
				PositionCorrector(-400, 'X'),
				PositionCorrector(-300, 'Y'));
		arrayListofBoundaries.add(wall3);
//		Shape shapeBoundary5 = new Line2D.Double(wall1.xPoint1, wall1.yPoint1, wall1.xPoint2, wall1.yPoint2);
//		graphics2d.draw(shapeBoundary5);

				
			}
			
//			particle rayParticle = new particle(mouseLocation.x, mouseLocation.y);
			particle rayParticle = new particle(mouseLocation.x, mouseLocation.y, turn);
			
			float[] scene = new float[901];
			
			for (int k = 0; k < rayParticle.arrayListofRays.size(); k++) {
				
				float dist;
				float record = 1000000000;
				float closestX = -1000;
				float closestY = -1000;
				
				ray r = rayParticle.arrayListofRays.get(k);
				Shape shapeRayShape = new Line2D.Double(r.originX,r.originY,r.maxX,r.maxY);
				graphics2d.setPaint(Color.RED);
				graphics2d.draw(shapeRayShape);
				for (int l = 0; l < arrayListofBoundaries.size(); l++) {
					if (r.cast(arrayListofBoundaries.get(l))) {
						dist = r.distCalc(r.intendedOriginX, r.intendedOriginY, r.intendedPointX, r.intendedPointY);
						if (dist <record) {
							record = dist;
							closestX = r.intendedPointX;
							closestY = r.intendedPointY;
						}
					}
				}
				if (closestX != -1000f) {
					Shape lineCollision = new Line2D.Float(mouseLocation.x, mouseLocation.y, 
							PositionCorrector(closestX, 'X'), PositionCorrector(closestY, 'Y'));
					graphics2d.draw(lineCollision);
				}
				scene[k] = record;
			
			}
			
//			System.out.println(scene.length);
			float w = 800f/ scene.length;
//			System.out.println(w);
//			System.out.println(scene.length);
			for (int i = 0; i < scene.length; i++) {
				int lineHeight = (int) (600/scene[i]*25);
//				System.out.println(lineHeight);
				if (lineHeight > 600) {
					lineHeight = 600;
				}
				int drawStartY = 300-(lineHeight/2);
				Shape newDrawShape = new Rectangle2D.Float(i*w + 800, drawStartY, w+1f, lineHeight);
				graphics2d.setColor(colorCreator(scene, scene[i]));
				graphics2d.fill(newDrawShape);
			}
				
		}			
			
	}
		
		public float PositionCorrector(float value, char XorY) {
			if (XorY == 'X') {
				value = 400 + value;
//				return value;
				
			} else if (XorY == 'Y') {
				value = 300 - value;
//				return value;
			}
			return value;
		}
		
		public Color colorCreator(float[] distArray, float dist) {
//			System.out.println(dist);
//			float depth = (float) (1000/Math.pow(dist+32, 2));
			System.out.println(dist);
			float depth = (float) (1/Math.pow(0.01 * dist + 1, 2) - 0.0003*dist + 0.25f);
			Color disColor;
//			System.out.println(depth);
//			float depth = 1 -0.001f*dist;
			if (depth > 1) {
				depth =1;
			}
			if (depth < 0) {
				depth = 0;
			}
			if (true) {
				disColor= new Color(0f * depth, 0.2f * depth , depth);
			}
			
//			System.out.println(depth);
			return disColor;
		}
		
	public static void main(String[] args) {
		new draw();
		
	}

}

