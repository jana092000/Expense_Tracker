package com.expense.expensetracker.dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ExpenseDto {
    private Long id;
    private String title;
    private Double amount;
    private String category;
    private LocalDate expenseDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
