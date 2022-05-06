package level;

import java.util.ArrayList;

/**
 * This interface represents a Level in the game
 * @author John Tahk
 * @version 05/06/2022
 *
 */
interface Level {
	
	ArrayList<Obstacle> obstacles = new ArrayList<>();

	/**
	 * This class returns an arraylist containing the obstacles of the class.
	 * @return arraylist containing the obstacles of the class.
	 */
	public default ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}
}
