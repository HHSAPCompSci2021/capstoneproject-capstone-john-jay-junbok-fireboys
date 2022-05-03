package screen;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import main.DrawingSurface;
import sprites.Player;
import sprites.Sprite;

public class GameScreen {

	private DrawingSurface surface;
	private Rectangle screenRect;
	private Player player;
	private List<Sprite> obstacles;
	

	public GameScreen(DrawingSurface surface, Level a) {
		super(800,600);
		this.surface = surface;
		screenRect = new Rectangle(0,0, DRAWING_WIDTH, DRAWING_HEIGHT);
		obstacles = new ArrayList<Sprite>();
		obstacles.add(new Sprite(0,250,100,50));
		obstacles.add(new Sprite(700,250,100,50));
		obstacles.add(new Sprite(200,400,400,50));
		obstacles.add(new Sprite(375,300,50,100));
		obstacles.add(new Sprite(300,250,200,50));
	}

}
