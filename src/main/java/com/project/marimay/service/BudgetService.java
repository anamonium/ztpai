package com.project.marimay.service;

import com.project.marimay.dto.request.AddBudgetItemRequest;
import com.project.marimay.models.Budget;
import com.project.marimay.models.BudgetItem;
import com.project.marimay.models.WeddingDetails;
import com.project.marimay.repository.BudgetItemRepository;
import com.project.marimay.repository.BudgetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
@Service
public class BudgetService {
    private final JwtService jwtService;
    private final BudgetItemRepository budgetItemRepository;
    private final BudgetRepository budgetRepository;

    public List<BudgetItem> budgetItems(String token){
        String username = jwtService.extractUsername(token.substring(7));
        Budget budget = budgetRepository.findByIdUser(username).orElse(null);

        return budgetRepository.findByBudget(budget);
    }

    public UUID addBudgetItem(String token, AddBudgetItemRequest request){

        String username = jwtService.extractUsername(token.substring(7));
        Budget budget = budgetRepository.findByIdUser(username).orElse(null);

        var budgetItem = BudgetItem.builder()
                .cost(request.getCost())
                .name(request.getName())
                .budget(budget)
                .build();

        budgetItemRepository.save(budgetItem);

        assert budget != null;
        budget.setBudgetSpend(budget.getBudgetSpend() + budgetItem.getCost());
        budgetRepository.save(budget);

        return budgetItem.getId();
    }

    public void deleteBudgetItem(UUID id){
        BudgetItem budgetItem = budgetItemRepository.findById(id).orElse(null);

        assert budgetItem != null;
        Budget budget = budgetItem.getBudget();
        budget.setBudgetSpend(budget.getBudgetSpend() - budgetItem.getCost());
        budgetRepository.save(budget);

        budgetItemRepository.delete(budgetItem);
    }

    public Map<String, Double> getSummary(String token){
        String username = jwtService.extractUsername(token.substring(7));
        Budget budget = budgetRepository.findByIdUser(username).orElse(null);
        WeddingDetails wd = budget.getWeddingDetails();

        Map<String, Double> summary = new HashMap<>();
        summary.put("spend", budget.getBudgetSpend());
        summary.put("beginning", wd.getWeddingBudget());

        return summary;

    }

}
