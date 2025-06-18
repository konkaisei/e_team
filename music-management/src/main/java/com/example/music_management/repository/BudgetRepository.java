package com.example.music_management.repository;

import org.springframework.stereotype.Repository;

import com.example.music_management.entity.Budget;
import com.example.music_management.mapper.BudgetMapper;
@Repository
public class BudgetRepository {
    private final BudgetMapper budgetMapper;
    public BudgetRepository(BudgetMapper budgetMapper) {
        this.budgetMapper = budgetMapper;
    }

    public void insertBudget(Budget budget) {
    budgetMapper.insertBudget(budget);
    }
    
    public Integer getBudgetAmount(long userId) {
        return budgetMapper.selectBudgetAmount(userId);
    }

    public void updateBudgetAmount(Integer budgetAmount, long userId) {
        budgetMapper.updateBudgetAmount(budgetAmount, userId);
    }
}
