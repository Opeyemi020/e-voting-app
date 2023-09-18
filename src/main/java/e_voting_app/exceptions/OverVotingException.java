package e_voting_app.exceptions;

import e_voting_app.utils.EVotingAppException;

public class OverVotingException extends EVotingAppException {
    public OverVotingException(String message) {
        super(message);
    }
}
