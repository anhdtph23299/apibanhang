package com.example.asm.jwtsecurity.services.auth;


import com.example.asm.jwtsecurity.dto.SignupDTO;
import com.example.asm.jwtsecurity.dto.UserDTO;

public interface AuthService {
    UserDTO createUser(SignupDTO signupDTO);
}
