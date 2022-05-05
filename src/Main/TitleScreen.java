package Main;

import Data.Vector2D;
import Data.spriteInfo;

public class TitleScreen {
	private spriteInfo logo;
	private String promptContinue; // Contains both "Good Luck!" and "Press Enter to Continue"
	private Vector2D promptContinueCoords;
	private String rulesWord;
	private Vector2D rulesWordCoords;
	private String ruleOne;
	private Vector2D ruleOneCoords;
	private String ruleTwo;
	private Vector2D ruleTwoCoords;
	private String ruleThree;
	private Vector2D ruleThreeCoords;
	private boolean isDisplayed;
	
	public TitleScreen() {
		this.isDisplayed = true;
		
	}
}
