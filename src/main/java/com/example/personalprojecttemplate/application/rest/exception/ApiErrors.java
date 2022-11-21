package com.example.personalprojecttemplate.application.rest.exception;

import org.springframework.http.HttpStatus;

import com.example.personalprojecttemplate.domain.common.exception.CommonError;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiErrors implements CommonError {
    NOT_AUTHORIZED(HttpStatus.UNAUTHORIZED, "Unauthorized"),
    BAD_PARAMETER(HttpStatus.BAD_REQUEST, "Invalid Parameters"),
    NOT_FOUND_API(HttpStatus.NOT_FOUND, "API Not Found"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "Resource Not Found"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");

    public final HttpStatus httpStatus;
    public final String errorMessage;
}