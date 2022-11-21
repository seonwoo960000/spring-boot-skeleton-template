package com.example.personalprojecttemplate.application.rest.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.example.personalprojecttemplate.application.rest.exception.FieldErrors.FieldErrorsBuilder;
import com.example.personalprojecttemplate.domain.common.exception.CommonError;
import com.example.personalprojecttemplate.domain.common.exception.CommonExceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(CommonExceptions.class)
    protected ResponseEntity<ErrorResponse> handleCommonException(CommonExceptions commonExceptions) {
        return Objects.isNull(commonExceptions.getDetailedErrorMessage()) ?
                createResponseEntity(commonExceptions.getCommonError()) :
                createResponseEntity(commonExceptions.getCommonError(), commonExceptions.getDetailedErrorMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    protected ResponseEntity<ErrorResponse> handleNoHandlerFound(NoHandlerFoundException ex) {
        return createResponseEntity(ApiErrors.NOT_FOUND_API);
    }

    @ExceptionHandler(value = { ConstraintViolationException.class })
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected ResponseEntity<ErrorResponse> handleResourceNotFoundException(ConstraintViolationException e) {
        List<FieldError> fieldErrorList = new ArrayList<>();
        e.getConstraintViolations().forEach(constraintViolation -> {
            String queryParamPath = constraintViolation.getPropertyPath().toString();
            String errorMessage = constraintViolation.getMessage();
            fieldErrorList.add(FieldError.builder().fieldName(queryParamPath)
                    .errorMessage(errorMessage).build());
        });
        log.warn("Invalid Parameters: {}", fieldErrorList, e);
        return createResponseEntity(ApiErrors.BAD_PARAMETER, fieldErrorList);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleValidationError(MethodArgumentNotValidException ex) {
        final List<FieldError> fieldErrorList = ex.getBindingResult().getFieldErrors().stream().map(
                t -> FieldError.builder().fieldName(t.getField())
                        .errorMessage(t.getDefaultMessage()).build()
        ).collect(Collectors.toList());
        return createResponseEntity(ApiErrors.BAD_PARAMETER, fieldErrorList);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        ResponseEntity<ErrorResponse> responseEntity = createResponseEntity(ex);
        log.error("Exception: {}", responseEntity, ex);
        return responseEntity;
    }

    private ResponseEntity<ErrorResponse> createResponseEntity(Exception ex) {
        final ResponseEntity<ErrorResponse> entity = new ResponseEntity(new ErrorResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(createProblem(ex), entity.getHeaders(), entity.getStatusCode());
    }

    private ResponseEntity<ErrorResponse> createResponseEntity(CommonError commonError) {
        final ErrorResponse problem = createProblem(commonError);
        final ResponseEntity<ErrorResponse> entity = new ResponseEntity(commonError.getHttpStatus());
        return new ResponseEntity<>(problem, entity.getHeaders(), entity.getStatusCode());
    }

    private ResponseEntity<ErrorResponse> createResponseEntity(CommonError commonError, String detailedErrorMessage) {
        final ErrorResponse problem = createProblem(commonError, detailedErrorMessage);
        final ResponseEntity<ErrorResponse> entity = new ResponseEntity(commonError.getHttpStatus());
        return new ResponseEntity<>(problem, entity.getHeaders(), entity.getStatusCode());
    }

    private ResponseEntity<ErrorResponse> createResponseEntity(CommonError commonError, List<FieldError> fieldErrorList) {
        final ResponseEntity<ErrorResponse> entity = new ResponseEntity(commonError.getHttpStatus());
        return new ResponseEntity<>(createProblem(commonError, fieldErrorList), entity.getHeaders(), entity.getStatusCode());
    }

    private ErrorResponse createProblem(CommonError commonError) {
        return ErrorResponse.build()
                .withCode(commonError.getHttpStatus().value())
                .withError(commonError.getHttpStatus().getReasonPhrase())
                .withMessage(commonError.getErrorMessage());
    }

    private ErrorResponse createProblem(CommonError commonError, String detailedErrorMessage) {
        return ErrorResponse.build()
                .withCode(commonError.getHttpStatus().value())
                .withError(commonError.getHttpStatus().getReasonPhrase())
                .withMessage(detailedErrorMessage);
    }

    private ErrorResponse createProblem(CommonError commonError, List<FieldError> fieldErrorList) {
        return ErrorResponse.build()
                .withCode(commonError.getHttpStatus().value())
                .withError(new FieldErrorsBuilder(fieldErrorList).build())
                .withMessage(commonError.getErrorMessage());
    }

    private ErrorResponse createProblem(Exception ex) {
        return ErrorResponse.build()
                .withCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .withError(ex.getClass().getSimpleName())
                .withMessage(HttpStatus.INTERNAL_SERVER_ERROR.toString());
    }

}