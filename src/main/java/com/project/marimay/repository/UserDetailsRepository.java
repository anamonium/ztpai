package com.project.marimay.repository;

import com.project.marimay.models.UsersDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserDetailsRepository extends JpaRepository<UsersDetails, UUID> {
}
