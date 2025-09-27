package com.example.Post_api.controller;

import com.example.Post_api.models.AuthLoginRequestDTO;
import com.example.Post_api.models.AuthResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.Post_api.service.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticatonController {
    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthLoginRequestDTO user){
        AuthResponseDTO response = userDetailsService.loginUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
