package com.project.marimay.repository;

import com.project.marimay.models.UsersDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserDetailsRepository extends JpaRepository<UsersDetails, UUID> {
    @Query("select u from UserDetails u where u.id = (select u.id from Users u where u.email = ?1)")
    Optional<UsersDetails> findByEmail(String email);
}
