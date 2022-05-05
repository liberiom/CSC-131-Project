package Main;

import Data.spriteInfo;
import Data.Vector2D;

public class Board {
	private spriteInfo sprite;
	private int X_COORD = 576;
	private int Y_COORD = 194;
	
	public Board() {
		sprite = new spriteInfo(new Vector2D(X_COORD, Y_COORD), "board");
	}
	
}
