package exceptions;

import utils.EVotingAppException;

public class IncorrectPasswordException extends EVotingAppException {
    public IncorrectPasswordException(String message){
        super(message);
    }
}
