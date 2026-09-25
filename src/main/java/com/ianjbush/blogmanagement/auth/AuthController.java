package com.ianjbush.blogmanagement.auth;

import com.ianjbush.blogmanagement.account.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<Account> login(@RequestBody Account account){
        //TODO: Complete Method
        return ResponseEntity.ok(account);
    }

    @PostMapping
    public ResponseEntity<Account> logout(@RequestBody Account account){
        //TODO: Fillout method
        return ResponseEntity.ok(account);
    }

    @PostMapping("/register")
    public ResponseEntity<Account> register(@RequestBody Account account) {
        //TODO: Complete method and create DTOs

        return ResponseEntity.ok(account);
    }
}
