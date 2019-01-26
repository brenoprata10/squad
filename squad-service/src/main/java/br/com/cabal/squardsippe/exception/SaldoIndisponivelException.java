package br.com.cabal.squardsippe.exception;

public class SaldoIndisponivelException extends RuntimeException {

    public SaldoIndisponivelException() {
    }

    public SaldoIndisponivelException(String message) {
        super(message);
    }

    public SaldoIndisponivelException(String message, Throwable cause) {
        super(message, cause);
    }
}