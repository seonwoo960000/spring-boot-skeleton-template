package com.example.personalprojecttemplate.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.example.personalprojecttemplate.application.request.AccountRequest;
import com.example.personalprojecttemplate.application.response.AccountResponse;
import com.example.personalprojecttemplate.domain.account.AccountDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountRequestResponseMapper {

    AccountDto fromAccountRequest(AccountRequest accountRequest);

    AccountResponse toAccountResponse(AccountDto accountDto);
}
