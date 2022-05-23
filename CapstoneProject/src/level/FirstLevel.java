package level;

import java.util.ArrayList;

import main.DrawingSurface;
import processing.core.PImage;
import screen.GameScreen;
import sprites.Enemy;
import sprites.InvisCloak;
import sprites.Player;

/**
 * This class represents the first level the the player must undergo in the game
 * @author John Tahk
 * @version 05/06/2022
 */
public class FirstLevel extends Level {
	private DrawingSurface surface;
	private PImage background;
	
	
	/**
	 * Constructs a First Level class by creating the obstacles and materials of the Level.
	 * @param filename string with the filename.
	 */
	public FirstLevel (DrawingSurface surface) {
		super("mazefiles/level1.txt", 600, 800); addInvisCloak(new InvisCloak(130,50)); 
		this.surface = surface;
		addInvisCloak(new InvisCloak(185,400)); addInvisCloak(new InvisCloak(300,375)); 
		addInvisCloak(new InvisCloak(750,375)); addInvisCloak(new InvisCloak(750, 100));
		addMonster(new Enemy(275,75)); addMonster(new Enemy(175,150));
		addMonster(new Enemy(500,75)); addMonster(new Enemy(600,160));
		addMonster(new Enemy(750,300)); addMonster(new Enemy(50,325));
		addMonster(new Enemy (150,350)); addMonster(new Enemy(300,130));
	}	
	
	public void setup() {
		background = surface.loadImage("img/level_one.png");
	}
	
	public void draw() {
		surface.image(background, 0, 0, 800, 600);
		/*
		for (Enemy e : super.getMonsters()) {
			e.draw();
		}
		*/
		for (InvisCloak i : super.getInvisCloaks()) {
			i.draw(surface);
		}
	}
	
	/**
	 * Getter method for walls
	 * @return walls 2-d character array representing wall positions
	 */
	public char[][] getWalls() {
		return super.getWalls();
	}
	
	/**
	 * Getter method that gets the monsters
	 * @return ArrayList<Enemy> ArrayList that contains the monsters
	 */
	public ArrayList<Enemy> getMonsters() {
		return super.getMonsters();
	}
	/**
	 * Getter method for invisCloaks
	 * @return inviscloaks ArrayList of invisCloaks
	 */
	public ArrayList<InvisCloak> getInvisCloaks() {
		return super.getInvisCloaks();
	}
}
