package com.example.personalprojecttemplate.domain.account;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountDtoMapper {
    @Mapping(target = "createdBy", defaultValue = "SYSTEM")
    @Mapping(target = "modifiedBy", defaultValue = "SYSTEM")
    Account fromAccountDto(AccountDto accountDto);

    AccountDto toAccountDto(Account account);
}
