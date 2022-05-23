package sprites;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import screen.GameScreen;

/**
 * This class represents a new monster that follows the main character
 * 
 * @author johntahk
 */
public class Zombie extends Enemy { // give in player
	private double xo, yo;
	int speed = 3;
	private boolean sentry;
	private boolean isForward;

	/**
	 * Default constructor that takes in the location of the zombie as well as the
	 * player object
	 * 
	 * @param x X coordinates
	 * @param y Y coordinates
	 * @param p Player object
	 */
	public Zombie(PImage image, double x, double y, boolean sentry) {
		super(image, x, y);
		xo  = x;
		this.sentry = sentry;
		isForward = true;
		move();
		// TODO Auto-generated constructor stub
	}

	// inherited methods: moveTo, moveBy, need to modify attack
	/**
	 * This method initiates the action of the enemy, where it chases or moves.
	 */
	public void move() {
		if (sentry) {
			sentryMove();
		} else {
			randomMove();
		}
	}

	public void sentryMove() {
		System.out.println(getX() + " " + getY());
		if (getX() <= xo) {
			setCoords(getX() + 3, getY());
			isForward = true;
		} else if (getX() > xo && getX() - xo < 50 && isForward) {
			setCoords(getX() + 3, getY());
		} else if (getX() > xo && getX() - xo >= 50 || !isForward) {
			setCoords(getX() - 3, getY());
			isForward = false;
		}

	}

	public void randomMove() {
		int[] arr = { -2, 2, 0, -1, 1 };
		int xd = (int) (Math.random() * 5);
		int yd = (int) (Math.random() * 5);
//		moveBy(arr[xd], arr[yd]);
	}
	/**
	 * Returns true if it chased the player
	 */
	/*
	 * public boolean chase() { double deltax = c.getX() - super.getX(); double
	 * deltay = c.getY() - super.getY();
	 * 
	 * if (Math.abs(deltax) < 8 && Math.abs(deltay) < 8) { if (deltax < 0) deltax =
	 * -2; if (deltay < 0) deltay = -2; if (deltax > 0) deltax = 2; if (deltay > 0)
	 * deltay = 2; moveBy(deltax, deltay); return true; } // if (super.getIsInvis ==
	 * true); return false; }
	 */
	
}
