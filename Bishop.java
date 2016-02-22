/*
 * Name:
 * Section Leader:
 * File: Bishop.java
 * ------------------
 * This class represents the Bishop type of chess piece. This piece can move and capture 
 * pieces along diagonals. For more information visit: http://en.wikipedia.org/wiki/Bishop_(chess)
 */

public class Bishop extends ChessPiece{

	/** Constructor for the Bishop class */
	public Bishop(int initialRow, int initialCol, int pieceColor)
	{
		this.row = initialRow;
		this.col = initialCol;
		this.color = pieceColor;
	}	
	
	/** Method that returns a boolean indicating whether or not the bishop can legally move
	 *  to the specified location (you need to fill this one in).
	 */
	public boolean canMoveTo(int row, int col, ChessBoard board)
	{
		int rowDiff = Math.abs(row - this.row);
		int colDiff = Math.abs(col - this.col);
		ChessPiece pieceInSpot = board.pieceAt(row, col);
		
		if(rowDiff == colDiff) {
			if(moveWouldCauseCheck(row, col, board)) return false;
			else if(pieceInSpot != null){
				if(pieceInSpot.getColor() == this.color) {
						return false;
			} return true;
			} else {
				for(int i = 1; i < rowDiff; i++) {
					if (((this.row - row) > 0) && ((this.col - col) > 0)) {
						if(board.pieceAt((this.row - i), (this.col - i)) != null) {
							return false;
						} 
					} else if (((this.row - row) > 0) && ((this.col - col) < 0)) {
						if(board.pieceAt((this.row - i), (this.col + i)) != null) {
							return false;
						}
					} else if (((this.row - row) < 0) && ((this.col - col) > 0)) {
						if(board.pieceAt((this.row + i), (this.col - i)) != null) {
							return false;
						}
					} else if (((this.row - row) < 0) && ((this.col - col) < 0)) {
						if(board.pieceAt((this.row + i), (this.col + i)) != null) {
							return false;
						}
					} 
				} return true;
			}
		} return false;
	}
	
	/** Implementation of getType() method for the Bishop class. Provides a way to identify
	 *  the Bishop-type chess piece as such (you don't need to change anything here)
	 */
	public PieceType getType() 
	{
		return PieceType.BISHOP;
	}
	
}
