/* This will handle the "Hot Key" system. */

package Main;

import logic.Control;
import timer.stopWatchX;

public class KeyProcessor{
	// Static Fields
	private static char last = ' ';			// For debouncing purposes
	private static stopWatchX sw = new stopWatchX(200);
	public static boolean enterKeyEnabled = true;
	private static int currentNumber = -1;
	public static boolean numKeysEnabled = false;
	public static boolean yKeyEnabled = false;
	public static boolean nKeyEnabled = false;
	
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
				Main.board.setOutOfRangeMessageVisible(false);
				Main.board.recordAnswerAndMoveOn(1);
				currentNumber = 1;
			}
			break;
		
		case '2':
			if (numKeysEnabled) {
				Main.board.setOutOfRangeMessageVisible(false);
				Main.board.recordAnswerAndMoveOn(2);
				currentNumber = 2;
			}
			break;
			
		case '3':	
			if (numKeysEnabled) {
				Main.board.setOutOfRangeMessageVisible(false);
				Main.board.recordAnswerAndMoveOn(3);
				currentNumber = 3;
			}
			break;
			
		case '4':
			if (numKeysEnabled) {
				Main.board.setOutOfRangeMessageVisible(false);
				Main.board.recordAnswerAndMoveOn(4);
				currentNumber = 4;
			}
			break;
			
		case '5':
			if (numKeysEnabled && Main.board.noMessagesAreVisible() && !Main.titleScreen.getVisibility()) {
				Main.board.setFacingUpAlreadyMessageVisible(false);
				Main.board.setOutOfRangeMessageVisible(true);
			}
			break;
			
		case '6':
			if (numKeysEnabled && Main.board.noMessagesAreVisible() && !Main.titleScreen.getVisibility()) {
				Main.board.setFacingUpAlreadyMessageVisible(false);
				Main.board.setOutOfRangeMessageVisible(true);
			}
			break;
			
		case '7':
			if (numKeysEnabled && Main.board.noMessagesAreVisible() && !Main.titleScreen.getVisibility()) {
				Main.board.setFacingUpAlreadyMessageVisible(false);
				Main.board.setOutOfRangeMessageVisible(true);
			}
			break;
			
		case '8':
			if (numKeysEnabled && Main.board.noMessagesAreVisible() && !Main.titleScreen.getVisibility()) {
				Main.board.setFacingUpAlreadyMessageVisible(false);
				Main.board.setOutOfRangeMessageVisible(true);
			}
			break;
			
		case '9':
			if (numKeysEnabled && Main.board.noMessagesAreVisible() && !Main.titleScreen.getVisibility()) {
				Main.board.setFacingUpAlreadyMessageVisible(false);
				Main.board.setOutOfRangeMessageVisible(true);
			}
			break;
			
		case '0':
			if (numKeysEnabled && Main.board.noMessagesAreVisible() && !Main.titleScreen.getVisibility()) {
				Main.board.setFacingUpAlreadyMessageVisible(false);
				Main.board.setOutOfRangeMessageVisible(true);
			}
			break;
		case '=':
			if (enterKeyEnabled) {
				if (Main.titleScreen.getVisibility() == true) {
					Main.titleScreen.setVisibility(false);
					Main.board.setVisibility(true);
					Main.board.setFirstQuestion(true); // Prevents the question from popping up in the title screen
					Main.board.setFirstColumn(true);
					enterKeyEnabled = false;
					numKeysEnabled = true;
					Main.board.shuffle();
				} else { // Responsible for throwing the user back to the first part
					if (Main.board.isHardLuckMessageVisible()) {
						Main.board.coverBoth(Main.board.getFirstColumn(), Main.board.getFirstRow(), Main.board.getSecondColumn(), Main.board.getSecondRow());
					}
					Main.board.makeAllMessagesExceptCongratulationsAndOutOfRangeDisappear();
					// throw back to first
					Main.board.setEnterStage(false);
					Main.board.setFirstQuestion(true);
					Main.board.setFirstColumn(true);
					Main.board.setSecondColumn(false);
					Main.board.setSecondRow(false); // EXTREMELY IMPORTANT!!!
					// set the keys back to normal!
					numKeysEnabled = true;
					enterKeyEnabled = false;
					Main.board.setFirstColumn(-1);
					Main.board.setSecondColumn(-1);
					Main.board.setFirstRow(-1);
					Main.board.setSecondColumn(-1);
					
					// Pass to Y if congratulationsMessage is visible
					if (Main.board.isCongratulationsMessageVisible()) {
						// Disable all keys except y or n, or enter (enter is required to get past the home screen)
						yKeyEnabled = true;
						nKeyEnabled = true;
						numKeysEnabled = false; // important, so that the game doesn't just keep going
						
						// cover all cards
						Main.board.coverAllCards();
						
						// Make Everything disappear
						Main.board.setVisibility(false);
						Main.board.setCongratulationsMessageVisible(false);
						Main.board.setSecondQuestion(false);
						Main.board.setFirstQuestion(false);
						
						// "Would you like to play again?" appears
						Main.board.setPlayAgainMessageVisible(true);
					}
				} 
			}
			break;
		
		case 'y':
			if (yKeyEnabled) {
				Main.board.setScore(0); // reset score
				Main.board.setTurns(0); // reset turns
				Main.board.setPlayAgainMessageVisible(false);
				Main.titleScreen.setVisibility(true);
				enterKeyEnabled = true;
			}
			break;
			
		case 'n':
			if (nKeyEnabled) {
				System.exit(0); // Exits game
			}
			break;
		
			
		case 'm':
			// For mouse coordinates
			Control.isMouseCoordsDisplayed = !Control.isMouseCoordsDisplayed;
			break;
			
		
		}
	}
	
	
	
}