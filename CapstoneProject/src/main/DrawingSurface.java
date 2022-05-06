package main;
import java.util.ArrayList;

import processing.core.PApplet;
import screen.Screen;
import screen.ScreenSwitcher;

public class DrawingSurface extends PApplet implements ScreenSwitcher {

	public double x, y;
	private ArrayList<Integer> keys;
	private Screen current;
	private ArrayList<Screen> screens;
	
	public DrawingSurface() {
		screens = new ArrayList<Screen>();
		keys = new ArrayList<Integer>();
		
		
	}
}
