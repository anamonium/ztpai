package com.project.marimay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/budget")
public class BudgetController {

    @GetMapping()
    public String budget(){
        return "budget";
    }

    @PostMapping()
    public void addNewBudgetItem(){

    }

    @DeleteMapping("/{id_item}")
    public void deleteBudgetItem(@PathVariable String id_item){

    }

   @PutMapping("/{id_item}")
    public void changeBudgetItem(@PathVariable String id_item){

   }
}
