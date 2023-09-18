package e_voting_app.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalHandlerException {
    @ExceptionHandler
    public ResponseEntity<?> globalExceptionHandler(Exception exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
