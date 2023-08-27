package exceptions;

import utils.EVotingAppException;

public class InvalidEmailFormatException extends EVotingAppException {
    public InvalidEmailFormatException(String message) {
        super(message);
    }
}
