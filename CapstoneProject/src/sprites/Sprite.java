package sprites;

import jdalal464.shapes.*;
import processing.core.PApplet;
import processing.core.PImage;
/**
 * This class represents the objects which will have interactions while the game is running. 
 * 
 * @author junbok lee
 * @version 05/13/2022
 */
public class Sprite {
	
	public double x, y;
	public double width, height;
	protected PImage image;
	
	/**
	 * Constructs a Sprite with all fields as 0.
	 */
	public Sprite() {
		x = 0;
		y = 0;
		width = 0;
		height = 0;
		image = null;
	}
	
	/**
	 * Constructs a Sprite with specified x and y coordinates, as well as the width and height of the hitbox.
	 * 
	 * @param x x coordinate of the top left corner
	 * @param y y coordinate of the top left corner
	 * @param width width of the hitbox
	 * @param height height of the hitbox
	 */
	public Sprite(PImage image, double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;
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
	
	/**
	 * Sets the coordinates of the sprite to the specified coordinates.
	 * 
	 * @param x new x coordinate of the sprite
	 * @param y new y coordinate of the sprite
	 */
	public void setCoords(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	
	public void draw(PApplet g) {
		if (image != null)
			g.image(image,(float)x,(float)y,(float)width,(float)height);
		else {
			g.fill(100);
			g.rect((float)x,(float)y,(float)width,(float)height);
		}
	}

	
}
