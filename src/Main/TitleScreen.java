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
	private final int LINE_SPACING = 100;
	private final int LOGO_HEIGHT = 421;
	
	public TitleScreen() {
		this.isDisplayed = true;
		logo = new spriteInfo(new Vector2D(685, 50), "logo");
		rulesWord = "Rules:";
		rulesWordCoords = new Vector2D(logo.getCoords().getX() - 50, logo.getCoords().getY() + LOGO_HEIGHT); 
		ruleOne = "1. There are numbers in the table which range from 1 to 8.";
		ruleOneCoords = new Vector2D(rulesWordCoords.getX(), rulesWordCoords.getY() + LINE_SPACING);
		ruleTwo = "2. The goal of the game is to find 2 pairs of the same number.";
		ruleTwoCoords = new Vector2D(ruleOneCoords.getX(), ruleOneCoords.getY() + LINE_SPACING);
		ruleThree = "3. You can only select between 1 to 4 for both the row and the column!";
		ruleThreeCoords = new Vector2D(ruleTwoCoords.getX(), ruleTwoCoords.getY() + LINE_SPACING);
		promptContinue = "Press Enter to Continue";
		promptContinueCoords = new Vector2D(ruleThreeCoords.getX(), ruleThreeCoords.getY() + LINE_SPACING);
		KeyProcessor.enterKeyEnabled = true;
	}
	
	public boolean getVisibility() {
		return this.isDisplayed;
	}
	
	public void setVisibility(boolean bool) {
		this.isDisplayed = bool;
	}
	
	public spriteInfo getLogo() {
		return this.logo;
	}

	public String getPromptContinue() {
		return promptContinue;
	}

	public Vector2D getPromptContinueCoords() {
		return promptContinueCoords;
	}

	public String getRulesWord() {
		return rulesWord;
	}

	public Vector2D getRulesWordCoords() {
		return rulesWordCoords;
	}

	public String getRuleOne() {
		return ruleOne;
	}

	public Vector2D getRuleOneCoords() {
		return ruleOneCoords;
	}

	public String getRuleTwo() {
		return ruleTwo;
	}

	public Vector2D getRuleTwoCoords() {
		return ruleTwoCoords;
	}

	public String getRuleThree() {
		return ruleThree;
	}

	public Vector2D getRuleThreeCoords() {
		return ruleThreeCoords;
	}

	public void setPromptContinue(String promptContinue) {
		this.promptContinue = promptContinue;
	}

	public void setPromptContinueCoords(Vector2D promptContinueCoords) {
		this.promptContinueCoords = promptContinueCoords;
	}

	public void setRulesWord(String rulesWord) {
		this.rulesWord = rulesWord;
	}

	public void setRulesWordCoords(Vector2D rulesWordCoords) {
		this.rulesWordCoords = rulesWordCoords;
	}

	public void setRuleOne(String ruleOne) {
		this.ruleOne = ruleOne;
	}

	public void setRuleOneCoords(Vector2D ruleOneCoords) {
		this.ruleOneCoords = ruleOneCoords;
	}

	public void setRuleTwo(String ruleTwo) {
		this.ruleTwo = ruleTwo;
	}

	public void setRuleTwoCoords(Vector2D ruleTwoCoords) {
		this.ruleTwoCoords = ruleTwoCoords;
	}

	public void setRuleThree(String ruleThree) {
		this.ruleThree = ruleThree;
	}

	public void setRuleThreeCoords(Vector2D ruleThreeCoords) {
		this.ruleThreeCoords = ruleThreeCoords;
	}
}
