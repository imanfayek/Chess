/*
 * Name:
 * Section Leader:
 * File: ChessBoard.java
 * ------------------
 * This class represents the ChessBoard. Its job is to keep track of where all
 * of the pieces are. Since we just learned about two-dimensional arrays, it 
 * might be a good idea to use one here (just a hint). Currently, it doesn't do 
 * anything, but it does have four methods for you to fill in. These are the only
 * required methods in this class. As long as these work, feel free to do whatever
 * else you want to get this class working.
 */

public class ChessBoard extends DrawableObject{

	/** Constant that sets the size of the chess board */
	public static final int BOARD_SIZE = 8;
	private ChessPiece[][] board;
	
	/** Constructor for the ChessBoard class (do whatever you want with this) */
	public ChessBoard()
	{
		board = new ChessPiece[BOARD_SIZE][BOARD_SIZE];
		addRooks();
		addKnights();
		addBishops();
		addKings();
		addQueens();
		addPawns();
	}
	
	private void addRooks() {
		Rook bLeft = new Rook(0, 0, ChessPiece.BLACK);
		addPiece(bLeft);
		Rook bRight = new Rook(0, 7, ChessPiece.BLACK);
		addPiece(bRight);
		Rook wLeft = new Rook(7, 0, ChessPiece.WHITE);
		addPiece(wLeft);
		Rook wRight = new Rook(7, 7, ChessPiece.WHITE);
		addPiece(wRight);
	}
	
	private void addKnights() {
		Knight bLeft = new Knight(0, 1, ChessPiece.BLACK);
		addPiece(bLeft);
		Knight bRight = new Knight(0, 6, ChessPiece.BLACK);
		addPiece(bRight);
		Knight wLeft = new Knight(7, 1, ChessPiece.WHITE);
		addPiece(wLeft);
		Knight wRight = new Knight(7, 6, ChessPiece.WHITE);
		addPiece(wRight);
	}
	
	private void addBishops() {
		Bishop bLeft = new Bishop(0, 2, ChessPiece.BLACK);
		addPiece(bLeft);
		Bishop bRight = new Bishop(0, 5, ChessPiece.BLACK);
		addPiece(bRight);
		Bishop wLeft = new Bishop(7, 2, ChessPiece.WHITE);
		addPiece(wLeft);
		Bishop wRight = new Bishop(7, 5, ChessPiece.WHITE);
		addPiece(wRight);
	}
	
	private void addKings() {
		King black = new King(0, 3, ChessPiece.BLACK);
		addPiece(black);
		King white = new King(7, 3, ChessPiece.WHITE);
		addPiece(white);
	}
	
	private void addQueens() {
		Queen black = new Queen(0, 4, ChessPiece.BLACK);
		addPiece(black);
		Queen white = new Queen(7, 4, ChessPiece.WHITE);
		addPiece(white);
	}
	
	private void addPawns() {
		for(int i = 0; i < BOARD_SIZE; i++) {
			Pawn black = new Pawn(1, i, ChessPiece.BLACK);
			addPiece(black);
			Pawn white = new Pawn(6, i, ChessPiece.WHITE);
			addPiece(white);
		}
	}

	/** Returns the ChessPiece currently residing at the specified row and 
	 * column. If no piece exists at the specified location, should return 
	 * null.
	 */
	public ChessPiece pieceAt(int row, int col)
	{
		return(board[row][col]);
	}
	
	/** Adds the specified ChessPiece to the ChessBoard (hint: ChessPieces know their
	 * own rows and columns. You can use this to figure out where to place the piece)
	 */
	public void addPiece(ChessPiece piece)
	{
		board[piece.getRow()][piece.getCol()] = piece;
	}
	
	/** Removes the piece at the specified location from the board.
	 */
	public void removePiece(int row, int col)
	{
		board[row][col] = null;
	}
	
}
