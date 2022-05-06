package screen;

import main.DrawingSurface;

public class StartingScreen extends Screen {
	
	private DrawingSurface s;
	
	public StartingScreen(DrawingSurface s) {
		super(800, 600);
		this.s = s;
	}
	
	public void draw() {
		s.background(95, 149, 237);
		s.text("This is the Starting Screen!", 300, 100);
	}

}
