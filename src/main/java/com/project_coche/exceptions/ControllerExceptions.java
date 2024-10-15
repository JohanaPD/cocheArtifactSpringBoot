package com.project_coche.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptions {

  /*  @ExceptionHandler(EmailValidationException.class)
    public ResponseEntity<Map<String, String>> emailException(EmailValidationException emailException) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("ERROR", emailException.getMessage()));
    }*/

    @ExceptionHandler({CustomerNotExistException.class, PasswordIncorrectException.class, EmailValidationException.class})
    public ProblemDetail customerNotExist(RuntimeException runtimeException) {
        // return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, runtimeException.getMessage());
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, runtimeException.getMessage());
        Map<String, String> customErrorDetails = new HashMap<>();
        customErrorDetails.put("Prueba", "Define tipo de error");
        problemDetail.setProperty("Error de algo", customErrorDetails);
        return problemDetail;

    }
}
