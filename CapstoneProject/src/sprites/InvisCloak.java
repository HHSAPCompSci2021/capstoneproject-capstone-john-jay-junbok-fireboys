package sprites;

/**
 * This class extends Sprite and represents a stationary object which the player can pick up to turn invisible.
 * 
 * @author junbok lee
 * @version 05/06/2022
 */
public class InvisCloak extends Sprite {
	
	private final static double SIDE_LENGTH = 5;
	
	/**
	 * Constructs a InvisCloak with the given x and y coordinates.
	 * 
	 * @param x x coordinate of the InvisCloak
	 * @param y y coordinate of the InvisCloak
	 */
	public InvisCloak(double x, double y) {
		super(x, y, SIDE_LENGTH, SIDE_LENGTH);
	}
	
}
