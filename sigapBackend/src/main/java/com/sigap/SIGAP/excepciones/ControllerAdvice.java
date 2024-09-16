package com.sigap.SIGAP.excepciones;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = GlobalExcepcion.class)
    public ResponseEntity<String> exception(GlobalExcepcion e) {
        return new ResponseEntity<>(e.getMensaje(), e.getHttpStatus());
    }
}
