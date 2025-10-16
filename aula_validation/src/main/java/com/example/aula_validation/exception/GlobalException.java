package com.example.aula_validation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler (EmailCadastradoException.class)
    public ResponseEntity <Map<String,Object>> exceptionEmail (EmailCadastradoException erro){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("message: ", erro.getMessage(), "succces", false));
    }
    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity <Map<String,Object>> methodArgunmentNotValidException (MethodArgumentNotValidException erro){

        return ResponseEntity.badRequest()
                .body(Map.of("message: ", erro.getFieldErrors()
                        .get(0)
                        .getDefaultMessage(),"success", false));
    }
    @ExceptionHandler (RuntimeException.class)
    public ResponseEntity <Map<String,Object>> runTimeException (RuntimeException erro){

        return ResponseEntity.badRequest()
                .body(Map.of("message: ", erro.getMessage(), "success", false));
    }


}
