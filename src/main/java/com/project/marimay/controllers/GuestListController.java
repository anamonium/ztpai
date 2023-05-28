package com.project.marimay.controllers;

import com.project.marimay.dto.request.AddGuestRequest;
import com.project.marimay.models.Guests;
import com.project.marimay.repository.GuestRepository;
import com.project.marimay.service.GuestlistService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/guestlist")
@CrossOrigin(origins = "http://localhost:3000")
public class GuestListController {
    
    private GuestlistService guestlistService;

    @GetMapping
    public ResponseEntity<List<Guests>> guestList(
            @RequestHeader("Authorization") String token
    ){
        try{

            List<Guests> guests = guestlistService.getGuestList(token);

            return new ResponseEntity<>(guests, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/summary")
    public ResponseEntity<?> getSummary(
            @RequestHeader("Authorization") String token
    ){
        return ResponseEntity.ok(guestlistService.getSummary(token));
    }

    @PostMapping
    public ResponseEntity<?> addGuestListItem(
            @RequestHeader("Authorization") String token,
            @RequestBody AddGuestRequest request
    ){
        UUID id = guestlistService.addGuest(token, request);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/st/{item_id}")
    public ResponseEntity<?> changeStatus(
            @PathVariable UUID item_id
    ){
        guestlistService.changeStatus(item_id);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/po/{item_id}")
    public ResponseEntity<?> changePlusOne(
            @PathVariable UUID item_id
    ){
        guestlistService.changePlusOne(item_id);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{item_id}")
    public ResponseEntity<?> deleteGuest(
            @PathVariable UUID item_id
    ){
        guestlistService.deleteGuest(item_id);
        return ResponseEntity.ok(null);
    }
}
