package com.ianjbush.blogmanagement.auth;

import lombok.Data;

@Data
public class RegistrationDTO {

    private String username;
    private String email;
    private String password;
}
