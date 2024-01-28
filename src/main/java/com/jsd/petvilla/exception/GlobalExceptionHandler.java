package com.jsd.petvilla.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerIDNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleCustomerIdNotFoundException(CustomerIDNotFoundException ex, WebRequest request) {
        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
    }

    @ExceptionHandler(PaymentRecordsNotFoundException.class)
    public ResponseEntity<ErrorMessage> handlePaymentRecordsNotFoundException(PaymentRecordsNotFoundException ex, WebRequest request) {
        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
    }

    @ExceptionHandler(PetBreedNotFoundException.class)
    public ResponseEntity<ErrorMessage> handlePetBreedNotFoundException(PetBreedNotFoundException ex, WebRequest request) {
        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
    }

    @ExceptionHandler(PetCategoryNotFoundException.class)
    public ResponseEntity<ErrorMessage> handlePetCategoryNotFoundException(PetCategoryNotFoundException ex, WebRequest request) {
        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
    }

    @ExceptionHandler(PetIDNotFoundException.class)
    public ResponseEntity<ErrorMessage> handlePetIDNotFoundException(PetIDNotFoundException ex, WebRequest request) {
        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
    }

    @ExceptionHandler(PetOrderIDNotFoundException.class)
    public ResponseEntity<ErrorMessage> handlePetOrderIDNotFoundException(PetOrderIDNotFoundException ex, WebRequest request) {
        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
    }

    @ExceptionHandler(ProductCategoryNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleProductCategoryNotFoundException(ProductCategoryNotFoundException ex, WebRequest request) {
        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
    }

    @ExceptionHandler(ProductIDNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleProductIDNotFoundException(ProductIDNotFoundException ex, WebRequest request) {
        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
    }

    @ExceptionHandler(ProductNameNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleProductNameNotFoundException(ProductNameNotFoundException ex, WebRequest request) {
        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
    }

    @ExceptionHandler(ProductOrderIDNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleProductOrderIDNotFoundException(ProductOrderIDNotFoundException ex, WebRequest request) {
        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleGenericException(Exception ex, WebRequest request) {
        ErrorMessage em = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(em);
    }
}
