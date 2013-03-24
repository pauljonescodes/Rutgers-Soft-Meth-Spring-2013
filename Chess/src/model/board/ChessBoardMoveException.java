package model.board;

public class ChessBoardMoveException extends Exception {
	private static final long serialVersionUID = 95870756151442533L;
	
	public ChessBoardMoveException() {
		super();
	}

	public ChessBoardMoveException(String message) {
		super(message);
	}

	public ChessBoardMoveException(String message, Throwable cause) {
		super(message, cause);
	}

	public ChessBoardMoveException(Throwable cause) {
		super(cause);
	}
}
