package Main;

import Data.spriteInfo;

import java.util.Random;

import Data.Vector2D;

public class Board {
	private spriteInfo sprite;
	private final int X_COORD = 520;
	private final int Y_COORD = 318;
	private Vector2D rowNumberOne;
	private Vector2D columnNumberOne;
	private Vector2D rowNumberTwo;
	private Vector2D columnNumberTwo;
	private Vector2D rowNumberThree;
	private Vector2D columnNumberThree;
	private Vector2D rowNumberFour;
	private Vector2D columnNumberFour;
	private final int ROW_SPACING = 225;
	private final int COLUMN_SPACING = 100;
	private final int CARD_REFERENCE_X_COORD = 624;
	private final int CARD_REFERENCE_Y_COORD = 375;
	private boolean isVisible;
	private Card[][] cards;
	private static Random rng;
	private int counter = 1;
	
	// Question-related stuff
	private boolean isFirstQuestion;
	private boolean isFirstRow;
	private boolean isFirstColumn;
	private boolean isSecondQuestion;
	private boolean isSecondRow;
	private boolean isSecondColumn;
	private int firstRow = -1;
	private int firstColumn = -1;
	private int secondRow = -1;
	private int secondColumn = -1;
	private boolean isYouFoundMatchMessageVisible;
	private boolean isHardLuckMessageVisible;
	private boolean isCongratulationsMessageVisible;
	private boolean isFacingUpAlreadyMessageVisible;
	private boolean enterKeyPressed = false;
	
	public boolean isEnterKeyPressed() {
		return enterKeyPressed;
	}

	public void setEnterKeyPressed(boolean enterKeyPressed) {
		this.enterKeyPressed = enterKeyPressed;
	}

	public void makeAllMessagesDisappear() {
		this.isYouFoundMatchMessageVisible = false;
		this.isHardLuckMessageVisible = false;
		this.isCongratulationsMessageVisible = false; //  may not need to be here
		this.isFacingUpAlreadyMessageVisible = false;
	}
	
	public boolean isFacingUpAlreadyMessageVisible() {
		return isFacingUpAlreadyMessageVisible;
	}

	public void setFacingUpAlreadyMessageVisible(boolean isFacingUpAlreadyMessageVisible) {
		this.isFacingUpAlreadyMessageVisible = isFacingUpAlreadyMessageVisible; 
	}

	public void recordAnswerAndMoveOn(int answer) {
		if (isFirstQuestion && isFirstRow) {
			if ((firstRow != -1) && (firstColumn != -1) && (secondRow != -1) && (secondColumn != -1)) {
				this.coverBoth(firstRow, firstColumn, secondRow, secondColumn);
			}
			firstRow = answer;
			isFirstRow = false;
			isFirstColumn = true;
		} else if (isFirstQuestion && isFirstColumn) {
			firstColumn = answer;
			if (this.alreadyFacingUp(firstRow, firstColumn)) {
				isFacingUpAlreadyMessageVisible = true;
			} else {
				isFirstColumn = false;
				isFirstQuestion = false;
				isSecondQuestion = true;
				isSecondRow = true;
				this.uncover(firstRow, firstColumn);
			}
		} else if (isSecondQuestion && isSecondRow) {
			secondRow = answer;
			isSecondRow = false;
			isSecondColumn = true;
		} else if (isSecondQuestion && isSecondColumn) {
			secondColumn = answer;
			if (this.alreadyFacingUp(secondRow, secondColumn)) {
				isFacingUpAlreadyMessageVisible = true;
			} else {
				isSecondColumn = false;
				isSecondQuestion = false;
				isFirstQuestion = true;
				isFirstRow = true;
				this.uncover(secondRow, secondColumn);
				if (this.match(firstRow, firstColumn, secondRow, secondColumn)) {
					if (this.didPlayerWinGame()) {
						isCongratulationsMessageVisible = true;
					} else {
						isYouFoundMatchMessageVisible = true;
					} 
				} else {
					isHardLuckMessageVisible = true; 
				}
				// reset first and second rows and columns
				firstRow = -1;
				secondRow = -1;
				firstColumn = -1;
				secondColumn = -1;
			}
		} 
	}
	
	public boolean isAMessageShowing() {
		return (isYouFoundMatchMessageVisible == true) || (isHardLuckMessageVisible == true) || (isCongratulationsMessageVisible == true) || (isFacingUpAlreadyMessageVisible == true);
	}
	
	private boolean alreadyFacingUp(int row, int column) {
		return this.cards[row - 1][column - 1].isShowingNumber();
	}
	
	private void coverBoth(int firstRow, int firstColumn, int secondRow, int secondColumn) {
		this.cards[firstRow - 1][firstColumn - 1].setShowingNumber(false);
		this.cards[secondRow - 1][secondColumn - 1].setShowingNumber(false);	
	}
	
	public boolean isYouFoundMatchMessageVisible() {
		return isYouFoundMatchMessageVisible;
	}

	public boolean isHardLuckMessageVisible() {
		return isHardLuckMessageVisible;
	}

	public boolean isCongratulationsMessageVisible() {
		return isCongratulationsMessageVisible;
	}

	public void setYouFoundMatchMessageVisible(boolean isYouFoundMatchMessageVisible) {
		this.isYouFoundMatchMessageVisible = isYouFoundMatchMessageVisible;
	}

	public void setHardLuckMessageVisible(boolean isHardLuckMessageVisible) {
		this.isHardLuckMessageVisible = isHardLuckMessageVisible;
	}

	public void setCongratulationsMessageVisible(boolean isCongratulationsMessageVisible) {
		this.isCongratulationsMessageVisible = isCongratulationsMessageVisible;
	}

	private boolean match(int firstRow, int firstColumn, int secondRow, int secondColumn) {
		return this.cards[firstRow - 1][firstColumn - 1].getNumber() == this.cards[secondRow - 1][secondColumn - 1].getNumber();
	}
	
	private boolean didPlayerWinGame() {
		return false; // TODO: Fix this
	}
	private void uncover(int row, int column) {
		this.cards[row - 1][column - 1].setShowingNumber(true);
	}
	public boolean isFirstRow() {
		return isFirstRow;
	}

	public boolean isFirstColumn() {
		return isFirstColumn;
	}

	public boolean isSecondQuestion() {
		return isSecondQuestion;
	}

	public boolean isSecondRow() {
		return isSecondRow;
	}

	public boolean isSecondColumn() {
		return isSecondColumn;
	}

	public void setFirstRow(boolean isFirstRow) {
		this.isFirstRow = isFirstRow;
	}

	public void setFirstColumn(boolean isFirstColumn) {
		this.isFirstColumn = isFirstColumn;
	}

	public void setSecondQuestion(boolean isSecondQuestion) {
		this.isSecondQuestion = isSecondQuestion;
	}

	public void setSecondRow(boolean isSecondRow) {
		this.isSecondRow = isSecondRow;
	}

	public void setSecondColumn(boolean isSecondColumn) {
		this.isSecondColumn = isSecondColumn;
	}

	public boolean isFirstQuestion() {
		return isFirstQuestion;
	}

	public void setFirstQuestion(boolean isFirstQuestion) {
		this.isFirstQuestion = isFirstQuestion;
	}
	
	/*
	 * Constructor is here!!!
	 */
	public Board() {
		// Question-related booleans
		isFirstQuestion = false;
		isFirstRow = true;
		isFirstColumn = false;
		isSecondQuestion = false;
		isSecondRow = false;
		isSecondColumn = false;
		
		rng = new Random();
		isVisible = false;
		sprite = new spriteInfo(new Vector2D(X_COORD, Y_COORD), "board");
		
		// Use this as reference for other numbers
		rowNumberOne = new Vector2D(this.sprite.getCoords().getX() + 100, this.sprite.getCoords().getY() - 40);
		columnNumberOne = new Vector2D(this.sprite.getCoords().getX() - 30, this.sprite.getCoords().getY() + 50);
		
		rowNumberTwo = new Vector2D(this.rowNumberOne.getX() + ROW_SPACING, this.rowNumberOne.getY());
		columnNumberTwo = new Vector2D(this.columnNumberOne.getX(), this.columnNumberOne.getY() + COLUMN_SPACING);
		
		rowNumberThree = new Vector2D(this.rowNumberTwo.getX() + ROW_SPACING, this.rowNumberTwo.getY());
		columnNumberThree = new Vector2D(this.columnNumberTwo.getX(), this.columnNumberTwo.getY() + COLUMN_SPACING);
		
		rowNumberFour = new Vector2D(this.rowNumberThree.getX() + ROW_SPACING, this.rowNumberThree.getY());
		columnNumberFour = new Vector2D(this.columnNumberThree.getX(), this.columnNumberThree.getY() + COLUMN_SPACING);
		
		this.cards = new Card[4][4];
		
		this.cards[0][0] = new Card(-100, new Vector2D(CARD_REFERENCE_X_COORD, CARD_REFERENCE_Y_COORD));
		
		for (int i = 1; i < 4; i++) { // Columns
			this.cards[i][0] = new Card(new Vector2D(CARD_REFERENCE_X_COORD, this.cards[i - 1][0].getCoords().getY() + COLUMN_SPACING));
		}
		
		for (int i = 0; i < 4; i++) { // Rows
			for (int j = 1; j < 4; j++) {
				this.cards[i][j] = new Card(new Vector2D(this.cards[i][j - 1].getCoords().getX() + ROW_SPACING, this.cards[i][j - 1].getCoords().getY()));
			}
		}
		
		// this.shuffle(); --> redundant, is already used in the KeyProcess class 
	}
	
	public Card[][] getCards() {
		return cards;
	}

	public void setCards(Card[][] cards) {
		this.cards = cards;
	}

	public Vector2D getRowNumberOne() {
		return rowNumberOne;
	}

	public Vector2D getColumnNumberOne() {
		return columnNumberOne;
	}

	public Vector2D getRowNumberTwo() {
		return rowNumberTwo;
	}

	public Vector2D getColumnNumberTwo() {
		return columnNumberTwo;
	}

	public Vector2D getRowNumberThree() {
		return rowNumberThree;
	}

	public Vector2D getColumnNumberThree() {
		return columnNumberThree;
	}

	public Vector2D getRowNumberFour() {
		return rowNumberFour;
	}

	public Vector2D getColumnNumberFour() {
		return columnNumberFour;
	}

	public void setSprite(spriteInfo sprite) {
		this.sprite = sprite;
	}

	public void setRowNumberOne(Vector2D rowNumberOne) {
		this.rowNumberOne = rowNumberOne;
	}

	public void setColumnNumberOne(Vector2D columnNumberOne) {
		this.columnNumberOne = columnNumberOne;
	}

	public void setRowNumberTwo(Vector2D rowNumberTwo) {
		this.rowNumberTwo = rowNumberTwo;
	}

	public void setColumnNumberTwo(Vector2D columnNumberTwo) {
		this.columnNumberTwo = columnNumberTwo;
	}

	public void setRowNumberThree(Vector2D rowNumberThree) {
		this.rowNumberThree = rowNumberThree;
	}

	public void setColumnNumberThree(Vector2D columnNumberThree) {
		this.columnNumberThree = columnNumberThree;
	}

	public void setRowNumberFour(Vector2D rowNumberFour) {
		this.rowNumberFour = rowNumberFour;
	}

	public void setColumnNumberFour(Vector2D columnNumberFour) {
		this.columnNumberFour = columnNumberFour;
	}

	public boolean getVisibility() {
		return this.isVisible;
	}
	
	public void setVisibility(boolean bool) {
		this.isVisible = bool;
	}
	
	public spriteInfo getSprite() {
		return this.sprite;
	}
	
	
	public void shuffle() { // Public so that KeyProcess can access this
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j += 2) {
				this.cards[i][j].setNumber(counter);
				this.cards[i][j + 1].setNumber(counter);
				this.counter++;
			}
		}
		this.swap(rng.nextInt(10) + 40); // Swap 40-50 times
	}
	
	private void swap(int iterations) {
		int tempNumber;
		Card tempCard;
		Card tempCard2;
		for (int i = 0; i < iterations; i++) {
			tempNumber = 0;
			tempCard = this.cards[rng.nextInt(4)][rng.nextInt(4)]; 
			tempCard2 = this.cards[rng.nextInt(4)][rng.nextInt(4)]; 
			tempNumber = tempCard.getNumber();
			tempCard.setNumber(tempCard2.getNumber());
			tempCard2.setNumber(tempNumber);
		}
	}
}
