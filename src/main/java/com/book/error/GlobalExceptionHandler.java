package com.book.error;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> hadleRecordNotFound(RecordNotFoundException ex) {

        ErrorResponse errorResponse = new ErrorResponse(ex.getLocalizedMessage(), Arrays.asList(ex.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(DuplicateRecordException.class)
    public ResponseEntity<?> handleDuplicateRecordException(DuplicateRecordException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getLocalizedMessage(), Arrays.asList(ex.getMessage()));
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(errorResponse);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        for (FieldError error: ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getDefaultMessage());
        }
        for (ObjectError error: ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getDefaultMessage());
        }
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest webRequest) {
        List<String> details = new ArrayList<>();
        details.add(e.getLocalizedMessage());

        ErrorResponse errorResponse = new ErrorResponse(e.toString(), details);
        return ResponseEntity.status(HttpStatus.NOT_EXTENDED)
                .body(errorResponse);

    }
}
