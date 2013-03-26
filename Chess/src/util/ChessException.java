package util;

/**
 * 
 * @author Paul Jones
 *
 */

public class ChessException extends Exception {
	private static final long serialVersionUID = 95870756151442533L;

	public ChessException() {
		super();
	}

	public ChessException(String message) {
		super(message);
	}

	public ChessException(String message, Throwable cause) {
		super(message, cause);
	}

	public ChessException(Throwable cause) {
		super(cause);
	}
}
