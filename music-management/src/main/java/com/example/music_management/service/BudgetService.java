package com.example.music_management.service;

import org.springframework.stereotype.Service;

import com.example.music_management.entity.Budget;
import com.example.music_management.form.BudgetForm;
import com.example.music_management.repository.BudgetRepository;
@Service
public class BudgetService {
    private final BudgetRepository budgetRepository;
    public BudgetService(BudgetRepository budgetRepository){
        this.budgetRepository = budgetRepository;
    }
    public void createBudget(BudgetForm budgetForm) {
    Budget budget = new Budget();
    budget.setBudget(budgetForm.getBudget());
    budgetRepository.insertBudget(budget);
    }
    public Integer getBudgetAmount(long userId) {
        return budgetRepository.getBudgetAmount(userId);
    }
}
