package e_voting_app.exceptions;

import e_voting_app.utils.EVotingAppException;

public class IncorrectPasswordException extends EVotingAppException {
    public IncorrectPasswordException(String message){
        super(message);
    }
}
