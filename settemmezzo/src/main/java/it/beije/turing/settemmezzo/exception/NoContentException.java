package it.beije.turing.settemmezzo.exception;

public class NoContentException extends SettemmezzoException {
	private static final long serialVersionUID = -442435550476872951L;

	public NoContentException() {
        super("No content");
    }
	public NoContentException(String message) {
        super(message);
    }
}
