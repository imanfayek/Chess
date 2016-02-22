/*
 * Name:
 * Section Leader:
 * File: Queen.java
 * ------------------
 * This class represents the Queen type of chess piece. This piece can move and capture
 * in any straight line (diagonally, horizontally, or vertically). For more information go 
 * here: http://en.wikipedia.org/wiki/Queen_(chess)
 */

public class Queen extends ChessPiece{

	/** Constructor for the Queen class */
	public Queen(int initialRow, int initialCol, int pieceColor)
	{
		this.row = initialRow;
		this.col = initialCol;
		this.color = pieceColor;
	}	
	
	/** Method that returns a boolean indicating whether or not the queen can legally move
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
		} else if (rowDiff == 0 && colDiff != 0){
			if(moveWouldCauseCheck(row, col, board)) return false;
			else if(pieceInSpot != null){
				if(pieceInSpot.getColor() == this.color) {
						return false;
				} return true;
			} else {
				for(int i = 1; i < colDiff; i++){
					if((this.col - col) > 0) {
						if(board.pieceAt(this.row, (this.col - i)) != null) {
							return false;
						}
					} else if((this.col - col) < 0) {
						if(board.pieceAt(this.row, (this.col + i)) != null) {
							return false;
						}
					} 
				} return true;
			}
		} else if (colDiff == 0 && rowDiff !=0) {
			if(moveWouldCauseCheck(row, col, board)) return false;
			else if(pieceInSpot != null){
				if(pieceInSpot.getColor() == this.color) {
						return false;
				} return true;
			} else {
				for(int i = 1; i < rowDiff; i++){
					if((this.row - row) > 0) {
						if(board.pieceAt((this.row - i), this.col) != null) {
							return false;
						}
					} else if((this.row - row) < 0) {
						if(board.pieceAt((this.row + i), this.col) != null) {
							return false;
						}
					} 
				} return true;
			}
		} return false;
	} 

	/** Implementation of getType() method for the Pawn class. Provides a way to identify
	 *  the Pawn-type chess piece as such (you don't need to change anything here)
	 */
	public PieceType getType() 
	{
		return PieceType.QUEEN;
	}
	
}
