package level;

import java.util.ArrayList;

import processing.core.PImage;
import screen.GameScreen;
import sprites.Enemy;
import sprites.InvisCloak;
import sprites.Player;
import sprites.Zombie;

/**
 * This class represents the first level the the player must undergo in the game
 * @author John Tahk
 * @version 05/20/2022
 */
public class FirstLevel extends Level {
	
	
	/**
	 * Constructs a First Level class by creating the obstacles and materials of the Level, including enemies and invisibility cloaks.
	 * @param filename string with the filename.
	 */
	public FirstLevel () {
		super("mazefiles/level1.txt"); 
		addInvisCloak(new InvisCloak(null, 130,50)); 
		addInvisCloak(new InvisCloak(null, 185,400)); 
		addInvisCloak(new InvisCloak(null, 300,375)); 
		addInvisCloak(new InvisCloak(null, 750,375)); 
		addInvisCloak(new InvisCloak(null, 750, 100));
		addMonster(new Enemy(null, 275,75)); 
		addMonster( new Enemy(null, 175,150));
		addMonster(new Enemy(null, 500,75)); 
		addMonster(new Enemy(null, 600,160));
		addMonster(new Enemy(null, 750,300)); 
		addMonster(new Enemy(null, 50,325));
		addMonster(new Enemy (null, 150,350)); 
		addMonster(new Enemy(null, 300,130));
			
	}	

}
