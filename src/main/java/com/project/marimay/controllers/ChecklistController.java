package com.project.marimay.controllers;

import com.project.marimay.dto.request.AddTaskRequest;
import com.project.marimay.models.Task;
import com.project.marimay.service.ChecklistService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/checklist")
@CrossOrigin(origins = "http://localhost:3000")
public class ChecklistController {

    private final ChecklistService checklistService;

    @GetMapping("/summary")
    public ResponseEntity<?> getChecklist(
            @RequestHeader("Authorization") String token
    ) {
        return ResponseEntity.ok(checklistService.getSummary(token));
    }
    @GetMapping()
    public ResponseEntity<List<Task>> checkList(
            @RequestHeader("Authorization") String token
    ){
        System.out.println("I am in checkList");
        List<Task> tasks = checklistService.getChecklist(token);
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addListItem(
            @RequestHeader("Authorization") String token,
            @RequestBody AddTaskRequest request
    ){
        UUID id = checklistService.addTask(token, request);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/{item_id}")
    public ResponseEntity<?> changeStatus(
            @PathVariable UUID item_id
    ){
        checklistService.changeTaskStatus(item_id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{item_id}")
    public ResponseEntity<?> deleteItem(
            @PathVariable UUID item_id
    ){
        checklistService.deleteTask(item_id);
        return ResponseEntity.ok().build();
    }
}
