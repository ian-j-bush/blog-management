package com.ianjbush.blogmanagement.account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    public Account findAccountByUsername(String username);

    public Account findAccountByEmail(String email);
}
