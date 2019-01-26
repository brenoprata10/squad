package br.com.cabal.squardsippe.exception;

public class ObjectAlreadyExistException extends RuntimeException {

    public ObjectAlreadyExistException() {
    }

    public ObjectAlreadyExistException(String message) {
        super(message);
    }

    public ObjectAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}