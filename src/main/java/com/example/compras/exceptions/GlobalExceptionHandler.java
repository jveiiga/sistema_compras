package com.example.compras.exceptions;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.yaml.snakeyaml.constructor.ConstructorException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException ex) {
        List<String> errorMessages = new ArrayList<>();

        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            String attributeName = violation.getPropertyPath().toString();
            String currentErrorMessage = attributeName + ": " + violation.getMessage();
            errorMessages.add(currentErrorMessage);
        }

        ErrorResponse errorResponse = new ErrorResponse(errorMessages);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        String mensagemErro = "Erro de violação de integridade: " + ex.getRootCause().getMessage();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensagemErro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return ResponseEntity.badRequest().body(errors);
    }

    private static class ErrorResponse {
        private List<String> messages;

        public ErrorResponse(List<String> messages) {
            this.messages = messages;
        }

        public List<String> getMessages() {
            return messages;
        }

        public void setMessages(List<String> messages) {
            this.messages = messages;
        }
    }
}
