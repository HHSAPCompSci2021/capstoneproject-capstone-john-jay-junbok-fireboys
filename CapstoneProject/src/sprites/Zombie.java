package sprites;

import processing.core.PApplet;

/**
* This class represents a new monster that follows the main character
* @author johntahk
*/
public class Zombie extends Enemy { //give in player
	int xo, yo; int speed = 3;
	Player c;
	public Zombie(double x, double y, Player p) {
		super(x, y);
		c = p;
		
		move();
		// TODO Auto-generated constructor stub
	}
	//inherited methods: moveTo, moveBy, need to modify attack
	
	public void move() {
		boolean f = chase();
		if (!f) {
			if (speed > 0 && (getX() - xo) < 15) {
				moveBy(speed, 0);
			}
			else if (speed > 0 && (getX() - xo) >= 15) {
				speed*= -1;
				moveBy (speed, 0);
			}
			else if (speed < 0 && (getX() - xo) < 15) {
				moveBy(speed,0);
			}
			else {
				speed *= -1;
				moveBy(speed,0);
			}
		}
	}
	/**
	 * Returns true if it chased
	 */
	public boolean chase() {
		double deltax = c.getX() - super.getX();
		double deltay = c.getY() - super.getY();
		
		if (Math.abs(deltax) < 15 && Math.abs(deltay) < 15) {
			if (deltax < 0) deltax = -3;
			if (deltay < 0) deltay = -3;
			if (deltax > 0) deltax = 3;
			if (deltay > 0) deltay = 3;
			moveBy(deltax, deltay);
		}
	//	if (super.getIsInvis == true);
		return false;
	}
}
