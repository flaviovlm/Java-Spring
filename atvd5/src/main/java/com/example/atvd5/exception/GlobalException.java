package com.example.atvd5.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler (EmailCadastradoException.class)
    public ResponseEntity <Map<String, Object>> handlerEmailException (EmailCadastradoException erro){

        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("mensagem", erro.getMessage(), "sucess: ", false));
    }

    @ExceptionHandler (RuntimeException.class)
    public ResponseEntity <Map<String, Object>> handlerRunTime (RuntimeException erro){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("mensagem", erro.getMessage(), "sucess: ", false));
    }

    @ExceptionHandler (IllegalArgumentException.class)
    public ResponseEntity <Map<String, Object>> handlerIllegalArgumentException (IllegalArgumentException erro){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("mensagem", erro.getMessage(), "sucess: ", false));
    }

    
}
