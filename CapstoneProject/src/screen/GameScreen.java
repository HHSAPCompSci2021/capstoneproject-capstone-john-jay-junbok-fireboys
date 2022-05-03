package screen;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import level.Level;
import level.Obstacle;
import main.DrawingSurface;
import sprites.Player;
import sprites.Sprite;

public class GameScreen extends Screen {

	private DrawingSurface surface;
	private Rectangle screenRect;
	private Player player;
	private ArrayList<Obstacle> obstacles;
	

	public GameScreen(DrawingSurface surface, Level a) {
		super(800,600);
		this.surface = surface;
		screenRect = new Rectangle(0,0, DRAWING_WIDTH, DRAWING_HEIGHT);
		obstacles = a.getObstacles();
	}

}
