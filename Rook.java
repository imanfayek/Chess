/*
 * Name:
 * Section Leader:
 * File: Rook.java
 * ------------------
 * This class represents the Rook type of chess piece. This piece can move and capture 
 * pieces along rows and columns. It is also known as a castle. For more information visit: 
 * http://en.wikipedia.org/wiki/Rook_(chess)
 */

public class Rook extends ChessPiece{

	/** Constructor for the Rook class */
	public Rook(int initialRow, int initialCol, int pieceColor)
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
		
		if (rowDiff == 0 && colDiff != 0){
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

	/** Implementation of getType() method for the Rook class. Provides a way to identify
	 *  the Rook-type chess piece as such (you don't need to change anything here)
	 */
	public PieceType getType() 
	{
		return PieceType.ROOK;
	}

}
