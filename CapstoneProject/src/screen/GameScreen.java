package screen;

import java.awt.Point;
import java.awt.Rectangle;


import java.awt.event.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import jdalal464.shapes.*;

import level.FirstLevel;
import level.Level;
import level.SecondLevel;
import main.DrawingSurface;
import processing.core.PGraphics;
import processing.core.PImage;
import sprites.Enemy;
import sprites.InvisCloak;
import sprites.Player;
import sprites.Sprite;
import sprites.Zombie;

/**
 * This class represents a Game Screen, which is the screen that the interactive game appears on
 * @author jaydalal
 * @version 05/20/2022
 *
 */
public class GameScreen extends Screen {

	private DrawingSurface s;
	private Player player;
	private Level a;
	private boolean wonGame;
	private PImage backgroundLevelOne;
	private PImage backgroundLevelTwo;
	private PImage enemyImage;
	private PImage invisCloakImage;

	
	
	
	/**
	 * Constructs a GameScreen by setting the width to 600 and height to 800 and assigning the Drawing that uses this Screen to s.
	 * @param s The DrawingSurface that utilizes the screen
	 */
	public GameScreen(DrawingSurface s, Level level) {
		super(800,600);
		this.s = s;
		this.a = level;
		wonGame = false;
		
	}
	
	/**
	 * Draws the game screen by displaying the blueprint (walls and pillars), the obstacles of the game (including the monster), and generating the player
	 */
	public void draw() {
		
		if (!player.isAlive()) {
			s.screens.set(0, new StartingScreen(s, true));
			if (a.getClass().getName().equals("level.FirstLevel")) {
				s.screens.set(1, new GameScreen(s, new FirstLevel()));
			} else {
				s.screens.set(1,  new GameScreen(s, new SecondLevel()));
			}
			s.setup();
			s.switchScreen(0);
		}
		
		hasWon();
		if (wonGame) {
			s.screens.set(3, new WinningScreen(s, a));
			s.switchScreen(ScreenSwitcher.WINNING_SCREEN);
		}	
		
		if (a.getClass().getName().equals("level.FirstLevel")) {
			s.image(backgroundLevelOne, 0, 0, 800, 600);
		} else {
			s.image(backgroundLevelTwo, 0, 0, 800, 600);
		}
		
		
		movePlayer();
		char[][] blueprint = a.getWalls();

		
		float boxHeight = 600 / blueprint.length;
		float boxWidth = 800 / blueprint[0].length;
		/*
		for (int i = 0; i < blueprint.length; i++) {
			for (int j = 0; j < blueprint[i].length; j++) {
				if (blueprint[i][j] == '.') {
					s.fill(255);
					s.stroke(255);
					s.rect(boxWidth * j, boxHeight * i, boxWidth, boxHeight);
				} else if (blueprint[i][j] == '#') {
					s.fill(0);
					s.stroke(0);
					s.rect(boxWidth * j, boxHeight * i, boxWidth, boxHeight);
				} else if (blueprint[i][j] == '!') {
					s.fill(0);
					if (blueprint[i + 1][j] == '!' && blueprint[i][j + 1] == '!' && blueprint[i + 1][j + 1] == '!') {
						s.circle(boxWidth * (j + 1), boxHeight * (i + 1), boxWidth * 2);
					}
				}
				
			}
		}
		*/
		
	
		
		addStuff(a, boxWidth);
		player.act();
		player.draw(s);

		
		PGraphics fogMask = createFogMask( (float) player.getX(), (float) player.getY(), 300);
		s.image(fogMask,0,0);

		
	}
	
/**
 * Creates a fog mask for the player, reducing visiblity in the game, thus making it more challenging -- copied from fogMask demonstration
 * @param x The x coordinate of the center of the fog mask
 * @param y The y coordinate of the center of the fog mask
 * @param dim The diameter of the fog mask
 * @return A PGraphics that, when represented as an image, draws a fog mask around the player.
 */
public PGraphics createFogMask(float x, float y, int dim) {
		
		PGraphics visionMask = s.createGraphics(DRAWING_WIDTH, DRAWING_HEIGHT);

		visionMask.beginDraw();
		visionMask.background(255);
		visionMask.noStroke();
		for (int r = dim; r > 0; r--) {
			visionMask.fill(r*255/dim);
			visionMask.ellipse(x, y, r, r);
		}
		visionMask.endDraw();
		
		PGraphics fogMask = s.createGraphics(DRAWING_WIDTH, DRAWING_HEIGHT);
		fogMask.beginDraw();
		fogMask.background(0);
		fogMask.endDraw();
		fogMask.mask(visionMask);
		
		return fogMask;
	}
	
	private void movePlayer() {
		if (s.isPressed(KeyEvent.VK_LEFT)) {
			player.move(-5, 0);
		}	
		if (s.isPressed(KeyEvent.VK_RIGHT)) {
			player.move(5, 0);
		}
		if (s.isPressed(KeyEvent.VK_UP)) {
			player.move(0, -5);
		}
		if (s.isPressed(KeyEvent.VK_DOWN)) {
			player.move(0, 5);
		}	
	}
	
	
	private void addStuff(Level a, float radius) {
		
		for (InvisCloak n : a.getInvisCloaks()) {
			new InvisCloak(invisCloakImage, n.getX(), n.getY()).draw(s);
		}
		for (Enemy x : a.getMonsters()) {
			new Enemy(enemyImage, x.getX(), x.getY()).draw(s);
			if (x.getClass().getName().equals("sprites.Zombie")) {
				((Zombie) x).move();
			}

		}
		
	}
	
	/**
	 * Returns the player of the game screen
	 * @return the player of the game screen
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * Returns the level of the game screen
	 * @return the level of the game screen
	 */
	public Level getLevel() {
		return a;
	}
	
	private void hasWon() {
		if (a.getClass().getName().equals("level.FirstLevel")) {
			if (new Rectangle(0, 0, 100, 50).contains(new Point((int)player.getX(), (int) player.getY()))) {
				wonGame = true;
			}
		} else {
			if (new Rectangle(250, 0, 100, 50).contains(new Point((int)player.getX(), (int) player.getY()))) {
				wonGame = true;
			}
		}
	}

	@Override
	/**
	 * Sets up the game by providing images for the player, backgrounds for both levels, enemy, and invisibility cloak and storing that data in PImage objects.. Constructs the player object as it sets up the image for player as well.
	 */
	public void setup() {
		player = new Player(s.loadImage("img/player.png"), s.loadImage("img/player_invis.png"), 700, 550, a);
		backgroundLevelOne = s.loadImage("img/level_one.png");
		backgroundLevelTwo = s.loadImage("img/level_two.png");
		enemyImage = s.loadImage("img/enemy_1.png");
		invisCloakImage = s.loadImage("img/cloak.png");
		
	}


}
