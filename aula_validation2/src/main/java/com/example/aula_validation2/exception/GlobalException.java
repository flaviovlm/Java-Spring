package com.example.aula_validation2.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalException {

  @ExceptionHandler (EmailException.class)
  public ResponseEntity <Map<String, Object>> emailException (EmailException erro){
    return ResponseEntity.badRequest()
            .body(Map.of("message: ", erro.getMessage(), "success", false));

  }
  @ExceptionHandler (MethodArgumentNotValidException.class)
  public ResponseEntity <Map<String, Object>> methodNotValidException (MethodArgumentNotValidException erro){
    return ResponseEntity.badRequest()
            .body(Map.of("message: ", erro.getFieldErrors().get(0).getDefaultMessage()
                    , "success", false));

  }
  @ExceptionHandler (RuntimeException.class)
  public ResponseEntity <Map<String, Object>> runException (RuntimeException erro){
    return ResponseEntity.badRequest()
            .body(Map.of("message: ", erro.getMessage()
                    , "success", false));

  }

}
