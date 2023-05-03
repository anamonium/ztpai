package com.project.marimay.repository;

import com.project.marimay.models.GuestList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface GuestListRepository extends JpaRepository<GuestList, UUID> {

    @Query("select g from GuestList g where g.id = (select u.id from Users u where u.email = ?1)")
    Optional<GuestList> findByIdEquals(String userEmail);
}
