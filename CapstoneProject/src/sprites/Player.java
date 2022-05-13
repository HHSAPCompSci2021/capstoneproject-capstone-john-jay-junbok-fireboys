package sprites;

import java.util.ArrayList;

import jdalal464.shapes.*;
import level.Level;
import level.Obstacle;
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
	private boolean canMove;
	private Level a;
	private double xVel, yVel;
	
	/**
	 * Constructs the Player with given coordinates.
	 * 
	 * @param x x coordinate of the player
	 * @param y y coordinate of the player
	 */
	public Player(double x, double y, Level a) {
		super(x, y, 25, 25);
		isInvis = false;
		hasKey = false;
		this.a = a;
	}
	
	public void draw(DrawingSurface s) {
		s.fill(0, 0, 255);
		s.rect((float)super.getX(), (float)super.getY(), (float)25, (float)25);
	}
	
	public void act(ArrayList<InvisCloak> cloaks, ArrayList<Rectangle> obstacles) {
		yVel += 0.3;
		x += xVel;
		y += yVel;
		
		for (InvisCloak s : cloaks) {
			s.pickUp();
			isInvis = true;
		}
		for (Rectangle o : obstacles) {
			if (super.getHitbox().isTouching(o)) {
				canMove = false;
				yVel = 0;
				xVel = 0;
			}
		}
	}
	
	public void move(double x, double y) {
		if (canMove) {
			this.x += x;
			this.y += y;
		}
	}
	
	
}
