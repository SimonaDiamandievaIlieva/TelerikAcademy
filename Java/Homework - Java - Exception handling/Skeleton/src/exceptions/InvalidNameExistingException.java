package exceptions;

public class InvalidNameExistingException extends InvalidUserInputException {

    public InvalidNameExistingException(String type, String name) {
        super(String.format("%s %s already exist.", type, name));
    }
}
