package e_voting_app.exceptions;

import e_voting_app.utils.EVotingAppException;

public class VoterAlreadyExistException extends EVotingAppException {
    public VoterAlreadyExistException(String message) {
        super(message);
    }
}
