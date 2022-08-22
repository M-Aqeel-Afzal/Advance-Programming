package ExceptionsHandling;

public class PartyNotFound extends Exception {
	private static final long serialVersionUID = 1L;

	public PartyNotFound(String message) {
        super(message);
    }
}
