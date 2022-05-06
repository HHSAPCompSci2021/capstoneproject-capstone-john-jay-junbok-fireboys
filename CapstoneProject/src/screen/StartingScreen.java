package screen;

import main.DrawingSurface;

/**
 * This class represents the starting screen, which is the first screen that prompts the user to play the game.
 * @author jaydalal
 * @version 05/05/2022
 *
 */
public class StartingScreen extends Screen {
	
	private DrawingSurface s;
	
	/**
	 * Constructs a StartingScreen by setting the width to 600 and height to 800 and assigning the Drawing that uses this Screen to s.
	 * @param s The DrawingSurface that utilizes the screen
	 */
	public StartingScreen(DrawingSurface s) {
		super(800, 600);
		this.s = s;
	}
	
	/**
	 * Illustrates the Screen by setting the background to sky blue and noting that this is the staritng screen.
	 */
	public void draw() {
		s.background(95, 149, 237);
		s.text("This is the Starting Screen!", 300, 100);
	}

}
