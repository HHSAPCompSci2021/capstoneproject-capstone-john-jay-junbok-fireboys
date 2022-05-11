package screen;

import java.awt.Point;
import processing.core.PFont;
import java.awt.Rectangle;

import main.DrawingSurface;
import processing.core.PFont;

/**
 * This class represents the starting screen, which is the first screen that prompts the user to play the game.
 * @author jaydalal
 * @version 05/05/2022
 *
 */
public class StartingScreen extends Screen {
	
	private DrawingSurface s;
	private Rectangle button;
	
	/**
	 * Constructs a StartingScreen by setting the width to 600 and height to 800 and assigning the Drawing that uses this Screen to s.
	 * @param s The DrawingSurface that utilizes the screen
	 */
	public StartingScreen(DrawingSurface s) {
		super(800, 600);
		this.s = s;
		
		button = new Rectangle(800 /2 - 100, 600 / 2 - 50, 200, 100);
	}
	
	/**
	 * Illustrates the Screen by setting the background to sky blue and noting that this is the staritng screen.
	 */
	public void draw() {
		
		s.background(0, 126, 107);
		
		
		s.text("MONSTERS and MAZES", 100, 150);
		
		
		s.fill(0, 126, 107);
		s.rect(button.x, button.y, button.width, button.height, 10, 10, 10, 10);
		String buttonString = "start";
		float x = s.textWidth(buttonString);
		s.fill(0);
		s.text(buttonString, button.x + button.width / 2 - x / 2, button.y + button.height / 2);
	}
	
	public void mousePressed() {
		Point p = s.actualCoordinatesToAssumed(new Point(s.mouseX,s.mouseY));
		if (button.contains(p.x, p.y)) {
			s.switchScreen(ScreenSwitcher.GAME_SCREEN);
		}
			
	}

}
