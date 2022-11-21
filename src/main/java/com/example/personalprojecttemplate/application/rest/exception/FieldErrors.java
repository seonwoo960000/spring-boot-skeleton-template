package com.example.personalprojecttemplate.application.rest.exception;

import java.util.ArrayList;
import java.util.List;

public class FieldErrors {
    private List<FieldError> fieldErrors;

    public FieldErrors() {
        this.fieldErrors = new ArrayList<>();
    }

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }

    public void addConstraintViolationData(FieldError fieldError) {
        fieldErrors.add(fieldError);
    }

    public static class FieldErrorsBuilder {

        private List<FieldError> fieldErrors;

        public FieldErrorsBuilder(List<FieldError> fieldErrors) {
            this.fieldErrors = fieldErrors;
        }

        public FieldErrors build() {

            FieldErrors innerFieldErrors = new FieldErrors();

            for (FieldError fieldError : fieldErrors) {
                innerFieldErrors.addConstraintViolationData(fieldError);
            }

            return innerFieldErrors;
        }

    }
}