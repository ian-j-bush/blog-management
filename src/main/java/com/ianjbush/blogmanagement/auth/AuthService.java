package com.ianjbush.blogmanagement.auth;

import com.ianjbush.blogmanagement.account.Account;
import com.ianjbush.blogmanagement.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException(username);
        }

        return account;
    }

    public void login( LoginDTO dto) {
        // TODO: Method Stub
    }

    public Account register(@RequestBody RegistrationDTO dto) {
        Account account = new Account();

        if (accountRepository.findByUsername(dto.username()) != null ) {
            throw new IllegalArgumentException("Username already exists!");
        } else if (accountRepository.findByEmail(dto.email()) != null) {
            throw new IllegalArgumentException("This email is already in use");
        }

        account.setUsername(dto.username());
        account.setPassword(passwordEncoder.encode(dto.password())); //TODO: encrypt for database storage
        account.setEmail(dto.email());
        account.setFirstName(dto.firstName());
        account.setLastName(dto.lastName());
        account.setRole("USER");
        account.setAccountStatus("ACTIVE");

        return accountRepository.save(account);
    }
}
