package screen;

/**
 * Any class that implements this interface has the ability to swtich the appearance of the drawing panel to a different screen.
 * @author jaydalal
 * @version 05/20/2022
 *
 */
public interface ScreenSwitcher {
	
	/*
	 * Indicates the integer value used to represent the StartingScreen
	 */
	public static final int STARTING_SCREEN = 0;
	/*
	 * Indicates the integer value used to represent the GameScreen
	 */
	public static final int GAME_SCREEN = 1;
	/*
	 * Indicates the integer value used to represent the EscapeScreen
	 */
	public static final int ESCAPE_SCREEN = 2;
	
	public static final int WINNING_SCREEN = 3;
	
	/**
	 * Switches the drawing panel to the new desired screen, represented by i
	 * @param i the integer value that represent the desired type of screen.
	 */
	public void switchScreen(int i);
	


}
