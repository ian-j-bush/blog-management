package com.ianjbush.blogmanagement.auth;

import com.ianjbush.blogmanagement.account.Account;
import com.ianjbush.blogmanagement.account.AccountRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class AuthService implements UserDetailsService {

    private final AccountRepository accountRepository;

    public AuthService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findAccountByUsername(username);
        if( account == null) {
            throw new UsernameNotFoundException(username);
        }

        return null;
    }

    @Transactional
    public Account createNewUser(RegistrationDTO registrationDTO) {
        if ( accountRepository.findAccountByEmail(registrationDTO.getEmail()) != null) {
            throw new IllegalStateException("Email already exists!");
        }

        Account newAccount = new Account();
        newAccount.setUsername(registrationDTO.getUsername());
        newAccount.setPassword(registrationDTO.getPassword());
        newAccount.setEmail(registrationDTO.getEmail());
        newAccount.setRole("USER");

        return accountRepository.save(newAccount);
    }

    static final class AccountDetails extends Account implements UserDetails {

        private static final List<GrantedAuthority> ROLE_USER = Collections.unmodifiableList(AuthorityUtils.createAuthorityList("ROLE_USER"));

        //AccountDetails(Account account) {
        //    super(account.getId(), account.getEmail(), account.getPassword());
        //}

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return ROLE_USER;
        }

        @Override
        public boolean isAccountNonExpired() {
            return UserDetails.super.isAccountNonExpired();
        }

        @Override
        public boolean isAccountNonLocked() {
            return UserDetails.super.isAccountNonLocked();
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return UserDetails.super.isCredentialsNonExpired();
        }

        @Override
        public boolean isEnabled() {
            return UserDetails.super.isEnabled();
        }
    }
}
