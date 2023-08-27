package exceptions;

import utils.EVotingAppException;

public class PartyAlreadyExistException extends EVotingAppException {
    public PartyAlreadyExistException(String message) {
        super(message);
    }
}
