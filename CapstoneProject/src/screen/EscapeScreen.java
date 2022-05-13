package screen;

import java.awt.Point;
import java.awt.Rectangle;

import level.FirstLevel;
import level.Level;
import main.DrawingSurface;
import processing.core.PFont;

/**
 * This class represents the screen displayed that presents a menu of options whne the user presses the esc and is currently on the GameScreen
 * @author jaydalal
 * @version 05/11/2022
 *
 */

public class EscapeScreen extends Screen {
	
	private DrawingSurface s;
	private Rectangle buttonResume, buttonRestart, buttonStart;
	
	/**
	 * Constructs an EscapeScreen by setting the width to 600 and height to 800 and assigning the Drawing that uses this Screen to s.
	 * @param s The DrawingSurface that utilizes the screen
	 */
	public EscapeScreen(DrawingSurface s) {
		super(800, 600);
		this.s = s;
		
		buttonResume = new Rectangle(800 /2 - 100, 600 / 4 - 50, 200, 100);
		buttonRestart = new Rectangle(800 /2 - 100, 600 / 2 - 50, 200, 100);
		buttonStart = new Rectangle(800 /2 - 100, 3 * 600 / 4 - 50, 200, 100);
		
		
	}
	
	/*
	 * Draws the Escape Screen (when ESC is prompted) by creating a bluish green background and making button that prompt the user to either resume the game, restart the game, or return to the start screen
	 */
	public void draw() {
		s.background(0, 126, 127);
		s.fill(0, 126, 127);
		
		String buttonString;
		float x;
		
		s.fill(0);
		s.text("Escape Screen", buttonResume.x + buttonResume.width / 2 - s.textWidth("Escape Screen") / 2, 50);
		s.fill(0, 126, 127);
		
		s.rect(buttonResume.x, buttonResume.y, buttonResume.width, buttonResume.height, 10, 10, 10, 10);
		buttonString = "Resume";
		x = s.textWidth(buttonString);
		s.fill(0);
		s.text(buttonString, buttonResume.x + buttonResume.width / 2 - x / 2, buttonResume.y + buttonResume.height / 2);
		
		s.fill(0, 126, 127);
		s.rect(buttonRestart.x, buttonRestart.y, buttonRestart.width, buttonRestart.height, 10, 10, 10, 10);
		buttonString = "Restart";
		x = s.textWidth(buttonString);
		s.fill(0);
		s.text(buttonString, buttonRestart.x + buttonRestart.width / 2 - x / 2, buttonRestart.y + buttonRestart.height / 2);
		
		s.fill(0, 126, 127);
		s.rect(buttonStart.x, buttonStart.y, buttonStart.width, buttonStart.height, 10, 10, 10, 10);
		buttonString = "Start";
		x = s.textWidth(buttonString);
		s.fill(0);
		s.text(buttonString, buttonStart.x + buttonStart.width / 2 - x / 2, buttonStart.y + buttonStart.height / 2);
	}
	
	/**
	 * Switches the screen depending on which button is pressed.
	 */
	public void mousePressed() {
		Point p = s.actualCoordinatesToAssumed(new Point(s.mouseX,s.mouseY));
		if (buttonResume.contains(p.x, p.y)) {
			s.switchScreen(ScreenSwitcher.GAME_SCREEN);
		} else if (buttonRestart.contains(p.x, p.y)) {
			s.screens.set(1, new GameScreen(s, new FirstLevel()));
			s.switchScreen(ScreenSwitcher.GAME_SCREEN);
		} else if (buttonStart.contains(p.x, p.y)) {
			s.switchScreen(ScreenSwitcher.STARTING_SCREEN);
		}
			
	}

}
