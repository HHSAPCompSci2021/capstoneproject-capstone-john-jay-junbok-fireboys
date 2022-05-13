package sprites;

import main.DrawingSurface;

/**
 * This class represent the player will the user will controll.
 * 
 * @author junbok lee
 * @version 05/06/2022
 *
 */
public class Player extends Sprite {
	
	private boolean isInvis;
	private boolean hasKey;
	
	/**
	 * Constructs the Player with given coordinates.
	 * 
	 * @param x x coordinate of the player
	 * @param y y coordinate of the player
	 */
	public Player(double x, double y) {
		super(x, y, 25, 25);
		isInvis = false;
		hasKey = false;
	}
	
	public void draw(DrawingSurface s) {
		s.fill(0, 0, 255);
		s.ellipse((float)super.getX(), (float)super.getY(), (float)25, (float)25);
	}
	
	public void pickUpObject(Sprite obj) {
		// turns player invisible for 5 sec if they pick up the invis cloak
		// sets hasKey to true if the player picks up the key
	}
	
	public boolean isInvis() {
		return isInvis;
	}
	
	public boolean hasKey() {
		return hasKey;
	}
}
