/*
 * Name:
 * Section Leader:
 * File: Pawn.java
 * ------------------
 * This class represents the Pawn type of chess piece. This piece can move only straight 
 * forward (away from your side toward the other side). In can normally move only one space
 * at a time, except on the first move, when it has the option of moving two spaces. The pawn,
 * although it moves only forward, captures only diagonally forward. Turns out, this makes it
 * the most difficult to implement in code (fair warning). For more information go 
 * here: http://en.wikipedia.org/wiki/Pawn_(chess)
 */

public class Pawn extends ChessPiece{

	/** Constructor for the Pawn class */
	public Pawn(int initialRow, int initialCol, int pieceColor)
	{
		this.row = initialRow;
		this.col = initialCol;
		this.color = pieceColor;
	}	

	/** Method that returns a boolean indicating whether or not the pawn can legally move
	 *  to the specified location (you need to fill this one in).
	 */
	public boolean canMoveTo(int row, int col, ChessBoard board)
	{
		int rowDiff = Math.abs(row - this.row);
		int colDiff = Math.abs(col - this.col);
		int wRow = this.row - row;
		int bRow = row - this.row;
		ChessPiece pieceInSpot = board.pieceAt(row, col);
		
		if((this.color == ChessPiece.WHITE && this.row == 6) || (this.color == ChessPiece.BLACK && this.row == 1)) {
			if ((rowDiff == 1 && colDiff == 0) || (rowDiff == 2 && colDiff == 0)) {
				if(moveWouldCauseCheck(row, col, board)) return false;
				else if(pieceInSpot != null){
					if(pieceInSpot.getColor() == this.color) {
							return false;
					} return true;
				} return true;
			} return false;
		} else if(this.color == ChessPiece.WHITE) {
			if(wRow == 1 && colDiff == 0) {
				if(moveWouldCauseCheck(row, col, board)) return false;
				else if(pieceInSpot == null) return true;
			} else if(wRow == 1 && colDiff == 1) {
				if(moveWouldCauseCheck(row, col, board)) return false;
				else if(pieceInSpot != null){
					if(pieceInSpot.getColor() == this.color) {
							return false;
					} return true;
				} return false;
			} return false;
		} else if(this.color == ChessPiece.BLACK) {
			if(bRow == 1 && colDiff == 0) {
				if(moveWouldCauseCheck(row, col, board)) return false;
				else if(pieceInSpot == null) return true;
			} else if(bRow == 1 && colDiff == 1) {
				if(moveWouldCauseCheck(row, col, board)) return false;
				else if(pieceInSpot != null){
					if(pieceInSpot.getColor() == this.color) {
							return false;
					} return true;
				} return false;
			} return false; 
		} return false;
	}

	/** Implementation of getType() method for the Pawn class. Provides a way to identify
	 *  the Pawn-type chess piece as such (you don't need to change anything here)
	 */
	public PieceType getType() 
	{
		return PieceType.PAWN;
	}
	
}
