package com.example.atvd6.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler (RuntimeException.class)
    public ResponseEntity <Map<String, Object>> runTimeException (RuntimeException erro) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("mensagem", erro.getMessage(), "success", false));

    }
    @ExceptionHandler (EmailException.class)
    public ResponseEntity <Map<String, Object>> emailException (EmailException erro) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("mensagem", erro.getMessage(), "success", false));

    }
    
}
