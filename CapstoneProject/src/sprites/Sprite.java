package sprites;

import java.awt.Rectangle;

public class Sprite {
	
	double x, y;
	double width, height;
	
	public Sprite() {
		x = 0;
		y = 0;
		width = 0;
		height = 0;
	}
	
	public Sprite(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public Rectangle getHitbox() {
		return new Rectangle((int)x, (int)y, (int)width, (int)height);
	}
}
