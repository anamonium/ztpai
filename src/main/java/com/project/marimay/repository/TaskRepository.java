package com.project.marimay.repository;

import com.project.marimay.models.Checklist;
import com.project.marimay.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
    @Query("Select t from Task t where t.checklist= ?1")
    List<Task> findTaskByIdChecklistEquals(
            Checklist checklist
    );

    @Query("select t from Task t where t.id = ?1")
    Optional<Task> getTaskById(UUID id);

}
