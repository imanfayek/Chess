/*
 * Name:
 * Section Leader:
 * File: King.java
 * ------------------
 * This class represents the King type of chess piece. This piece can move (and capture) one 
 * space in any direction. If you lose it, you lose the game. For more information go here: 
 * http://en.wikipedia.org/wiki/King_(chess)
 */

public class King extends ChessPiece{
	
	/** Constructor for the King class */
	public King(int initialRow, int initialCol, int pieceColor)
	{
		this.row = initialRow;
		this.col = initialCol;
		this.color = pieceColor;
	}	
	
	/** Method that returns a boolean indicating whether or not the king can legally move
	 *  to the specified location (you need to fill this one in).
	 */
	public boolean canMoveTo(int row, int col, ChessBoard board)
	{	
		int rowDiff = Math.abs(row - this.row);
		int colDiff = Math.abs(col - this.col);
		int kingMove = 1;
		ChessPiece pieceInSpot = board.pieceAt(row, col);
		
		if((rowDiff == kingMove) && (colDiff == kingMove)) {
			if(moveWouldCauseCheck(row, col, board)) return false;
			else if(pieceInSpot != null){
				if(pieceInSpot.getColor() == this.color) {
						return false;
				} return true;
			} return true;
		} else if (rowDiff == 0 && colDiff == kingMove){
			if(moveWouldCauseCheck(row, col, board)) return false;
			else if(pieceInSpot != null){
				if(pieceInSpot.getColor() == this.color) {
						return false;
				} return true;
			} return true;
		} else if (colDiff == 0 && rowDiff == kingMove) {
			if(moveWouldCauseCheck(row, col, board)) return false;
			else if(pieceInSpot != null){
				if(pieceInSpot.getColor() == this.color) {
						return false;
				} return true;
			} return true;
		} return false;
	}
	
	/** Implementation of getType() method for the King class. Provides a way to identify
	 *  the King-type chess piece as such (you don't need to change anything here)
	 */
	public PieceType getType() 
	{
		return PieceType.KING;
	}
	
}
