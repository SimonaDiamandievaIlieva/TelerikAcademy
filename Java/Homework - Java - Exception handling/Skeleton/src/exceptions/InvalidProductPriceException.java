package exceptions;

public class InvalidProductPriceException extends InvalidUserInputException{
    public InvalidProductPriceException() {
        super("Price can't be negative.");
    }
}
