package screen;

import level.Level;

/**
 * This class represents a screen in the overall game. 
 * @author jaydalal
 * @version 05/20/2022
 *
 */
public abstract class Screen {
	
	/*
	 * These represent the overall drawing width and height of the screen
	 */
	public final int DRAWING_WIDTH, DRAWING_HEIGHT;
	
	/**
	 * Constructs a new screen, setting DRAWING_WIDTH to the parameter width and DRAWING_HEIGHT to the parameter height
	 * @param width the desired width of the screen
	 * @param height the desired height of the screen
	 */
	public Screen(int width, int height) {
		this.DRAWING_WIDTH = width;
		this.DRAWING_HEIGHT = height;
	}
	
	/** 
	 * Illustrates the screen to desired graphical properties of the game
	 */
	public void draw() {
		
	}
	
	/**
	 * Switches screen depending on specific location of mousePressed (in graphically displayed buttons)
	 */
	public void mousePressed() {
		
	}
	
	/**
	 * Moves the player depending on the specific key pressed (arrows)
	 */
	public void keyPressed() {
		
	}
	
	public abstract void setup();

}
