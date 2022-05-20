package screen;

import java.awt.Rectangle;


import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import jdalal464.shapes.*;

import level.FirstLevel;
import level.Level;
import main.DrawingSurface;
import processing.core.PGraphics;
import processing.core.PImage;
import sprites.Enemy;
import sprites.InvisCloak;
import sprites.Player;
import sprites.Sprite;

/**
 * This class represents a Game Screen, which is the screen that the interactive game appears on
 * @author jaydalal
 * @version 05/13/2022
 *
 */
public class GameScreen extends Screen {

	private DrawingSurface s;
	private Rectangle screenRect;
	private Player player;
	private Level a;

	
	
	
	/**
	 * Constructs a GameScreen by setting the width to 600 and height to 800 and assigning the Drawing that uses this Screen to s.
	 * @param s The DrawingSurface that utilizes the screen
	 */
	public GameScreen(DrawingSurface s, Level level) {
		super(800,600);
		this.s = s;
		player = new Player(700, 550, level);
		this.a = level;
		
	}
	
	/**
	 * Draws the game screen by displaying the blueprint (walls and pillars), the obstacles of the game (including the monster), and generating the player
	 */
	public void draw() {
		
		movePlayer();
		char[][] blueprint = a.getWalls();

		
		float boxHeight = 600 / blueprint.length;
		float boxWidth = 800 / blueprint[0].length;
		
		for (int i = 0; i < blueprint.length; i++) {
			for (int j = 0; j < blueprint[i].length; j++) {
				if (blueprint[i][j] == '.') {
					s.fill(255);
					s.stroke(255);
					s.rect(boxWidth * j, boxHeight * i, boxWidth, boxHeight);
				} else if (blueprint[i][j] == '#') {
					s.fill(0);
					s.stroke(0);
					s.rect(boxWidth * j, boxHeight * i, boxWidth, boxHeight);
				} else if (blueprint[i][j] == '!') {
					s.fill(0);
					if (blueprint[i + 1][j] == '!' && blueprint[i][j + 1] == '!' && blueprint[i + 1][j + 1] == '!') {
						s.circle(boxWidth * (j + 1), boxHeight * (i + 1), boxWidth * 2);
					}
				}
				
			}
		}
		
		
		addStuff(a, boxWidth);
		player.act();
		player.draw(s);
		if (!player.isAlive()) {
			s.switchScreen(0);
			System.out.println("Dead (This is in GameScreen class)");
		}
		
		PGraphics fogMask = createFogMask( (float) player.getX(), (float) player.getY(), 300);
		s.image(fogMask,0,0);

		
	}
	
public PGraphics createFogMask(float x, float y, int dim) {
		
		PGraphics visionMask = s.createGraphics(DRAWING_WIDTH, DRAWING_HEIGHT);

		visionMask.beginDraw();
		visionMask.background(255);
		visionMask.noStroke();
		for (int r = dim; r > 0; r--) {
			visionMask.fill(r*255/dim);
			visionMask.ellipse(x, y, r, r);
		}
		visionMask.endDraw();
		
		PGraphics fogMask = s.createGraphics(DRAWING_WIDTH, DRAWING_HEIGHT);
		fogMask.beginDraw();
		fogMask.background(0);
		fogMask.endDraw();
		fogMask.mask(visionMask);
		
		return fogMask;
	}
	
	private void movePlayer() {
		if (s.isPressed(KeyEvent.VK_LEFT)) {
			player.move(-5, 0);
		}	
		if (s.isPressed(KeyEvent.VK_RIGHT)) {
			player.move(5, 0);
		}
		if (s.isPressed(KeyEvent.VK_UP)) {
			player.move(0, -5);
		}
		if (s.isPressed(KeyEvent.VK_DOWN)) {
			player.move(0, 5);
		}	
	}
	
	private void addStuff(Level a, float radius) {
		
		for (InvisCloak n : a.getInvisCloaks()) {
			s.fill(0, 255, 0);
			s.rect((float) n.getX(), (float) n.getY(), radius, radius);
		}
		for (Enemy x : a.getMonsters()) {
			s.fill(255, 0, 0);
			s.rect((float) x.getX(), (float) x.getY(), radius, radius);

		}
		
	}
	
	/**
	 * Returns the player of the game screen
	 * @return the player of the game screen
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * Returns the level of the game screen
	 * @return the level of the game screen
	 */
	public Level getLevel() {
		return a;
	}

}
