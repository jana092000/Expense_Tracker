package com.expense.expensetracker.Controller;

import com.expense.expensetracker.dto.ExpenseDto;
import com.expense.expensetracker.model.Expense;
import com.expense.expensetracker.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expense")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<?> addExpense(@RequestBody ExpenseDto expenseDto) {
        Expense createdExpense = expenseService.postExpenses(expenseDto);
        if (createdExpense != null) {
            return new ResponseEntity<>(createdExpense, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
   }

}

}