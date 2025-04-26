package com.expense.expensetracker.service.Impl;

import com.expense.expensetracker.dto.ExpenseDto;
import com.expense.expensetracker.model.Expense;
import com.expense.expensetracker.repository.ExpenseRepository;
import com.expense.expensetracker.service.ExpenseService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public Expense updateExpense(Long id, ExpenseDto expenseDto) {
        Optional<Expense> expenseOptional = expenseRepository.findById(id);
        if(expenseOptional.isPresent()) {
            return saveOrUpdateExpense(expenseOptional.get(), expenseDto);
        }else{
            throw new EntityNotFoundException("Expense not found for this id" + id);
        }
    }

    public List<Expense> getAllExpensesSortedByDate() {
        return expenseRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Expense::getExpenseDate).reversed())
                .collect(Collectors.toList());
    }

    public Expense getExpenseById(Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        if (expense.isPresent()) {
            return expense.get();
        }else {
            throw new EntityNotFoundException("Expense not found for this id" + id);
        }
    }
}