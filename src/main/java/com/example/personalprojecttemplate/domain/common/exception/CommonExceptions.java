package com.example.personalprojecttemplate.domain.common.exception;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class CommonExceptions extends RuntimeException {
    private final CommonError commonError;
    private String detailedErrorMessage;

    public CommonExceptions(CommonError commonError) {
        this.commonError = commonError;
    }

    public CommonExceptions(CommonError commonError, String detailedErrorMessage) {
        super(commonError.getErrorMessage());
        this.commonError = commonError;
        this.detailedErrorMessage = detailedErrorMessage;
    }
}