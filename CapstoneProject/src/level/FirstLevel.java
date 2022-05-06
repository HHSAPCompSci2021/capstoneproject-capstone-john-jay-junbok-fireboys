package level;

import sprites.Enemy;
import sprites.InvisCloak;
import sprites.Player;

/*
 * Author: Jay Dalal
 */
public class FirstLevel implements Level {
	
	private Enemy e; private InvisCloak i; private Obstacle wall;
	private Player p; //etc
	private boolean nextLevel = false;
	
	public FirstLevel () {
		p = new Player(0, 0); e = new Enemy(0, 0); i = new InvisCloak(0, 0);
		wall = new Obstacle(10,10);
	}
}
