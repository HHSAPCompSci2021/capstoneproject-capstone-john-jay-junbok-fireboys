package sprites;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class extends Sprite and represents a stationary object which the player can pick up to turn invisible.
 * 
 * @author junbok lee
 * @version 05/13/2022
 */
public class InvisCloak extends Sprite {
	
	private final static float SIDE_LENGTH = 25;
	private boolean isPickedUp;
	/**
	 * Constructs a InvisCloak with the given x and y coordinates.
	 * 
	 * @param x x coordinate of the InvisCloak
	 * @param y y coordinate of the InvisCloak
	 */
	public InvisCloak(PImage image, double x, double y) {
		super(image, x, y, SIDE_LENGTH, SIDE_LENGTH);
		isPickedUp = false;
	}

	
	/**
	 * Picks up the InvisCloak and sets isPickedUp to true.
	 */
	public void pickUp() {
		if (isPickedUp == false) {
			isPickedUp = true;	
		}
	}
	
	/**
	 * Returns whether the InvisCloak is picked up or not.
	 * 
	 * @return true if InvisCloak is picked up, false otherwise
	 */
	public boolean isPickedUp() {
		return isPickedUp;
	}
	
}
