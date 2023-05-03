package com.project.marimay.repository;

import com.project.marimay.models.Budget;

import com.project.marimay.models.BudgetItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface BudgetRepository extends JpaRepository<Budget, String> {

    @Query("select b from Budget b where b.id = (select u.id from Users u where u.email = ?1)")
    Optional<Budget> findByIdUser(String userEmail);

    @Query("select b from BudgetItem b where b.budget = ?1")
    List<BudgetItem> findByBudget(Budget budget);
}
