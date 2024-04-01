package com.registration.application.util;

import org.springframework.http.HttpStatus;

public class RegistrationServiceException extends  RuntimeException{


    String errorMessage;


    HttpStatus code;

    public RegistrationServiceException(){

        super();
    }


    public RegistrationServiceException(String errorMessage, HttpStatus code){
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.code = code;
    }


    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }
}

