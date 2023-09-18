package e_voting_app.exceptions;

import e_voting_app.utils.EVotingAppException;

public class RequestHasNullFieldException extends EVotingAppException {
    public RequestHasNullFieldException(String message) {
        super(message);
    }
}
