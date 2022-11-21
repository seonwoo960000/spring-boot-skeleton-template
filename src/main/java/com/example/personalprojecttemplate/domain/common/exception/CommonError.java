package com.example.personalprojecttemplate.domain.common.exception;

import org.springframework.http.HttpStatus;

public interface CommonError {
    public HttpStatus getHttpStatus();
    public String getErrorMessage();
}