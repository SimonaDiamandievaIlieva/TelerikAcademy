package exceptions;

public class InvalidNameLengthException extends InvalidUserInputException{
    public InvalidNameLengthException(String type, int start, int end) {
        super(String.format("%s should be between %d and %d symbols.", type, start, end));
    }
}
