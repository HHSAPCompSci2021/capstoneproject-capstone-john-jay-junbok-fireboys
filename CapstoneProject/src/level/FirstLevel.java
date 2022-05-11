package level;

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
	 * Constructs a First Level classm by creating the obstacles and materials of the Level.
	 */
	public FirstLevel (String filename) {
		super(filename, 600, 800);
//		p = new Player(0, 0); e = new Enemy(0, 0); i = new InvisCloak(0, 0);
		wall = new Obstacle(10,10);
	}
}
