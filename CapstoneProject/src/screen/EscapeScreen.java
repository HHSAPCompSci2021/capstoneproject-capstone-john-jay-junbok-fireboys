package screen;

import main.DrawingSurface;

/**
 * This class represents the screen displayed that presents a menu of options whne the user presses the esc and is currently on the GameScreen
 * @author jaydalal
 * @version 05/05/2022
 *
 */

public class EscapeScreen extends Screen {
	
	private DrawingSurface s;
	
	/**
	 * Constructs an EscapeScreen by setting the width to 600 and height to 800 and assigning the Drawing that uses this Screen to s.
	 * @param s The DrawingSurface that utilizes the screen
	 */
	public EscapeScreen(DrawingSurface s) {
		super(800, 600);
		this.s = s;
		
	}

}
