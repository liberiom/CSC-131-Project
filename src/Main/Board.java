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
	private final int ROW_SPACING = 110;
	private final int COLUMN_SPACING = 100;
	private boolean isVisible;
	
	public Board() {
		isVisible = false;
		sprite = new spriteInfo(new Vector2D(X_COORD, Y_COORD), "board");
		
		// Use this as reference for other numbers
		rowNumberOne = new Vector2D(this.sprite.getCoords().getX() + 100, this.sprite.getCoords().getY() - 60);
		columnNumberOne = new Vector2D(this.sprite.getCoords().getX() - 30, this.sprite.getCoords().getY() + 50);
		
		rowNumberTwo = new Vector2D(this.rowNumberOne.getX() + ROW_SPACING, this.columnNumberOne.getY());
		columnNumberTwo = new Vector2D(this.columnNumberOne.getX(), this.columnNumberOne.getY() + COLUMN_SPACING);
		rowNumberThree = new Vector2D(this.rowNumberTwo.getX() + ROW_SPACING, this.columnNumberTwo.getY());
		columnNumberThree = new Vector2D(this.columnNumberTwo.getX(), this.columnNumberTwo.getY() + COLUMN_SPACING);
		rowNumberFour = new Vector2D(this.rowNumberThree.getX() + ROW_SPACING, this.columnNumberThree.getY());
		columnNumberFour = new Vector2D(this.columnNumberThree.getX(), this.columnNumberThree.getY() + COLUMN_SPACING);
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
