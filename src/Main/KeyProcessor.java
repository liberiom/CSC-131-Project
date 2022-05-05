/* This will handle the "Hot Key" system. */

package Main;

import logic.Control;
import timer.stopWatchX;

public class KeyProcessor{
	// Static Fields
	private static char last = ' ';			// For debouncing purposes
	private static stopWatchX sw = new stopWatchX(200);
	public static boolean enterKeyEnabled;
	
	// Static Method(s)
	public static void processKey(char key){
		if(key == ' ')				return;
		// Debounce routine below...
		if(key == last)
			if(sw.isTimeUp() == false)			return;
		last = key;
		sw.resetWatch();
		
		/* TODO: You can modify values below here! */
		switch(key){
		case '%':								// ESC key
			System.exit(0);
			break;
		case '1':
			System.out.println("Number has been pressed");
			break;
			
		case '=':
			System.out.println("Enter key has been pressed");
			if (enterKeyEnabled) {
				if (Main.titleScreen.getVisibility() == true) {
					Main.titleScreen.setVisibility(false);
					enterKeyEnabled = false;
					/*
					 * TODO: Put shuffle method here
					 */
				}
			}
			break;
			
		/*
		 * For anyone looking at the source code in here, the reason why there were uKeyEnabled, oKeyEnabled, etc. was because initially, inspecting each item prompted the player to press different keys (u, o, etc.).
		 * But that's not what the assignment said to do, instead it said to use the space bar for all inspecting. 
		 */
		case '$':
			
			break;
			
		case 'm':
			// For mouse coordinates
			Control.isMouseCoordsDisplayed = !Control.isMouseCoordsDisplayed;
			break;
			
		case 'q':
			
			break;
		}
	}
	
	
	
}