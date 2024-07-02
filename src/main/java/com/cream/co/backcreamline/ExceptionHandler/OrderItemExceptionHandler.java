package com.cream.co.backcreamline.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cream.co.backcreamline.NotFoundException.OrderItemNotFoundException;

@RestControllerAdvice
public class OrderItemExceptionHandler {

    @ExceptionHandler(OrderItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String OrderItemNotFoundException(OrderItemNotFoundException e) {
        return e.getMessage();
    }

}
