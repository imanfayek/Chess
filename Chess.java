/*
 * Name:
 * Section Leader:
 * File: Chess.java
 * ------------------
 * This program plays the game Chess.
 */

import java.awt.Color;
import java.awt.event.*;

/** The main class responsible for managing the chess game */
public class Chess extends GraphicsProgram{

	/** Object responsible for handling the graphical display on the screen */
	ChessDisplay display;
	
	/** Object that keeps track of the locations of all pieces */
	ChessBoard board;

	/** Method called before run responsible for initializing the ChessDisplay and 
	 *  ChessBoard objects */
	public void init()
	{
		display = ChessDisplay.getInstance(this);			
		board = new ChessBoard();
		display.useRealChessLabels(false);					
		display.draw(board);
		
		turnColor = ChessPiece.WHITE;
		turnData = new int[3];
		turnData[0] = 0;
		turnData[1] = 0;
		turnData[2] = CLICK_ONE;
	}
	
	/** The main method that runs the program */
	public void run()
	{
		addMouseListeners();
		
	}
	
	public void mousePressed(MouseEvent e) {
		
		click = display.getLocation(e.getX(), e.getY());
		row = click[0];
		col = click[1];
				
		if(turnData[2] == CLICK_ONE) {
			
			if(board.pieceAt(row, col).color == turnColor) {
				
				display.selectSquare(row, col, Color.YELLOW);
				turnData[0] = row;
				turnData[1] = col;
				display.draw(board);
				turnData[2] = CLICK_TWO;
				
			}
			
		} else if(turnData[2] == CLICK_TWO){
			
			ChessPiece piece = board.pieceAt(turnData[0], turnData[1]);
			
			if (piece.canMoveTo(row, col, board) && ((row != turnData[0]) || (col != turnData[1]))) {
				
				
				board.removePiece(turnData[0], turnData[1]);
				piece.moveTo(row, col);
				board.addPiece(piece);
				display.unselectAll();
				display.draw(board);
				
				if(turnColor == ChessPiece.WHITE) {
					
					turnColor = ChessPiece.BLACK;
					
				} else if (turnColor == ChessPiece.BLACK) {
					
					turnColor = ChessPiece.WHITE;
				}
				turnData[2] = CLICK_ONE;
				if(isInCheckMate(board, turnColor)) {
					
					println("Checkmate. You have lost.");
					turnData[2] = END;
					
				}
				if(isInStalemate(board, turnColor)) {
					
					println("Draw.");
					turnData[2] = END;
				}
			} else {
				
				display.unselectAll();
				display.draw(board);
				turnData[2] = CLICK_ONE;
			}
		}
	}
	
	private int row, col, turnColor;
	private static final int CLICK_ONE = 1;
	private static final int CLICK_TWO = 2;
	private static final int END = 0;
	private int[] turnData, click;
	
}

