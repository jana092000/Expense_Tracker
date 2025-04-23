package com.expense.expensetracker.service;


import com.expense.expensetracker.dto.ExpenseDto;
import com.expense.expensetracker.model.Expense;

import java.util.List;

public interface ExpenseService {
    Expense postExpenses(ExpenseDto expenseDto);
    List<Expense> getAllExpensesSortedByDate();
    Expense getExpenseById(Long id);

}
