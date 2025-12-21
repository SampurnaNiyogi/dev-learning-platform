package com.sampurna.UserManagementAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> handleUserNotFoundException(UserNotFoundException ex) {
        int statusCode = 404;
        Map<String, Object> response = new HashMap<>();
        response.put("status", statusCode);
        response.put("message", ex.getMessage());
        return response;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        int statusCode = 400;
        Map<String, Object> response = new HashMap<>();
        response.put("status", statusCode);
        response.put("message", ex.getMessage());
        return response;
    }

    @ExceptionHandler(value = ProblemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> handleProblemNotFoundException(ProblemNotFoundException ex) {
        int statusCode = 404;
        Map<String, Object> response = new HashMap<>();
        response.put("status", statusCode);
        response.put("message", ex.getMessage());
        return response;
    }
}
