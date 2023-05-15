package com.project.marimay.repository;

import com.project.marimay.models.WeddingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface WeddingDetailsRepository extends JpaRepository<WeddingDetails, UUID> {
    @Override
    Optional<WeddingDetails> findById(UUID uuid);

    @Query("select w from WeddingDetails w where w.id = (select u.id from Users u where u.email = ?1)")
    Optional<WeddingDetails> findByIdEquals(String userEmail);
}
