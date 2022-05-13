package level;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import sprites.Enemy;
import sprites.InvisCloak;

/**
 * This class represents a Level in the game
 * @author John Tahk
 * @version 05/06/2022
 *
 */
public abstract class Level {
	
	private ArrayList<Enemy> monsters = new ArrayList<Enemy>(); 
	
	private ArrayList<InvisCloak> inviscloak = new ArrayList<InvisCloak>();
	private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	private char[][] walls;

	
	public Level(String filename, int width, int height) {
		walls = new char[24][32];
		readData(filename, walls);
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
	 * This method returns an arraylist containing the obstacles of the class.
	 * @return arraylist containing the obstacles of the class.
	 */
	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}
	/**
	 * This returns the monsters arraylist
	 * @return monsters ArrayList of type enemy
	 */
	public ArrayList<Enemy> getMonsters() {
		return monsters;
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
							if (count < gameData.length && i < gameData[count].length) {
								gameData[count][i] = line.charAt(i);
								
							}

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
