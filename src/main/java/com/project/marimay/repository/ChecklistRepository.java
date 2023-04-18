package com.project.marimay.repository;

import com.project.marimay.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChecklistRepository extends JpaRepository<Task, String> {
    @Query("Select t from Task t where t.idChecklist= ?1")
    List<Task> findTaskByIdChecklistEquals(
            String idChecklist
    );

    @Query("Select t from Task t where t.idChecklist= ?1 and t.status = ?2")
    List<Task> findTaskByIdChecklistEqualsAndStatusEquals(
            String idChecklist,
            Boolean status
    );
}
