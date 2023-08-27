package exceptions;

import utils.EVotingAppException;

public class RequestHasNullFieldException extends EVotingAppException {
    public RequestHasNullFieldException(String message) {
        super(message);
    }
}
