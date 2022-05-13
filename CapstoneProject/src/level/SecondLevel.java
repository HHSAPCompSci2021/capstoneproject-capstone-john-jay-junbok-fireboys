package level;

import sprites.Enemy;
import sprites.InvisCloak;
import sprites.Player;

public class SecondLevel extends Level {
	
	private Enemy e; private InvisCloak i; private Obstacle wall;
	private Player p; //etc
	
	public SecondLevel() {
		super(null, 0, 0);
		p = new Player(0, 0); /*e = new Enemy(0,0); */ i = new InvisCloak(0, 0);
		wall = new Obstacle(10,10);
	}
}
