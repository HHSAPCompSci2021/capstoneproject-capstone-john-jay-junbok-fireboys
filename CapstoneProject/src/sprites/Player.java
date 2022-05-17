package sprites;

import java.util.ArrayList;


import jdalal464.shapes.*;
import level.Level;
import main.DrawingSurface;

/**
 * This class represent the player will the user will controll.
 * 
 * @author junbok lee
 * @version 05/13/2022
 *
 */
public class Player extends Sprite {
	
	private boolean isInvis;
	private boolean isAlive;
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
		isAlive = true;
		this.a = a;
	}
	
	/**
	 * Draws the player on the screen.
	 * 
	 * @param s PApplet which the Player will be drawn on
	 */
	public void draw(DrawingSurface s) {
		if (!isAlive) {
			System.out.println("dead");
		}
		
		
		if (!isInvis) {
			s.fill(0, 0, 255);
		} else {
			s.fill(255, 0, 255);
		}
		
		
		s.rect((float)super.getX(), (float)super.getY(), (float)25, (float)25);
	}
	
	/**
	 * Determines the behavior of the Player based on interactions with other objects on the screen.
	 */
	public void act() {
		
		int invisCloakIndex = -1;
		int monsterIndex = -1;

		for (InvisCloak s : a.getInvisCloaks()) {
			if (super.getHitbox().isTouching(s.getHitbox())) {
				s.pickUp();
				isInvis = true;
				invisCloakIndex = a.getInvisCloaks().indexOf(s);
				break;
			}
		}
		
		if (invisCloakIndex >= 0) {
			a.removeInvisCloak(invisCloakIndex);
		}
		
		
		for (Enemy m : a.getMonsters()) {
			if (super.getHitbox().isTouching(m.getHitbox())) {
				if (!isInvis) {
					isAlive = false;
				} else {
					monsterIndex = a.getMonsters().indexOf(m);
				}
				break;
			}
		}
		
		if (monsterIndex >= 0) {
			a.removeMonster(monsterIndex);
		}
		
	}
	
	/**
	 * Moves the player by the x and y values specified.
	 * 
	 * @param x value to change the x coordinate by
	 * @param y value to change the y coordinate by
	 */
	public void move(double x, double y) {
		this.x += x;
		this.y += y;
		
		Rectangle r = this.getHitbox();
		for (Rectangle o : a.getObstacles()) {
			if (super.getHitbox().isTouching(o)) {				
				this.x -= x;
				this.y -= y;
				
				break;

			}
			
		}
		

	}
	

	
	/**
	 * Returns if the player is alive.
	 * 
	 * @return true if the player is alive, false otherwise
	 */
	public boolean isAlive() {
		return isAlive;
	}
	
	
}
