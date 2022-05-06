package level;

import java.util.ArrayList;

interface Level {
	
	ArrayList<Obstacle> obstacles = new ArrayList<>();

	public default ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}
}
