package main;
import java.awt.Point;
import java.util.ArrayList;

import jay.jaysound.JayLayer;
import jay.jaysound.JayLayerListener;
//import jay.jaysound.JayLayer;
//import jay.jaysound.JayLayerListener;
import level.FirstLevel;
import level.Level;
import processing.core.PApplet;
import processing.core.PImage;
import screen.EscapeScreen;
import screen.GameScreen;
import screen.Screen;
import screen.ScreenSwitcher;
import screen.StartingScreen;

/**
 * This class represents the surface on which the screens and interactive sprites will be drawn. It retains the ability to swtich between screens since it implements ScreenSwitcher.
 * @author jaydalal
 * @version 05/20/2022
 *
 */
public class DrawingSurface extends PApplet implements ScreenSwitcher, JayLayerListener {

	/**
	 * Represents the width and height of the drawing surfaces.
	 */
	public float x, y;
	private Screen current;
	public ArrayList<Screen> screens;
	private Level a; 
	private ArrayList<Integer> keys;
	private JayLayer p;
	private ArrayList<PImage> images;
	
	/**
	 * Constructs a DrawingSurface by creating the StartingScreen, GameScreen, and EscapeScreen for this game and stroing them in an ArrayList of Screens.
	 */
	public DrawingSurface() {
		
		a = new FirstLevel();
		
		keys = new ArrayList<Integer>();
		screens = new ArrayList<Screen>();
		
		StartingScreen screen1 = new StartingScreen(this, false);
		screens.add(screen1);
		
		GameScreen screen2 = new GameScreen(this, a);
		screens.add(screen2);
		
		EscapeScreen screen3 = new EscapeScreen(this);
		screens.add(screen3);
		
		
		current = screens.get(0);
	
		p = new JayLayer("sounds/", "sounds/", false);
		p.addPlayList();
		p.addSongs(0, new String[] {"mysterbackgroundMusic.mp3"});
		p.changePlayList(0);
		p.addJayLayerListener(this);
		p.nextSong();
		images = new ArrayList<>();
		
	}
	
	
	
	/**
	 * Sets up the images for the sprites and maze in the game
	 */
	public void setup() {
		images.add(super.loadImage("img/cloak.png"));
		images.add(super.loadImage("img/enemy_1.png"));
		images.add(super.loadImage("img/level_one.png"));
		images.add(super.loadImage("img/player.png"));
	}
	
	/**
	 * Gets the specific image at the index int index for the game
	 * @param index The index at which the image would be in an arraylist of images
	 * @return The image at specified index
	 */
	public PImage getImages(int index) {
		return images.get(index);
	}
	
	/**
	 * Draws the DrawingSurface by illustrating the screen and needs to be currently displayed.
	 */
	public void draw() {
		
		if (!((GameScreen) (screens.get(ScreenSwitcher.GAME_SCREEN))).getPlayer().isAlive()) {
			screens.set(0, new StartingScreen(this, true));
			screens.set(1, new GameScreen(this, a));
			switchScreen(0);
		}
		
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
	

	
	/**
	 * This method ensures that the Player doesn't when the key is released
	 */
	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}
	
	/**
	 * Switches the screen to the exit screen when the ESC key is pressed
	 */
	public void keyPressed() {
		keys.add(keyCode);
		if (key == ESC) {
			current = screens.get(ScreenSwitcher.ESCAPE_SCREEN);
			key = 0;
		}
	}
	
	/**
	 * Returns whether the keys contains a specific keyCode to ensure that key related interactions are smooth
	 * @param code the integer code for keys.
	 * @return Whther the keys contain the integer code
	 */ 
	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}
	
	/**
	 * Calls the mousePressed method on the current screen
	 */
	public void mousePressed() {
		current.mousePressed();
	}
	
	/**
	 * Converts actual coordinates to assumed coordinates, which is more appropriat efor the game
	 * @param actual The actual coordinates
	 * @return the assumed coordinates
	 */
	public Point actualCoordinatesToAssumed(Point actual) {
		return new Point((int)(actual.getX()/x) , (int)(actual.getY()/y));
	}



	@Override
	/**
	 * implements method of same name from JayLayerListener - doesn't have any functionality
	 */
	public void musicStarted() {
		// TODO Auto-generated method stub
		
	}


	@Override
	/**
	 * implements method of same name from JayLayerListener - doesn't have any functionality
	 */
	public void musicStopped() {
		
	}


	@Override
	/**
	 * implements method of same name from JayLayerListener - doesn't have any functionality
	 */
	public void playlistEnded() {
		// TODO Auto-generated method stub
		
	}


	@Override
	/**
	 * implements method of same name from JayLayerListener - doesn't have any functionality
	 */
	public void songEnded() {
		// TODO Auto-generated method stub
		
	}
}
