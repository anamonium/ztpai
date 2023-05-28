package com.project.marimay.service;

import com.project.marimay.dto.request.AddTaskRequest;
import com.project.marimay.models.Checklist;
import com.project.marimay.models.GuestList;
import com.project.marimay.models.Task;
import com.project.marimay.repository.ChecklistRepository;
import com.project.marimay.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ChecklistService {
    private final TaskRepository taskRepository;
    private final ChecklistRepository checklistRepository;

    private final JwtService jwtService;

    public List<Task> getChecklist(String token){
        String username = jwtService.extractUsername(token.substring(7));
        Checklist checklist = checklistRepository.findByIdEquals(username).orElse(null);
        return taskRepository.findTaskByIdChecklistEquals(checklist);
    }

    public UUID addTask(String token, AddTaskRequest request){
        String username = jwtService.extractUsername(token.substring(7));
        Checklist checklist = checklistRepository.findByIdEquals(username).orElse(null);

        var task = Task.builder()
                .checklist(checklist)
                .title(request.getTitle())
                .content(request.getContent())
                .status(false)
                .build();

        taskRepository.save(task);

        checklist.setAllSubtask(checklist.getAllSubtask() + 1);
        checklistRepository.save(checklist);

        return task.getId();
    }

    public void changeTaskStatus(UUID taskId){
        Task task = taskRepository.getTaskById(taskId).orElse(null);

        assert task != null;
        task.setStatus(!task.getStatus());
        taskRepository.save(task);

        int value = task.getStatus() ? 1 : -1;
        Checklist checklist = task.getChecklist();
        checklist.setSubtaskDone(checklist.getSubtaskDone() + value);
        checklistRepository.save(checklist);
    }

    public void deleteTask(UUID taskId){
        Task task = taskRepository.getTaskById(taskId).orElse(null);

        assert task != null;
        int value = task.getStatus() ? -1 : 0;

        Checklist checklist = task.getChecklist();
        checklist.setSubtaskDone(checklist.getSubtaskDone() + value);
        checklist.setAllSubtask(checklist.getAllSubtask() - 1);
        checklistRepository.save(checklist);

        taskRepository.delete(task);
    }

    public Map<String, Integer> getSummary(String token){
        String username = jwtService.extractUsername(token.substring(7));
        Checklist checklist = checklistRepository.findByIdEquals(username).orElse(null);

        Map<String, Integer> summary = new HashMap<>();
        summary.put("all", checklist.getAllSubtask());
        summary.put("done", checklist.getSubtaskDone());

        return summary;
    }

}
