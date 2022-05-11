package screen;

import java.awt.Rectangle;

import java.awt.Shape;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import level.FirstLevel;
import level.Level;
import level.Obstacle;
import main.DrawingSurface;
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
	private ArrayList<Obstacle> obstacles;
	private int r, g, b;
	

	/**
	 * Constructs a GameScreen by setting the width to 600 and height to 800 and assigning the Drawing that uses this Screen to s.
	 * @param s The DrawingSurface that utilizes the screen
	 */
	public GameScreen(DrawingSurface s) {
		super(800,600);
		this.s = s;
		r = (int) (Math.random() * 255);
		g = (int) (Math.random() * 255);
		b = (int) (Math.random() * 255);
	}
	
	public void draw(Level a) {
		
		s.background(r, g, b);
		
		char[][] blueprint = a.getWalls();
		
		float boxHeight = 600 / blueprint.length;
		float boxWidth = 800 / blueprint[0].length;
		
		for (int i = 0; i < blueprint.length; i++) {
			for (int j = 0; j < blueprint[i].length; j++) {
				if (blueprint[i][j] == '.') {
					s.fill(255);
				} else if (blueprint[i][j] == '#') {
					s.fill(0);
				} 
				s.rect(boxWidth * j, boxHeight * i, boxWidth, boxHeight);
			}
		}

		
		
	}

}
