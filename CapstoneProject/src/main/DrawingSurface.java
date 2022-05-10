package main;
import java.awt.Point;
import java.util.ArrayList;

import processing.core.PApplet;
import screen.EscapeScreen;
import screen.GameScreen;
import screen.Screen;
import screen.ScreenSwitcher;
import screen.StartingScreen;

/**
 * This class represents the surface on which the screens and interactive sprites will be drawn. It retains the ability to swtich between screens since it implements ScreenSwitcher.
 * @author jaydalal
 * @version 05/06/2022
 *
 */
public class DrawingSurface extends PApplet implements ScreenSwitcher {

	/**
	 * Represents the width and height of the drawing surfaces.
	 */
	public float x, y;
	private Screen current;
	private ArrayList<Screen> screens;
	
	/**
	 * Constructs a DrawingSurface by creating the StartingScreen, GameScreen, and EscapeScreen for this game and stroing them in an ArrayList of Screens.
	 */
	public DrawingSurface() {
		screens = new ArrayList<Screen>();
		
		StartingScreen screen1 = new StartingScreen(this);
		screens.add(screen1);
		
		GameScreen screen2 = new GameScreen(this);
		screens.add(screen2);
		
		EscapeScreen screen3 = new EscapeScreen(this);
		screens.add(screen3);
		
		current = screens.get(0);
		
		
	}
	
	/**
	 * Draws the DrawingSurface by illustrating the screen and needs to be currently displayed.
	 */
	public void draw() {
		x = (float) width / current.DRAWING_WIDTH;
		y = (float) height / current.DRAWING_HEIGHT;
		
		push();
		
		scale(x, y);
		
		current.draw();
		
		
		pop();
	}

	@Override
	/**
	 * Switches the drawing panel to the new desired screen, represented by i
	 * @param i the integer value that represent the desired type of screen.
	 */
	public void switchScreen(int i) {
		current = screens.get(i);
		
	}
	
	public void mousePressed() {
		current.mousePressed();
	}
	
	public Point actualCoordinatesToAssumed(Point actual) {
		return new Point((int)(actual.getX()/x) , (int)(actual.getY()/y));
	}
}
