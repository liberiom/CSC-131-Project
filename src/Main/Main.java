

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
			ctrl.drawString(board.getRowNumberTwo().getX(), board.getColumnNumberTwo().getY(), "2", white);
			ctrl.drawString(board.getColumnNumberTwo().getX(), board.getColumnNumberTwo().getY(), "2", white);
			ctrl.drawString(board.getRowNumberThree().getX(), board.getRowNumberThree().getY(), "3", white);
			ctrl.drawString(board.getColumnNumberThree().getX(), board.getColumnNumberThree().getY(), "3", white);
			ctrl.drawString(board.getRowNumberFour().getX(), board.getRowNumberFour().getY(), "4", white);
			ctrl.drawString(board.getColumnNumberFour().getX(), board.getColumnNumberFour().getY(), "4", white);
		}
	}
	
	
}
