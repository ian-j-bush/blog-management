package com.ianjbush.blogmanagement.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(AccountController.class)
@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    AccountService accountService;

    @BeforeEach
    void setUp() {

    }
}
