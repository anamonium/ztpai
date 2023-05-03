package com.project.marimay.repository;

import com.project.marimay.models.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface ChecklistRepository extends JpaRepository<Checklist, UUID> {
    @Query("select ch from Checklist ch where ch.id = (select u.id from Users u where u.email = ?1)")
    Optional<Checklist> findByIdEquals(String userEmail);
}
