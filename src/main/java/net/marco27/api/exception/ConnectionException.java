package net.marco27.api.exception;

/** Exception for Http Connection errors */
public class ConnectionException extends RuntimeException {

    public ConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
