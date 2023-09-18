package e_voting_app.exceptions;

import e_voting_app.utils.EVotingAppException;

public class PartyDoesNotExistException extends EVotingAppException {
    public PartyDoesNotExistException(String message) {
        super(message);
    }
}
