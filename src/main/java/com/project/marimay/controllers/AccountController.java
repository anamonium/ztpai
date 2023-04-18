package com.project.marimay.controllers;

import com.project.marimay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Controller
public class AccountController {

    UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @GetMapping("/account")
    public ResponseEntity<Object[]> login(){

        return null;
    }

    @PutMapping
    public void changeUserData(){

    }
}
