package com.project.marimay.controllers;

import com.project.marimay.dto.request.AuthenticationRequest;
import com.project.marimay.dto.request.RegisterRequest;
import com.project.marimay.dto.response.AuthenticationResponse;
import com.project.marimay.models.Role;
import com.project.marimay.models.Users;
import com.project.marimay.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> logIn(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(userService.login(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthenticationResponse> signIn(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(userService.register(request));
    }
}
