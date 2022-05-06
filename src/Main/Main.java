

package Main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.StringTokenizer;

import Data.BoundingBox;
import Data.Vector2D;
import Data.spriteInfo;
import FileIO.EZFileRead;
import logic.Control;
import timer.stopWatchX;

public class Main{
	/*
	 * Static methods are below
	 */
	public static TitleScreen titleScreen; 
	public static Board board;
	private static Color white = new Color(255, 255, 255);
	
	// End Static fields...
	
	public static void main(String[] args) {
		Control ctrl = new Control();				// Do NOT remove!
		ctrl.gameLoop();							// Do NOT remove!
	}
	
	/* This is your access to things BEFORE the game loop starts */
	public static void start(){
		titleScreen = new TitleScreen();
		board = new Board();
	} 
	
	/* This is your access to the "game loop" (It is a "callback" method from the Control class (do NOT modify that class!))*/
	public static void update(Control ctrl) {
		if (titleScreen.getVisibility() == true) {
			ctrl.addSpriteToFrontBuffer(titleScreen.getLogo().getCoords().getX(), titleScreen.getLogo().getCoords().getY(), titleScreen.getLogo().getTag());
			ctrl.drawString(titleScreen.getRulesWordCoords().getX(), titleScreen.getRulesWordCoords().getY(), titleScreen.getRulesWord(), white);
			ctrl.drawString(titleScreen.getRuleOneCoords().getX(), titleScreen.getRuleOneCoords().getY(), titleScreen.getRuleOne(), white);
			ctrl.drawString(titleScreen.getRuleTwoCoords().getX(), titleScreen.getRuleTwoCoords().getY(), titleScreen.getRuleTwo(), white);
			ctrl.drawString(titleScreen.getRuleThreeCoords().getX(), titleScreen.getRuleThreeCoords().getY(), titleScreen.getRuleThree(), white);
			ctrl.drawString(titleScreen.getPromptContinueCoords().getX(), titleScreen.getPromptContinueCoords().getY(), titleScreen.getPromptContinue(), white);
		}
		
		if (board.getVisibility()) {
			ctrl.addSpriteToFrontBuffer(board.getSprite().getCoords().getX(), board.getSprite().getCoords().getY(), board.getSprite().getTag());
			// Display numbers
			ctrl.drawString(board.getRowNumberOne().getX(), board.getRowNumberOne().getY(), "1", white);
			ctrl.drawString(board.getColumnNumberOne().getX(), board.getColumnNumberOne().getY(), "1", white);
			ctrl.drawString(board.getRowNumberTwo().getX(), board.getRowNumberTwo().getY(), "2", white);
			ctrl.drawString(board.getColumnNumberTwo().getX(), board.getColumnNumberTwo().getY(), "2", white);
			ctrl.drawString(board.getRowNumberThree().getX(), board.getRowNumberThree().getY(), "3", white);
			ctrl.drawString(board.getColumnNumberThree().getX(), board.getColumnNumberThree().getY(), "3", white);
			ctrl.drawString(board.getRowNumberFour().getX(), board.getRowNumberFour().getY(), "4", white);
			ctrl.drawString(board.getColumnNumberFour().getX(), board.getColumnNumberFour().getY(), "4", white);
		}
		
		if (board.getCards()[0][0].isShowingNumber()) {
			ctrl.drawString(board.getCards()[0][0].getCoords().getX(), board.getCards()[0][0].getCoords().getY(), Integer.toString(board.getCards()[0][0].getNumber()), white);
		}
		
		if (board.getCards()[0][1].isShowingNumber()) {
			ctrl.drawString(board.getCards()[0][1].getCoords().getX(), board.getCards()[0][1].getCoords().getY(), Integer.toString(board.getCards()[0][1].getNumber()), white);
		}
		
		if (board.getCards()[0][2].isShowingNumber()) {
			ctrl.drawString(board.getCards()[0][2].getCoords().getX(), board.getCards()[0][2].getCoords().getY(), Integer.toString(board.getCards()[0][2].getNumber()), white);
		}
		
		if (board.getCards()[0][3].isShowingNumber()) {
			ctrl.drawString(board.getCards()[0][3].getCoords().getX(), board.getCards()[0][3].getCoords().getY(), Integer.toString(board.getCards()[0][3].getNumber()), white);
		}
		
		if (board.getCards()[1][0].isShowingNumber()) {
			ctrl.drawString(board.getCards()[1][0].getCoords().getX(), board.getCards()[1][0].getCoords().getY(), Integer.toString(board.getCards()[1][0].getNumber()), white);
		}
		
		if (board.getCards()[1][1].isShowingNumber()) {
			ctrl.drawString(board.getCards()[1][1].getCoords().getX(), board.getCards()[1][1].getCoords().getY(), Integer.toString(board.getCards()[1][1].getNumber()), white);
		}
		
		if (board.getCards()[1][2].isShowingNumber()) {
			ctrl.drawString(board.getCards()[1][2].getCoords().getX(), board.getCards()[1][2].getCoords().getY(), Integer.toString(board.getCards()[1][2].getNumber()), white);
		}
		
		if (board.getCards()[1][3].isShowingNumber()) {
			ctrl.drawString(board.getCards()[1][3].getCoords().getX(), board.getCards()[1][3].getCoords().getY(), Integer.toString(board.getCards()[1][3].getNumber()), white);
		}
		
		if (board.getCards()[2][0].isShowingNumber()) {
			ctrl.drawString(board.getCards()[2][0].getCoords().getX(), board.getCards()[2][0].getCoords().getY(), Integer.toString(board.getCards()[2][0].getNumber()), white);
		}
		
		if (board.getCards()[2][1].isShowingNumber()) {
			ctrl.drawString(board.getCards()[2][1].getCoords().getX(), board.getCards()[2][1].getCoords().getY(), Integer.toString(board.getCards()[2][1].getNumber()), white);
		}
		
		if (board.getCards()[2][2].isShowingNumber()) {
			ctrl.drawString(board.getCards()[2][2].getCoords().getX(), board.getCards()[2][2].getCoords().getY(), Integer.toString(board.getCards()[2][2].getNumber()), white);
		}
		
		if (board.getCards()[2][3].isShowingNumber()) {
			ctrl.drawString(board.getCards()[2][3].getCoords().getX(), board.getCards()[2][3].getCoords().getY(), Integer.toString(board.getCards()[2][3].getNumber()), white);
		}
		
		if (board.getCards()[3][0].isShowingNumber()) {
			ctrl.drawString(board.getCards()[3][0].getCoords().getX(), board.getCards()[3][0].getCoords().getY(), Integer.toString(board.getCards()[3][0].getNumber()), white);
		}
		
		if (board.getCards()[3][1].isShowingNumber()) {
			ctrl.drawString(board.getCards()[3][1].getCoords().getX(), board.getCards()[3][1].getCoords().getY(), Integer.toString(board.getCards()[3][1].getNumber()), white);
		}
		
		if (board.getCards()[3][2].isShowingNumber()) {
			ctrl.drawString(board.getCards()[3][2].getCoords().getX(), board.getCards()[3][2].getCoords().getY(), Integer.toString(board.getCards()[3][2].getNumber()), white);
		}
		
		if (board.getCards()[3][3].isShowingNumber()) {
			ctrl.drawString(board.getCards()[3][3].getCoords().getX(), board.getCards()[3][3].getCoords().getY(), Integer.toString(board.getCards()[3][3].getNumber()), white);
		}
		
		if (board.isFirstQuestion() && board.isFirstRow()) {
			ctrl.drawString(519, 833, "What is the First Card you would like to see? Please type the row number", white);
		} else if (board.isFirstQuestion() && board.isFirstColumn()) {
			ctrl.drawString(519, 833, "What is the First Card you would like to see? Please type the column number", white);
		}
		
		if (board.isSecondQuestion() && board.isSecondRow()) {
			ctrl.drawString(519, 833, "What is the Second Card you would like to see? Please type the row number", white);
		} else if (board.isSecondQuestion() && board.isSecondColumn()) {
			ctrl.drawString(519, 833, "What is the Second Card you would like to see? Please type the column number", white);
		}
		
		if (board.isYouFoundMatchMessageVisible()) {
			ctrl.drawString(509, 92, "Hey! You found a match! Good job! Press Enter to continue", white);
		} 	
		
		if (board.isHardLuckMessageVisible()) {
			ctrl.drawString(509, 92, "Hard luck! Not a match! Press Enter to continue", white);
		}
		
		if (board.isFacingUpAlreadyMessageVisible()) {
			ctrl.drawString(509, 92, "That Card is already facing up", white);
		}
		
		if (board.isCongratulationsMessageVisible()) {
			ctrl.drawString(509, 92, "Congratulations! You found all the matches! Press Enter to continue", white);
		}

		if (board.isOutOfRangeMessageVisible()) {
			ctrl.drawString(509, 92, "That number is out of range. Enter a number between 1 and 4", white);
		}
		
		if (board.isPlayAgainMessageVisible()) {
			ctrl.drawString(1009, 92, "Would you like to play again? Type Y to play again or N to quit", white);
		}
	}
	
	
}
