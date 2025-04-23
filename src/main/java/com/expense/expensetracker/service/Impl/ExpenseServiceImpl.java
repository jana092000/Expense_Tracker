package com.expense.expensetracker.service.Impl;

import com.expense.expensetracker.dto.ExpenseDto;
import com.expense.expensetracker.model.Expense;
import com.expense.expensetracker.repository.ExpenseRepository;
import com.expense.expensetracker.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;

    public Expense postExpenses(ExpenseDto expenseDto) {
        return saveOrUpdateExpense(new Expense(), expenseDto);
    }

    private Expense saveOrUpdateExpense(Expense expense, ExpenseDto expenseDto) {
        expense.setTitle(expenseDto.getTitle());
        expense.setAmount(expenseDto.getAmount());
        expense.setCategory(expenseDto.getCategory());
        expense.setExpenseDate(expenseDto.getExpenseDate());

        // Set createdAt only if new
        if (expense.getId() == null) {
            expense.setCreatedAt(LocalDateTime.now());
        }

        // Always update updatedAt
        expense.setUpdatedAt(LocalDateTime.now());

        return expenseRepository.save(expense);
}
}