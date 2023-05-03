package com.project.marimay.repository;

import com.project.marimay.models.BudgetItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BudgetItemRepository extends JpaRepository<BudgetItem, UUID> {
}
