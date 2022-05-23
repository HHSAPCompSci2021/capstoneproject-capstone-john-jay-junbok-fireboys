package sprites;

import java.util.ArrayList;


import jdalal464.shapes.*;
import level.Level;
import main.DrawingSurface;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class represent the player will the user will control.
 * 
 * @author junbok lee
 * @version 05/13/2022
 *
 */
public class Player extends Sprite {
	
	private boolean isInvis;
	private boolean isAlive;
	private Level a;
	private long timer;
	private static final long invisCloakTime = 5000000000L;
	PImage invisImage;
	
	/**
	 * Constructs the Player with given coordinates.
	 * 
	 * @param x x coordinate of the player
	 * @param y y coordinate of the player
	 */
	public Player(PImage image, PImage invisImage, double x, double y, Level a) {
		super(image, x, y, 25, 25);
		isInvis = false;
		isAlive = true;
		this.a = a;
		this.invisImage = invisImage;
	}
	
	
	
	private boolean invisChecker() {
		if (isInvis) {
			if ((System.nanoTime() - timer) > invisCloakTime) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
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
			timer = System.nanoTime();
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
	
	
	public void draw(PApplet g) {
		isInvis = invisChecker();
		if (image != null && isInvis == false) {
			g.image(image,(float)x,(float)y,(float)width,(float)height);
		} else if (image != null && isInvis) {
			g.image(invisImage, (float)x,(float)y,(float)width,(float)height);
		} else {
			g.fill(100);
			g.rect((float)x,(float)y,(float)width,(float)height);
		}
	}
	
	
}
