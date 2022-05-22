package screen;

import java.awt.Point;
import processing.core.PFont;
import java.awt.Rectangle;

import level.Level;
import level.SecondLevel;
import main.DrawingSurface;

public class WinningScreen extends Screen {
		
		private DrawingSurface s;
		private Rectangle button;
		private Level wonLevel;
		
		
		public WinningScreen(DrawingSurface s, Level wonLevel) {
			super(800, 600);
			this.s = s;
			this.wonLevel = wonLevel;
			
			button = new Rectangle(800 /2 - 100, 600 / 2 - 50, 200, 100);
		}
		
		/**
		 * Illustrates the Screen by setting the background to sky blue and noting that this is the starting screen. Additionally, it notes if the player was dead in the previous GameScreen
		 */
		public void draw() {
			
			s.background(0, 126, 107);
			
			
			s.text("MONSTERS and MAZES", 300, 150);
			
			if (wonLevel.getClass().getName().equals("level.FirstLevel")) {
				s.text("YOU WON: WANNA PLAY LEVEL 2?", 300, 200);
			} else {
				s.text("YOU WON LEVEL TWO! DO YOU WANT TO PLAY IT AGAIN?", 300, 200);
			}
			
			s.fill(0, 126, 107);
			s.rect(button.x, button.y, button.width, button.height, 10, 10, 10, 10);
			String buttonString = "level";
			float x = s.textWidth(buttonString);
			s.fill(0);
			s.text(buttonString, button.x + button.width / 2 - x / 2, button.y + button.height / 2);
		}
		
		/**
		 * Swtiches the screen of the game screen with the location of the mouse press is inside the button that prompts the user to play
		 */
		public void mousePressed() {
			Point p = s.actualCoordinatesToAssumed(new Point(s.mouseX,s.mouseY));
			if (button.contains(p.x, p.y)) {
				s.levelUp();
			}
				
		}

}
