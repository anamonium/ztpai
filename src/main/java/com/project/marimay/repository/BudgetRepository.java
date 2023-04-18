package com.project.marimay.repository;

import com.project.marimay.models.BudgetItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BudgetRepository extends JpaRepository<BudgetItem, String> {
    @Query("Select b from BudgetItem b where b.idBudget = ?1")
    List<BudgetItem> findBudgetItemByIdBudgetEquals(String idBudget);

}
