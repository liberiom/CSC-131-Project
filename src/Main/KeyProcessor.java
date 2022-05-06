/* This will handle the "Hot Key" system. */

package Main;

import logic.Control;
import timer.stopWatchX;

public class KeyProcessor{
	// Static Fields
	private static char last = ' ';			// For debouncing purposes
	private static stopWatchX sw = new stopWatchX(200);
	public static boolean enterKeyEnabled;
	private static int currentNumber = -1;
	public static boolean numKeysEnabled = true;
	
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
			if (numKeysEnabled) {
				Main.board.recordAnswerAndMoveOn(1);
				currentNumber = 1;
			}
			break;
		
		case '2':
			if (numKeysEnabled) {
				Main.board.recordAnswerAndMoveOn(2);
				currentNumber = 2;
			}
			break;
			
		case '3':	
			if (numKeysEnabled) {
				Main.board.recordAnswerAndMoveOn(3);
				currentNumber = 3;
			}
			break;
			
		case '4':
			if (numKeysEnabled) {
				Main.board.recordAnswerAndMoveOn(4);
				currentNumber = 4;
			}
			break;
			
		case '5':
			
			break;
			
		case '6':
			
			break;
			
		case '7':
			
			break;
			
		case '8':
			
			break;
			
		case '9':
			
			break;
			
		case '0':
			
			break;
		case '=':
			System.out.println("Enter key has been pressed");
			if (enterKeyEnabled) {
				if (Main.titleScreen.getVisibility() == true) {
					Main.titleScreen.setVisibility(false);
					Main.board.setVisibility(true);
					Main.board.setFirstQuestion(true); // Prevents the question from popping up in the title screen
					Main.board.setFirstColumn(true);
					enterKeyEnabled = false;
					Main.board.shuffle();
				} else { // Responsible for throwing the user back to the first part
					if (Main.board.isHardLuckMessageVisible()) {
						Main.board.coverBoth(Main.board.getFirstColumn(), Main.board.getFirstRow(), Main.board.getSecondColumn(), Main.board.getSecondRow());
					}
					Main.board.makeAllMessagesDisappear();
					// throw back to first
					Main.board.setEnterStage(false);
					Main.board.setFirstQuestion(true);
					Main.board.setFirstColumn(true);
					Main.board.setSecondColumn(false);
					// set the keys back to normal!
					numKeysEnabled = true;
					enterKeyEnabled = false;
				} 
			}
			break;
		
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