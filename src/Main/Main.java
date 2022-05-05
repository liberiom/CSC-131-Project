/*
 * CSC 130 Final Project
 * Name: Liberio Mukdani
 * Professor: Matthew Phillips
 * 
 * 
 * 
 * Requirements and verifying that I meet the requirements (I hope):
 * 
 * Algorithms:
 * - Be a single screen “game” level (no scrolling)                                              -> Yes, should be obviously visible in runtime
 * - Have a character that moves in all four(4) directions (up, down, left, right)              -> Yes, should be visible in my implementation of the wasd keys in KeyProcessor.java
 * - Character must have animation equal to that in Checkpoint #3 for EACH direction!           -> Yes, when you move the character in any direction, the character also changes animation frames to make it look like its walking
 * - The edges of the screen must be wall images that visually contain the “room”               -> Yes, the wall is supposed to look like a wall of ruins, since the place is supposed to have a  "haunted" appearance
 * - Room must have a "ground" image (an image under the character's feet). No solid black!     -> Yes, the player is standing on "grass"
 * - These images must have bounding box collision detection to prevent the player from walking through them                   -> Yes, the boundaryBoxes ArrayList below holds the boundary boxes for the borders of the level
 * - There must be at least two (2) items inside of the “level” that can be examined when nearby and facing the object. Examining is done by looking at the item nearby and pressing the space bar           -> Yes, there are two items -- a key, a treasure box, and a door (if that counts), that all can be examined  
 * - Your program must display a description of the item examined when a user inspects it 		-> Yes, each item, when inspected, should have a dialog box that pops up that explains what item can do
 * - Your program must be free of errors, crashes, or warnings for credit 						-> Yes, or at least I hope so. I tested the program many times after the final edits have bene made, and there have been no errors thus far
 * 
 * Data Structures:
 * - Use at least one of the following Java Collections: ArrayList, Stack, or Queue for image data 			-> Yes, in the Player class, there are four Queues that hold the image data that change when the player moves
 * - Create a custom data type for the bounding box collision object (single bounding box with behavior) 	-> Yes, see BoundingBox,java
 * - Have a container that holds a collection of bounding boxes neatly 										-> Yes, below has the boundaryBoxes ArrayList that holds bounding boxes
 * 
 * 
 *
 * 
 * Notes about programmer customization:
 * - To change the speed of the Ghost, change the GHOST_FRAMES int in the Main class
 * - To change the speed of the player, change the speed int located in the Player class
 * 
 * Note about saving this project:
 * - Just a heads up to the future programmer editing this via Eclipse, saving any edits made in this class will prompt an error about unrecognizable characters. Just click "Save as UTF-8" characters, that's what worked for me.
 */


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
	private static Color white = new Color(255, 255, 255);
	
	// End Static fields...
	
	public static void main(String[] args) {
		Control ctrl = new Control();				// Do NOT remove!
		ctrl.gameLoop();							// Do NOT remove!
	}
	
	/* This is your access to things BEFORE the game loop starts */
	public static void start(){
		titleScreen = new TitleScreen();
		
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
	}
	
	
}
