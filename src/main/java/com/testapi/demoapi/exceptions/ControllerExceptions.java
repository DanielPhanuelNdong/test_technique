package com.testapi.demoapi.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptions {

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<ApiError> HandleElementNotFoundExceptions(ElementNotFoundException e) {
        ApiError apiError = new ApiError();
        apiError.setMessage(e.getMessage());
        apiError.setCode(HttpStatus.NOT_FOUND.value());
        apiError.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> HandleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ApiError apiError = new ApiError();
        Map<String, String> errors = new HashMap<>();

        e.getBindingResult().getFieldErrors()
                        .forEach(error -> {
                            errors.put(error.getField(),
                            error.getDefaultMessage());
                        });

        apiError.setMessage("Validation error");
        apiError.setCode(HttpStatus.BAD_REQUEST.value());
        apiError.setDateTime(LocalDateTime.now());
        apiError.setErrors(errors);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiError> HandleDataIntegrityViolationException(DataIntegrityViolationException e) {
        ApiError apiError = new ApiError();
        apiError.setMessage("An element with un unique value already exists");
        apiError.setCode(HttpStatus.CONFLICT.value());
        apiError.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> HandleExceptions(Exception e) {
        ApiError apiError = new ApiError();
        apiError.setMessage(e.getMessage());
        apiError.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        apiError.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
