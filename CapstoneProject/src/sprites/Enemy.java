package sprites;
/**
 * This class extends Sprite and represents an enemy which will attack the player until specific circumstances.
 * 
 * @author junbok lee
 * @version 05/06/2022
 */
public class Enemy extends Sprite {
	/**
	 * Constructs an Enemy with given x and y coordinates.
	 * 
	 * @param x x coordinate of the Enemy
	 * @param y y coordinate of the Enemy
	 */
	public Enemy (double x, double y) {
		super(x, y, 25, 25);
	}
	
	/**
	 * Moves the Enemy to the given coordinates.
	 */
	public void moveTo(double x, double y) {
		
	}
	
	/**
	 * Moves the Enemy by the given lengths.
	 */
	public void moveBy(double x, double y) {
		
	}
	
	/**
	 * Attacks the player under specific circumstances.
	 */
	public void attack() {
		
	}
}
