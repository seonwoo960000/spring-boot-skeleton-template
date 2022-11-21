package com.example.personalprojecttemplate.application.request.validator;

import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.personalprojecttemplate.application.request.AccountRequest;
import com.example.personalprojecttemplate.application.request.constraint.NameConstraint;

public class NameValidator implements ConstraintValidator<NameConstraint, AccountRequest> {
    @Override public void initialize(NameConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override public boolean isValid(AccountRequest request, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = this.isValid(request);
        if (!isValid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(constraintValidatorContext.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("name").addConstraintViolation();
        }

        return isValid;
    }

    private boolean isValid(AccountRequest accountRequest) {
        return true;
    }
}
