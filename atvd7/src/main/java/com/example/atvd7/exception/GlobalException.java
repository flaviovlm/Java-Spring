package com.example.atvd7.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler (RuntimeException.class)
    public ResponseEntity <Map<String, Object>> runTimeException (RuntimeException erro){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of ("message: ", erro.getMessage(), "succes", false));
    }

    @ExceptionHandler (IllegalArgumentException.class)
    public ResponseEntity <Map<String, Object>> illegalException (IllegalArgumentException erro){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("message: ", erro.getMessage(), "success", false));
    }

    @ExceptionHandler (EmailException.class)
    public ResponseEntity <Map<String, Object>> emailException (EmailException erro){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("message: ", erro.getMessage(), "success", false));
    }

    @ExceptionHandler (MatriculaException.class)
    public ResponseEntity <Map<String, Object>> matriculaException (MatriculaException erro){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("message: ", erro.getMessage(), "success", false));
    }
}
