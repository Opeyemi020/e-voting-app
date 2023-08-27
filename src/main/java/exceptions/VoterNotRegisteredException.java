package exceptions;

import utils.EVotingAppException;

public class VoterNotRegisteredException extends EVotingAppException {
    public VoterNotRegisteredException(String message) {
        super(message);
    }
}
