package com.registration.application.beans;

import java.io.Serializable;

public class ResponseBean implements Serializable {


    private Object payload;


    private String errorMessage;

    private Integer httpStatusCode;

    public ResponseBean() {
        //Empty Constructor
    }

    public ResponseBean(Object payload, String errorMessage, Integer httpStatusCode) {
        this.payload = payload;
        this.errorMessage = errorMessage;
        this.httpStatusCode = httpStatusCode;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }
}
