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
	/*
	 * private Card[][] cards = { // Had to initialize up here because its easier to visualize
			{new Card(-100, new Vector2D(CARD_REFERENCE_X_COORD, CARD_REFERENCE_Y_COORD)), new Card(-100, new Vector2D(this.cards[0][1].getCoords().getX() + ROW_SPACING, this.cards[0][1].getCoords().getY())), new Card(-100, new Vector2D(this.cards[0][2].getCoords().getX() + ROW_SPACING, this.cards[0][2].getCoords().getY())), new Card(-100, new Vector2D(this.cards[0][3].getCoords().getX() + ROW_SPACING, this.cards[0][3].getCoords().getY()))},
			{new Card(-100, new Vector2D(X_COORD, Y_COORD)), new Card(-100, new Vector2D(X_COORD, Y_COORD)), new Card(-100, new Vector2D(X_COORD, Y_COORD)), new Card(-100, new Vector2D(X_COORD, Y_COORD))},
			{new Card(-100, new Vector2D(X_COORD, Y_COORD)), new Card(-100, new Vector2D(X_COORD, Y_COORD)), new Card(-100, new Vector2D(X_COORD, Y_COORD)), new Card(-100, new Vector2D(X_COORD, Y_COORD))},
			{new Card(-100, new Vector2D(X_COORD, Y_COORD)), new Card(-100, new Vector2D(X_COORD, Y_COORD)), new Card(-100, new Vector2D(X_COORD, Y_COORD)), new Card(-100, new Vector2D(X_COORD, Y_COORD))}
	};
	 */
	
	
	
	public Board() {
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
		
		this.shuffle();
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
	
	
	private void shuffle() {
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
		int tempNumber = 0;
		Card tempCard = this.cards[rng.nextInt(4)][rng.nextInt(4)]; 
		Card tempCard2 = this.cards[rng.nextInt(4)][rng.nextInt(4)]; 
		for (int i = 0; i < iterations; i++) {
			tempNumber = tempCard.getNumber();
			tempCard.setNumber(tempCard2.getNumber());
			tempCard2.setNumber(tempNumber);
		}
	}
	
	
	
}
