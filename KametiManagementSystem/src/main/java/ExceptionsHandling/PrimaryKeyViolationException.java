package ExceptionsHandling;

public class PrimaryKeyViolationException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PrimaryKeyViolationException(String message) {
        super(message);
    }
}
