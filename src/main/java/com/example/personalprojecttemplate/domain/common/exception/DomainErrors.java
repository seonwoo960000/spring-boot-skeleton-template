package com.example.personalprojecttemplate.domain.common.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DomainErrors implements CommonError {
    NOT_FOUND(HttpStatus.NOT_FOUND, "Not Found");

    public final HttpStatus httpStatus;
    public final String errorMessage;
}
