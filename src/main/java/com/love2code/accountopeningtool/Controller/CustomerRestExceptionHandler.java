package com.love2code.accountopeningtool.Controller;

import com.love2code.accountopeningtool.Exception.CustomerNotFoundException;
import com.love2code.accountopeningtool.Exception.customerErrorRespond;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Global exception Handler
// here we can handle any type of exception
@ControllerAdvice
public class CustomerRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<customerErrorRespond> handleException(CustomerNotFoundException exception) {

        // create a customer respond error
        customerErrorRespond error = new customerErrorRespond();
        error.setMessage(String.valueOf(HttpStatus.NOT_FOUND.value()));
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
