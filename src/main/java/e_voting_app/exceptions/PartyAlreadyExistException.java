package e_voting_app.exceptions;

import e_voting_app.utils.EVotingAppException;

public class PartyAlreadyExistException extends EVotingAppException {
    public PartyAlreadyExistException(String message) {
        super(message);
    }
}
