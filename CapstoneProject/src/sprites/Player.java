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
	private boolean isAlive;
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
		isAlive = true;
		this.a = a;
		canMove = true;
	}
	
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
	
	public void move(double x, double y) {
		if (canMove(x, y)) {
			this.x += x;
			this.y += y;
		} 
		
	
	}
	
	public boolean canMove(double x, double y) {		
		for (Rectangle o : a.getObstacles()) {
			if (super.getHitbox().isTouching(o)) {
				return false;
			}
		}
		
		return true;
	}
	
	
}
