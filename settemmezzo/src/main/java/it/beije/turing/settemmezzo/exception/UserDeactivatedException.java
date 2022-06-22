package it.beije.turing.settemmezzo.exception;

public class UserDeactivatedException extends SettemmezzoException {

    private final static long serialVersionUID = -8877136253891996152L;

    public UserDeactivatedException(String message) {
        super(message);
    }
}
