package com.example.personalprojecttemplate.application.rest;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.personalprojecttemplate.application.mapper.AccountRequestResponseMapper;
import com.example.personalprojecttemplate.application.request.AccountRequest;
import com.example.personalprojecttemplate.application.request.AccountRequest.CROSS_FIELD_VALIDATION;
import com.example.personalprojecttemplate.application.request.AccountRequest.SINGLE_FIELD_VALIDATION;
import com.example.personalprojecttemplate.application.response.AccountResponse;
import com.example.personalprojecttemplate.domain.account.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final SpringValidatorAdapter validator;
    private final AccountRequestResponseMapper mapper;
    private final AccountService accountService;


    @GetMapping("/{id}")
    public AccountResponse findById(@PathVariable Long id) {
        return mapper.toAccountResponse(accountService.findById(id));
    }

    @GetMapping("/stories/{id}")
    public AccountResponse findByIdWithStories(@PathVariable Long id) {
        return mapper.toAccountResponse(accountService.findByIdWithStories(id));
    }

    @PostMapping
    public AccountResponse save(@RequestBody AccountRequest request) {
        validateAccountRequest(request);
        return mapper.toAccountResponse(accountService.insert(mapper.fromAccountRequest(request)));
    }

    @PutMapping("/{id}")
    public AccountResponse update(@RequestBody AccountRequest request, @PathVariable Long id) {
        validateAccountRequest(request);
        return mapper.toAccountResponse(accountService.update(id, mapper.fromAccountRequest(request)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        accountService.deleteById(id);
    }

    private void validateAccountRequest(AccountRequest accountRequest) {
        Set<ConstraintViolation<AccountRequest>> phase1Violation = validator.validate(accountRequest, SINGLE_FIELD_VALIDATION.class);
        if (!phase1Violation.isEmpty()) {throw new ConstraintViolationException(phase1Violation);}

        Set<ConstraintViolation<AccountRequest>> phase2Violation = validator.validate(accountRequest, CROSS_FIELD_VALIDATION.class);
        if (!phase2Violation.isEmpty()) {throw new ConstraintViolationException(phase2Violation);}
    }
}
