package com.project.marimay.controllers;

import com.project.marimay.models.Guests;
import com.project.marimay.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/guestlist")
public class GuestListController {
    
    private GuestRepository guestRepository;

    @Autowired
    public void setGuestRepository(GuestRepository guestRepository){
        this.guestRepository = guestRepository;
    }
    @GetMapping
    public ResponseEntity<List<Guests>> guestList(){
        try{

            String id = "10";
            List<Guests> guests = guestRepository.findGuestsByIdGuestlistEquals(id);

            return new ResponseEntity<>(guests, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public void addGuestListItem(){

    }

    @PutMapping("/{item_id}")
    public void changeStatus(@PathVariable String item_id){

    }

    @DeleteMapping("/{item_id}")
    public void deleteGuest(@PathVariable String item_id){

    }
}
