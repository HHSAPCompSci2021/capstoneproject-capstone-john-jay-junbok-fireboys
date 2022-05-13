package sprites;

import jdalal464.shapes.*;
/**
 * This class represents the objects which will have interactions while the game is running. 
 * 
 * @author junbok lee
 * @version 05/06/2022
 */
public class Sprite {
	
	double x, y;
	double width, height;
	
	/**
	 * Constructs a Sprite with all fields as 0.
	 */
	public Sprite() {
		x = 0;
		y = 0;
		width = 0;
		height = 0;
	}
	
	/**
	 * Constructs a Sprite with specified x and y coordinates, as well as the width and height of the hitbox.
	 * 
	 * @param x x coordinate of the top left corner
	 * @param y y coordinate of the top left corner
	 * @param width width of the hitbox
	 * @param height height of the hitbox
	 */
	public Sprite(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Returns the x coordinate of the sprite.
	 * 
	 * @return x coordinate of the sprite
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Returns the y coordinates of the sprite.
	 * 
	 * @return y coordinate of the sprite
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Returns the hitbox of the sprite.
	 * 
	 * @return a Rectangle which represents the hitbox of the sprite.
	 */
	public Rectangle getHitbox() {
		return new Rectangle(x, y, width, height, 0, 0, 0);
	}
	
	public void setCoords(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
}
