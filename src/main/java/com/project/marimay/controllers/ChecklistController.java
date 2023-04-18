package com.project.marimay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/checklist")
public class ChecklistController {

    @GetMapping()
    public String checkList(){
        return "checklist";
    }

    @PostMapping()
    public void addListItem(){

    }

    @PutMapping("/{item_id}")
    public void changeStatus(@PathVariable String item_id){

    }

    @DeleteMapping("/{item_id}")
    public void deleteItem(@PathVariable String item_id){

    }
}
