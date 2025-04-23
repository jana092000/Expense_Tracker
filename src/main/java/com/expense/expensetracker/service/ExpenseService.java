package com.expense.expensetracker.service;


import com.expense.expensetracker.dto.ExpenseDto;
import com.expense.expensetracker.model.Expense;

public interface ExpenseService {
    Expense postExpenses(ExpenseDto expenseDto);

}
