package it.beije.turing.settemmezzo.login.security;

public class InvalidJwtAuthenticationException extends RuntimeException {
	private static final long serialVersionUID = -2017181737681154130L;

	public static final int FORBIDDEN = 403;
	public static final int EXPIRED = 401;
	
	
	private final int code;

	public InvalidJwtAuthenticationException(String message, int code) {
		super(message);
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}

}
