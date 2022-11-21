package com.example.personalprojecttemplate.domain.account;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.personalprojecttemplate.domain.common.exception.CommonExceptions;
import com.example.personalprojecttemplate.domain.common.exception.DomainErrors;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountDtoMapper mapper;

    @Transactional(readOnly = true)
    public AccountDto findById(Long id) {
        return mapper.toAccountDto(accountRepository.findById(id)
                                                    .orElseThrow(() -> new CommonExceptions(DomainErrors.NOT_FOUND)));
    }

    @Transactional(readOnly = true)
    public AccountDto findByIdWithStories(Long id) {
        return mapper.toAccountDto(accountRepository.findByAccountIdWithStory(id));
    }

    @Transactional
    public AccountDto insert(AccountDto accountDto) {
        return mapper.toAccountDto(accountRepository.save(mapper.fromAccountDto(accountDto)));
    }

    @Transactional
    public AccountDto update(Long id, AccountDto accountDto) {
        Account account = mapper.fromAccountDto(accountDto);
        account.setId(id);
        return mapper.toAccountDto(accountRepository.save(account));
    }

    @Transactional
    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }
}
