package level;

import java.util.ArrayList;

import jdalal464.shapes.Rectangle;
import sprites.Enemy;
import sprites.InvisCloak;
import sprites.Player;

/*
 * This class repreents the first level the the player must undergo in the game
 * @author John Tahk
 * @version 05/06/2022
 */
public class FirstLevel extends Level {
	
	private Enemy e; private InvisCloak i; private Obstacle wall;
	private Player p; //etc
	private boolean nextLevel = false;
	/**
	 * Constructs a First Level class by creating the obstacles and materials of the Level.
	 * @param filename string with the filename.
	 */
	public FirstLevel (String filename) {
		super(filename, 600, 800);
		ArrayList<InvisCloak> invisC = getInvisCloaks();
		invisC.add(new InvisCloak(130,50)); invisC.add(new InvisCloak(175,400));
		invisC.add(new InvisCloak(300,375)); invisC.add(new InvisCloak(750,375));
//		p = new Player(0, 0); e = new Enemy(0, 0); i = new InvisCloak(0, 0);
		ArrayList<Enemy> enem = getMonsters();
		enem.add(new Enemy(275,75)); enem.add(new Enemy(175,150));
		enem.add(new Enemy(525,75)); enem.add(new Enemy(600,200));
		enem.add(new Enemy(750,300)); enem.add(new Enemy(50,325));
		enem.add(new Enemy (150,350)); enem.add(new Enemy(300,13));
		wall = new Obstacle(10,10);
	}
	/**
	 * Getter method
	 * @return super.getWalls() with the locations of walls
	 */
	public char[][] getWalls() {
		return super.getWalls();
	}
	/**
	 *Getter method that gets the obstacles
	 * @return super.getObstacles() an arraylist of type obstacles that locates obstacles
	 */
	public ArrayList<Rectangle> getObstacles() {
		return super.getObstacles();
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
