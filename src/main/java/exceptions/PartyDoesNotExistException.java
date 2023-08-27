package exceptions;

import utils.EVotingAppException;

public class PartyDoesNotExistException extends EVotingAppException {
    public PartyDoesNotExistException(String message) {
        super(message);
    }
}
