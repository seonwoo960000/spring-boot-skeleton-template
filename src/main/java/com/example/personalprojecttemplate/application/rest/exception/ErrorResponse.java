package com.example.personalprojecttemplate.application.rest.exception;

import lombok.Data;

@Data
public class ErrorResponse<T> {
    private int code;
    private String message;
    private T error;

    public static ErrorResponse build() {
        return new ErrorResponse();
    }

    public ErrorResponse withCode(int code) {
        this.code = code;
        return this;
    }

    public ErrorResponse withMessage(String message) {
        this.message = message;
        return this;
    }

    public ErrorResponse withError(T error) {
        this.error = error;
        return this;
    }
}