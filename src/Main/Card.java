package Main;

import Data.Vector2D;

public class Card {
	private int number = -100;
	private Vector2D coords;
	private boolean isShowingNumber;
	
	public Card(int number, Vector2D coords) {
		this.number = number;
		this.coords = coords;
		this.isShowingNumber = true; // TODO: CHANGE TO FALSE LATER!!!
	}
	
	public Card() { // Alternative Constructor
		
	}
	
	public Card(Vector2D coords) {
		this.coords = coords;
		this.isShowingNumber = true; // TOOD: CHANGE TO FALSE LATER!!!
	}

	public int getNumber() {
		return number;
	}

	public Vector2D getCoords() {
		return coords;
	}

	public boolean isShowingNumber() {
		return isShowingNumber;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setCoords(Vector2D coords) {
		this.coords = coords;
	}

	public void setShowingNumber(boolean isShowingNumber) {
		this.isShowingNumber = isShowingNumber;
	}
	
	
}
