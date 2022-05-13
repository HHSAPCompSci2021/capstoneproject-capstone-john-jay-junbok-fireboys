package level;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import jdalal464.shapes.Circle;
import jdalal464.shapes.Rectangle;
import jdalal464.shapes.Shape;
import sprites.Enemy;
import sprites.InvisCloak;

/**
 * This class represents a Level in the game
 * @author John Tahk
 * @version 05/06/2022
 *
 */
public abstract class Level {
	
	private ArrayList<Enemy> monsters;
	
	private ArrayList<InvisCloak> inviscloak;
	private ArrayList<Rectangle> obstacles;
	private char[][] walls;

	
	public Level(String filename, int width, int height) {
		walls = new char[24][32];
		readData(filename, walls);
		inviscloak = new ArrayList<InvisCloak>();
		monsters = new ArrayList<Enemy>(); 
		obstacles = new ArrayList<Rectangle>();
		makeObstacles();
	}
	
	private void makeObstacles() {
		for (int i = 0; i < walls.length; i++) {
			for (int j = 0; j < walls[i].length; j++) {
				if (walls[i][j] == '#') {
					obstacles.add(new Rectangle(j * 25, i * 25, 25, 25, 0, 0, 0));
				} else if (walls[i][j] == '!' && walls[i + 1][j] == '!' && walls[i][j + 1] == '!' && walls[i + 1][j + 1] == '!') {
					obstacles.add(new Rectangle(j * 25 + 25 / 2, i * 25 + 25 / 2, 25, 25, 0, 0, 0));
				}
			}
		}
	}
	
	/**
	 * Getter method for walls
	 * @return walls 2-d character array representing wall positions
	 */
	public char[][] getWalls() {
		return walls;
	}
	/**
	 * Getter method for inviscloaks
	 * @return inviscloak ArrayList of invisCloaks
	 */
	public ArrayList<InvisCloak> getInvisCloaks() {
		return inviscloak;
	}
	
	/**
	 * Adds an invisibility cloak to the arraylist of invisCloaks
	 * @param a InvisCloak to be added
	 */
	public void addInvisCloak(InvisCloak a) {
		inviscloak.add(a);
	}
	/**
	 * Removes invisCloak from the level
	 * @param i the index of the invisCloak to be removed
	 */
	public void removeInvisCloak(int i) {
		inviscloak.remove(i);
	}
	
	/**
	 * This method returns an arraylist containing the obstacles of the class.
	 * @return arraylist containing the obstacles of the class.
	 */
	public ArrayList<Rectangle> getObstacles() {
		return obstacles;
	}
	/**
	 * This returns the monsters arraylist
	 * @return monsters ArrayList of type enemy
	 */
	public ArrayList<Enemy> getMonsters() {
		return monsters;
	}
	
	public void removeMonster(int i) {
		monsters.remove(i);
	}
	
	public void addMonster(Enemy a) {
		monsters.add(a);
	}
	

	public void readData (String filename, char[][] gameData) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			int count = 0;

			FileReader reader = null;
			Scanner in = null;
			try {
					reader = new FileReader(dataFile);
					in = new Scanner(reader);
					
					while (in.hasNext()) {
						String line = in.nextLine();
						for(int i = 0; i < line.length(); i++)
							if (count < gameData.length && i < gameData[count].length)
								gameData[count][i] = line.charAt(i);

						count++;
					}

			} catch (IOException ex) {
				throw new IllegalArgumentException("Data file " + filename + " cannot be read.");
			} finally {
				if (in != null)
					in.close();
			}
			
		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}
		
	}
	
	
	
	
}
