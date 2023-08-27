package exceptions;

import utils.EVotingAppException;

public class OverVotingException extends EVotingAppException {
    public OverVotingException(String message) {
        super(message);
    }
}
