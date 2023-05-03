package com.project.marimay.controllers;

import com.project.marimay.dto.request.AddBudgetItemRequest;
import com.project.marimay.dto.request.AddTaskRequest;
import com.project.marimay.models.BudgetItem;
import com.project.marimay.service.BudgetService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/budget")
@AllArgsConstructor
public class BudgetController {

    private BudgetService budgetService;
    @GetMapping()
    public ResponseEntity<List<BudgetItem>> budget(
            @RequestHeader("Authorization") String token
    ){
        List<BudgetItem> budgetItems = budgetService.budgetItems(token);
        return ResponseEntity.ok(budgetItems);
    }

    @PostMapping()
    public ResponseEntity addNewBudgetItem(
            @RequestHeader("Authorization") String token,
            @RequestBody AddBudgetItemRequest request
    ){
        budgetService.addBudgetItem(token, request);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id_item}")
    public ResponseEntity deleteBudgetItem(
            @PathVariable UUID id_item
    ){
        budgetService.deleteBudgetItem(id_item);
        return ResponseEntity.ok(null);
    }

   @PutMapping("/{id_item}")
    public void changeBudgetItem(@PathVariable String id_item){

   }
}
