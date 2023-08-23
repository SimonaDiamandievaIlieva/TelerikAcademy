package exceptions;

public class InvalidCommandException extends InvalidUserInputException{
    public InvalidCommandException(String message) {
        super(message);
    }
}
