package com.ianjbush.blogmanagement.account;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getAccountById(Long id){
        return accountRepository.findById(id).orElseThrow();
    }
}
