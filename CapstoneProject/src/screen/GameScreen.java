package screen;

import java.awt.Rectangle;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import jdalal464.shapes.*;

import level.FirstLevel;
import level.Level;
import level.Obstacle;
import main.DrawingSurface;
import sprites.Enemy;
import sprites.InvisCloak;
import sprites.Player;
import sprites.Sprite;

/**
 * This class represents a Game Screen, which is the screen that the interactive game appears on
 * @author jaydalal
 * @version 05/05/2022
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
		player = new Player(750, 550);
		this.a = level;
	}
	
	public void draw() {
		
		s.background(255);
		
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
		player.act(a.getInvisCloaks(), a.getObstacles());
		player.draw(s);

		
	}
	
	private void movePlayer() {
		if (s.isPressed(KeyEvent.VK_LEFT)) {
			player.moveBy(-1, 0);
		}	
		if (s.isPressed(KeyEvent.VK_RIGHT)) {
			player.moveBy(1, 0);
		}
		if (s.isPressed(KeyEvent.VK_UP)) {
			player.moveBy(0, -1);
		}
		if (s.isPressed(KeyEvent.VK_DOWN)) {
			player.moveBy(0, 1);
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

}
