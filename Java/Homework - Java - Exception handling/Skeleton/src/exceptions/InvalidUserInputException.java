package exceptions;

public abstract class InvalidUserInputException extends RuntimeException {
    protected InvalidUserInputException(String message) {
        super(message);
    }
}
