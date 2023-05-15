package com.project.marimay.controllers;

//import com.project.marimay.repository.UserRepository;
import com.project.marimay.dto.response.AccountResponse;
import com.project.marimay.dto.response.WeddingDetailsResponse;
import com.project.marimay.repository.UserRepository;
import com.project.marimay.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
public class AccountController {

    UserService userService;
    @GetMapping("/account")
    public ResponseEntity<?> getAccountInfo(
            @RequestHeader("Authorization") String token
    ){
        AccountResponse accountResponse = userService.getAccount(token);
        return ResponseEntity.ok(accountResponse);
    }

    @PutMapping("/account/date")
    public ResponseEntity<?> changeWeddingDate(
            @RequestHeader("Authorization") String token,
            @RequestBody LocalDate date
    ){
        userService.changeWeddingDate(token, date);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/account/budget")
    public ResponseEntity<?> changeWeddingBudget(
            @RequestHeader("Authorization") String token,
            @RequestBody Double budget
    ){
        userService.changeBudget(token, budget);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/overview")
    public ResponseEntity<?> getOverview(
            @RequestHeader("Authorization") String token
    ){
        WeddingDetailsResponse wd = userService.getOverview(token);
        return ResponseEntity.ok(wd);
    }
}
