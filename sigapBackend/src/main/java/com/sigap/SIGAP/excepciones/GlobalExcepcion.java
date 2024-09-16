package com.sigap.SIGAP.excepciones;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public class GlobalExcepcion extends RuntimeException {

    private final String mensaje;
    private final HttpStatus httpStatus;
}
