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
	

	/**
	 * Constructs a GameScreen by setting the width to 600 and height to 800 and assigning the Drawing that uses this Screen to s.
	 * @param s The DrawingSurface that utilizes the screen
	 */
	public GameScreen(DrawingSurface s) {
		super(800,600);
		this.s = s;
	}
	
	public void draw(Level a) {
		
		s.background(255);
		
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

		
		
	}

}
