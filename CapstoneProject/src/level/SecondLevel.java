package level;

import sprites.Enemy;
import sprites.InvisCloak;
import sprites.Player;
import sprites.Zombie;

/**
 * This class represents the second level of the game
 * @author johntahk
 * @version 05/20/22
 *
 */
public class SecondLevel extends Level {
	
	/**
	 * Constructs a Second Level class by creating the obstacles and materials of the Level, including enemies, zombies, and invisbility cloaks.
	 * @param filename string with the filename.
	 */
	public SecondLevel() {
		super("mazefiles/level2.txt");
		addMonster(new Enemy(null, 700, 600));
		
		addMonster(new Enemy(null, 750, 100));
		addMonster(new Enemy(null, 700, 150));
		addMonster(new Enemy(null, 750, 200));
		addMonster(new Enemy(null, 700, 250));
		addMonster(new Enemy(null, 750, 300));
		addMonster(new Enemy(null, 500, 325));
		addMonster(new Enemy(null, 125, 450));
		
		addMonster(new Zombie(null, 325, 125));
		addMonster(new Zombie(null, 330, 450));
		addMonster(new Zombie(null, 100, 200));

		
		
		addInvisCloak(new InvisCloak(null, 630, 500));
		addInvisCloak(new InvisCloak(null, 500, 475));
		addInvisCloak(new InvisCloak(null, 350, 250));
		addInvisCloak(new InvisCloak(null, 500, 50));
		addInvisCloak(new InvisCloak(null, 50, 250));
		
	}
}
