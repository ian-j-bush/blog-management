package com.ianjbush.blogmanagement.auth;

import com.ianjbush.blogmanagement.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Account> login(@RequestBody LoginDTO dto) {
        authService.login(dto);
        //TODO: Complete Method
        return ResponseEntity.ok(null);
    }

//    @PostMapping
//    public ResponseEntity<Account> logout(@RequestBody Account account){
//        //TODO: Fillout method
//        return ResponseEntity.ok(account);
//    }

    @PostMapping("/register")
    public ResponseEntity<Account> register(@RequestBody RegistrationDTO dto) {
        Account account = authService.register(dto);

        return ResponseEntity.ok(account);
    }
}
