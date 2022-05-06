package main;
import java.util.ArrayList;

import processing.core.PApplet;
import screen.EscapeScreen;
import screen.GameScreen;
import screen.Screen;
import screen.ScreenSwitcher;
import screen.StartingScreen;

public class DrawingSurface extends PApplet implements ScreenSwitcher {

	public double x, y;
	private ArrayList<Integer> keys;
	private Screen current;
	private ArrayList<Screen> screens;
	
	public DrawingSurface() {
		screens = new ArrayList<Screen>();
		keys = new ArrayList<Integer>();
		
		StartingScreen screen1 = new StartingScreen(this);
		screens.add(screen1);
		
		GameScreen screen2 = new GameScreen(this);
		screens.add(screen2);
		
		EscapeScreen screen3 = new EscapeScreen(this);
		screens.add(screen3);
		
		current = screens.get(0);
		
		
	}

	@Override
	public void switchScreen(int i) {
		current = screens.get(i);
		
	}
}
