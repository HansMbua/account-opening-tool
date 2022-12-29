package com.love2code.accountopeningtool.Controller;

import com.love2code.accountopeningtool.Exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Global exception Handler
// here we can handle any type of exception
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<customerErrorRespond> handleException(CustomerNotFoundException exception) {
        return handleError(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<customerErrorRespond> handleException(CustomerExistException exception) {
        return handleError(exception, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<customerErrorRespond> handleException(initialCreditError exception) {
        return handleError(exception, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<customerErrorRespond> handleError(Exception exception, HttpStatus status) {
        // create a customer respond error
        customerErrorRespond error = new customerErrorRespond();
        error.setStatus(Integer.parseInt(String.valueOf(status.value())));
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, status);
    }
}
