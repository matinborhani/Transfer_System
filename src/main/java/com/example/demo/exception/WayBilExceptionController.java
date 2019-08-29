package com.example.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WayBilExceptionController {
    @ExceptionHandler(value = DuplicateNationalCode.class)
    public void method(DuplicateNationalCode exception) {
        System.out.println("Matin");
        System.out.println("I get Error");
    }
}
