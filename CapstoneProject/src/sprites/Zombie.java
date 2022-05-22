package sprites;

import java.util.ArrayList;

import processing.core.PApplet;
import screen.GameScreen;

/**
* This class represents a new monster that follows the main character
* @author johntahk
*/
public class Zombie extends Enemy { //give in player
	int xo, yo; int speed = 3;
	boolean sentry;
	boolean leftright;
	/**
	 * Default constructor that takes in the location of the zombie as well as the player object
	 * @param x X coordinates
	 * @param y Y coordinates
	 * @param p Player object
	 */
	public Zombie(double x, double y, boolean sentry, boolean horizontal) {
		super(x, y);
		this.sentry = sentry;
		this.leftright = horizontal;
		move();
		// TODO Auto-generated constructor stub
	}
	//inherited methods: moveTo, moveBy, need to modify attack
	/**
	 * This method initiates the action of the enemy, where it chases or moves.
	 */
	public void move() {
		if (sentry) {
			sentryMove();
		}
		else {
			randomMove();
		}
	}
	public void sentryMove() {
		if (leftright) {
				if (speed > 0 && (getX() - xo) < 8) {
					moveBy(speed, 0);
				}
				else if (speed > 0 && (getX() - xo) >= 8) {
					speed*= -1;
					moveBy (speed, 0);
				}
				else if (speed < 0 && (getX() - xo) < 8) {
					moveBy(speed,0);
				}
				else {
					speed *= -1;
					moveBy(speed,0);
				}
		}
		else {
			if (speed > 0 && (getY() - yo) < 8) {
				moveBy(0, speed);
			}
			else if (speed > 0 && (getY() - yo) >= 8) {
				speed*= -1;
				moveBy (0, speed);
			}
			else if (speed < 0 && (getY() - yo) < 8) {
				moveBy(0, speed);
			}
			else {
				speed *= -1;
				moveBy(0, speed);
			}
		}
	}
	
	public void randomMove() {
		int[] arr = {-2,2, 0, -1 , 1};
		int xd = (int) (Math.random() * 5);
		int yd = (int) (Math.random() * 5);
		moveBy (arr[xd], arr[yd]);
	}
	/**
	 * Returns true if it chased the player
	 */
/*	public boolean chase() {
		double deltax = c.getX() - super.getX();
		double deltay = c.getY() - super.getY();
		
		if (Math.abs(deltax) < 8 && Math.abs(deltay) < 8) {
			if (deltax < 0) deltax = -2;
			if (deltay < 0) deltay = -2;
			if (deltax > 0) deltax = 2;
			if (deltay > 0) deltay = 2;
			moveBy(deltax, deltay);
			return true;
		}
	//	if (super.getIsInvis == true);
		return false;
	}
	*/
}
