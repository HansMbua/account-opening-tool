package com.love2code.accountopeningtool.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Global exception Handler
// here we can handle any type of exception
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomerErrorRespond> handleException(CustomerNotFoundException exception) {
        return handleError(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomerErrorRespond> handleException(CustomerExistException exception) {
        return handleError(exception, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<CustomerErrorRespond> handleException(InitialCreditError exception) {
        return handleError(exception, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<CustomerErrorRespond> handleError(Exception exception, HttpStatus status) {
        // create a customer respond error
        CustomerErrorRespond error = new CustomerErrorRespond();
        error.setStatus(Integer.parseInt(String.valueOf(status.value())));
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, status);
    }
}
