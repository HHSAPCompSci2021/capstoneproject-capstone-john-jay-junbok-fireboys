package screen;

import java.awt.Point;
import processing.core.PFont;
import java.awt.Rectangle;

import level.Level;
import main.DrawingSurface;
import processing.core.PFont;

/**
 * This class represents the starting screen, which is the first screen that prompts the user to play the game and the screen that shows up when the player was dead/won.
 * @author jaydalal
 * @version 05/20/2022
 *
 */
public class StartingScreen extends Screen {
	
	private DrawingSurface s;
	private Rectangle button;
	private boolean wasDead;
	
	/**
	 * Constructs a StartingScreen by setting the width to 600 and height to 800 and assigning the Drawing that uses this Screen to s.
	 * @param s The DrawingSurface that utilizes the screen
	 * @param wasDead whether the player was dead in the previous game
	 */
	public StartingScreen(DrawingSurface s, boolean wasDead) {
		super(800, 600);
		this.s = s;
		this.wasDead = wasDead;
		
		button = new Rectangle(800 /2 - 100, 600 / 2 - 50, 200, 100);
	}
	
	/**
	 * Illustrates the Screen by setting the background to sky blue and noting that this is the starting screen. Additionally, it notes if the player was dead in the previous GameScreen
	 */
	public void draw() {
		
		s.background(0, 126, 107);
		
		
		s.text("MONSTERS and MAZES", 300, 150);
		
		if (wasDead == true) {
			s.text("YOU DIED: WANNA TRY AGAIN?", 300, 200);
		}
		
		s.fill(0, 126, 107);
		s.rect(button.x, button.y, button.width, button.height, 10, 10, 10, 10);
		String buttonString = "start";
		float x = s.textWidth(buttonString);
		s.fill(0);
		s.text(buttonString, button.x + button.width / 2 - x / 2, button.y + button.height / 2);
	}
	
	/**
	 * Swtiches the screen of the game screen with the location of the mouse press is inside the button that prompts the user to play
	 */
	public void mousePressed() {
		Point p = s.actualCoordinatesToAssumed(new Point(s.mouseX,s.mouseY));
		if (button.contains(p.x, p.y)) {
			s.switchScreen(ScreenSwitcher.GAME_SCREEN);
		}
			
	}

}
