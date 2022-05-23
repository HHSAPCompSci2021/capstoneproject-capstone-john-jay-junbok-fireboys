package sprites;

import level.Level;
import processing.core.PImage;
import screen.GameScreen;

/**
 * This class extends Sprite and represents an enemy which will attack the player until specific circumstances.
 * 
 * @author junbok lee
 * @version 05/13/2022
 */
public class Enemy extends Sprite {
	
    
	/**
	 * Constructs an Enemy with given x and y coordinates.
	 * 
	 * @param x x coordinate of the Enemy
	 * @param y y coordinate of the Enemy
	 */
	public Enemy (PImage image, double x, double y) {
		super(image, x, y, 25, 25);
	}
	
	
}
