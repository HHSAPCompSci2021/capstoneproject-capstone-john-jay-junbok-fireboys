package sprites;

import processing.core.PApplet;

/**
* This class represents a new monster that follows the main character
* @author johntahk
*/
public class Zombie extends Enemy {

	public Zombie(double x, double y) {
		super(x, y);
		attack();
		// TODO Auto-generated constructor stub
	}
	//inherited methods: moveTo, moveBy, need to modify attack
	
	public void attack() {
	//	if (super.getIsInvis == true);
	}
}
