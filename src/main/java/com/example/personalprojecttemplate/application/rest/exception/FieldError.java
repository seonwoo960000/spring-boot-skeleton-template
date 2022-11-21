package com.example.personalprojecttemplate.application.rest.exception;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class FieldError implements Serializable {

    @JsonCreator
    public FieldError(@JsonProperty("fieldName") String fieldName,
                      @JsonProperty("errorMessage") String errorMessage) {
        this.fieldName = fieldName;
        this.errorMessage = errorMessage;
    }

    private final String fieldName;
    private final String errorMessage;
}