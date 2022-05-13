package level;

/**
 * This class represents an non-Enemy obstacles in the game.
 * @author John Tahk
 * @verison 05/06/2022
 *
 */
public class Obstacle {
	private double x,y;
	private boolean solid = false;
	
	/**
	 * Constructs a obstacles by setting the coordinates to x and y and setting the solidity of the object to true
	 * @param x x coordinate of the obstacle
	 * @param y y coordinate of the obstacle
	 */
	public Obstacle(double x, double y) {
		this.x = x;
		this.y = y;
		solid = true;
	}
	
	/**
	 * Causes an obstacles to fade away.
	 */
	public void fade() {
		
	}
}
