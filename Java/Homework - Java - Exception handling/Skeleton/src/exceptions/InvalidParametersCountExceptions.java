package exceptions;

public class InvalidParametersCountExceptions extends InvalidUserInputException{

    public InvalidParametersCountExceptions(String type, int count) {
        super(String.format("%s command expects %d %s.", type, count, count == 1 ? "parameter" : "parameters"));
    }
}
