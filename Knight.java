/*
 * Name:
 * Section Leader:
 * File: Knight.java
 * ------------------
 * This class represents the Knight type of chess piece. This piece can move only in 
 * L-shapes. That is it moves two spaces in one direction and one space in an orthogonal
 * direction. It is the only piece in chess that can jump over other pieces. For
 * more information go here: http://en.wikipedia.org/wiki/Knight_(chess)
 */

public class Knight extends ChessPiece{

	/** Constructor for the Knight class */
	public Knight(int initialRow, int initialCol, int pieceColor)
	{
		this.row = initialRow;
		this.col = initialCol;
		this.color = pieceColor;
	}		
	
	/** Method that returns a boolean indicating whether or not the knight can legally move
	 *  to the specified location (you need to fill this one in).
	 */
	public boolean canMoveTo(int row, int col, ChessBoard board)
	{
		int rowDiff = Math.abs(row - this.row);
		int colDiff = Math.abs(col - this.col);
		ChessPiece pieceInSpot = board.pieceAt(row, col);
		
		if((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2)) {
			if(pieceInSpot != null) {
				if(pieceInSpot.getColor() == this.color) {
					return false;
				} else {
					if(moveWouldCauseCheck(row, col, board)) {
						return false;
					} else {
						return true;
					}
				}
				
			} else {
				return true;
			}
			
		} else {
			return false;
		}
	}
	
	/** Implementation of getType() method for the Knight class. Provides a way to identify
	 *  the Knight-type chess piece as such (you don't need to change anything here)
	 */
	public PieceType getType() 
	{
		return PieceType.KNIGHT;
	}
	
}
