package exceptions;

import utils.EVotingAppException;

public class VoterAlreadyExistException extends EVotingAppException {
    public VoterAlreadyExistException(String message) {
        super(message);
    }
}
