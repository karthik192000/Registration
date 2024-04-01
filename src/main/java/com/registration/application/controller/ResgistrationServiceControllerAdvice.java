package com.registration.application.controller;

import com.registration.application.beans.ResponseBean;
import com.registration.application.util.RegistrationServiceException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResgistrationServiceControllerAdvice extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = {RegistrationServiceException.class})
    protected ResponseEntity<?> handleConflict(RuntimeException ex, WebRequest request){
        RegistrationServiceException registrationServiceException = (RegistrationServiceException) ex;
       Integer statusCode =  registrationServiceException.getCode().value();
        return handleExceptionInternal(ex,new ResponseBean(null,registrationServiceException.getErrorMessage(),statusCode),new HttpHeaders(),registrationServiceException.getCode(),request);
    }
}
