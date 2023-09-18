package e_voting_app.exceptions;

import e_voting_app.utils.EVotingAppException;

public class InvalidEmailFormatException extends EVotingAppException {
    public InvalidEmailFormatException(String message) {
        super(message);
    }
}
