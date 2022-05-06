package screen;

public interface ScreenSwitcher {
	
	public static final int STARTING_SCREEN = 0;
	public static final int GAME_SCREEN = 1;
	public static final int ESCAPE_SCREEN = 2;
	
	public void switchScreen(int i);
	


}
