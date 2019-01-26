package br.com.cabal.squardsippe.controller.exception;

import br.com.cabal.squardsippe.exception.ObjectAlreadyExistException;
import br.com.cabal.squardsippe.exception.ObjectNotFoundException;
import br.com.cabal.squardsippe.exception.SaldoIndisponivelException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> handlerPessoaNotFoundException(ObjectNotFoundException e, HttpServletRequest request) {
        e.printStackTrace();

        StandardError error = new StandardError();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTitle("Object not found");
        error.setMessage(e.getMessage());
        error.setUrl("http://error.teste.com/404");
        error.setTimestamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }

    @ExceptionHandler(ObjectAlreadyExistException.class)
    public ResponseEntity<StandardError> handlerPessoaAlreadyExistException(ObjectAlreadyExistException e, HttpServletRequest request) {
        e.printStackTrace();

        StandardError error = new StandardError();
        error.setStatus(HttpStatus.CONFLICT.value());
        error.setTitle("Object already exist");
        error.setMessage(e.getMessage());
        error.setUrl("http://error.teste.com/409");
        error.setTimestamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);

    }

    @ExceptionHandler(SaldoIndisponivelException.class)
    public ResponseEntity<StandardError> handlerSaldoIndisponivelException(SaldoIndisponivelException e, HttpServletRequest request) {
        e.printStackTrace();

        StandardError error = new StandardError();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTitle("Saldo indisponivel");
        error.setMessage(e.getMessage());
        error.setUrl("http://error.teste.com/400");
        error.setTimestamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

    }
}
