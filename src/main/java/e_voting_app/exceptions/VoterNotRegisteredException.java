package e_voting_app.exceptions;

import e_voting_app.utils.EVotingAppException;

public class VoterNotRegisteredException extends EVotingAppException {
    public VoterNotRegisteredException(String message) {
        super(message);
    }
}
