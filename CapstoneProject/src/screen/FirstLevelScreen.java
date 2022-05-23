package screen;

import java.util.ArrayList;

import level.Level;
import main.DrawingSurface;
import processing.core.PImage;
import sprites.Enemy;
import sprites.InvisCloak;
import sprites.Player;
import sprites.Zombie;

public class FirstLevelScreen extends Screen {
	
	private ArrayList<Zombie> zombies;
	private ArrayList<InvisCloak> cloaks;
	private Level level;
	private Player player;
	private DrawingSurface surface;
	
	public FirstLevelScreen(DrawingSurface surface) {
		super(800, 600);
		this.surface = surface;
		cloaks.add(new InvisCloak(185,400, surface.loadImage("img/cloak.png"))); 
		cloaks.add(new InvisCloak(300,375, surface.loadImage("img/cloak.png"))); 
		cloaks.add(new InvisCloak(750,375, surface.loadImage("img/cloak.png"))); 
		cloaks.add(new InvisCloak(750, 100, surface.loadImage("img/cloak.png")));
		zombies.add(new Zombie(275,75, true, false, surface.loadImage("img/enemy_1.png"))); 
		zombies.add(new Zombie(175,150,true, false,surface.loadImage("img/enemy_1.png")));
		zombies.add(new Zombie(500,75,true, false,surface.loadImage("img/enemy_1.png"))); 
		zombies.add(new Zombie(600,160,true, false,surface.loadImage("img/enemy_1.png")));
		zombies.add(new Zombie(750,300,true, false,surface.loadImage("img/enemy_1.png"))); 
		zombies.add(new Zombie(50,325,true, false,surface.loadImage("img/enemy_1.png")));
		zombies.add(new Zombie (150,350,true, false,surface.loadImage("img/enemy_1.png"))); 
		zombies.add(new Zombie(300,130,true, false,surface.loadImage("img/enemy_1.png")));
		level = new Level("mazefiles/level1.txt", 600, 800, zombies, cloaks, surface.loadImage("img/level_one.png"));
	}
	
	public void draw() {
		level.draw(surface);
	}
	
	
	
}
