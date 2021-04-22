package net.marco27.api.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ DocumentNotFoundException.class })
    public void handle(DocumentNotFoundException e) {
    }

    @ExceptionHandler({ ConnectionException.class })
    public ResponseEntity<String> handleContributorsApiConnectionException(final ConnectionException e) {
        return error(INTERNAL_SERVER_ERROR, e);
    }

    @ExceptionHandler({ IllegalArgumentException.class })
    public ResponseEntity<String> handleNotFoundException(final IllegalArgumentException e) {
        return error(BAD_REQUEST, e);
    }

    private ResponseEntity<String> error(HttpStatus status, Exception e) {
        log.error("Exception : ", e);
        return ResponseEntity.status(status).body(e.getMessage());
    }
}
