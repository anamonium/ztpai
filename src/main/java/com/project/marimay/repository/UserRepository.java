package com.project.marimay.repository;

import com.project.marimay.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {

    @Query("select u from Users u where u.email = ?1")
    Optional<Users> findByEmail(String email);
}
