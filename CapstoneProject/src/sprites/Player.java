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
		canMove = true;
	}
	
	public void draw(DrawingSurface s) {
		s.fill(0, 0, 255);
		s.rect((float)super.getX(), (float)super.getY(), (float)25, (float)25);
	}
	
	public void act(ArrayList<InvisCloak> cloaks, ArrayList<Rectangle> obstacles) {
//		for (Rectangle o : obstacles) {
//			if (super.getHitbox().isTouching(o)) {
//				canMove = false;
//			}
//		}
		for (InvisCloak s : cloaks) {
			if (super.getHitbox().isTouching(s.getHitbox())) {
				s.pickUp();
				isInvis = true;
			}
			
		}
		
	}
	
	public void move(double x, double y) {
		if (canMove(x, y)) {
			this.x += x;
			this.y += y;
		} 
		
	
	}
	
	public boolean canMove(double x, double y) {
		Rectangle b = super.getHitbox();
		b.moveBy(x, y);
				
		for (Rectangle o : a.getObstacles()) {
			if (b.isTouching(o)) {
				return false;
			}
		}
		
		return true;
	}
	
	
}
