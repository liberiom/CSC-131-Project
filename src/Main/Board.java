package Main;

import Data.spriteInfo;
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
	private boolean isVisible;
	
	public Board() {
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
}