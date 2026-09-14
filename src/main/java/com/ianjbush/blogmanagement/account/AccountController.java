package com.ianjbush.blogmanagement.account;

import org.springframework.web.bind.annotation.RestController;

@RestController("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
}
