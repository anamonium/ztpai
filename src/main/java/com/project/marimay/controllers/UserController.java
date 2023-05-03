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

    @GetMapping("/random")
    public String random(){
        Users users = Users.builder()
                .email("em.com")
                .password("pass")
                .role(Role.USER)
                .build();

        userService.savUs(users);
        Users u2 = userService.getByEm("em.com");
        return u2.getUsername() + " "+ u2.getPassword() + " " + u2.getRole().name();
    }
}
