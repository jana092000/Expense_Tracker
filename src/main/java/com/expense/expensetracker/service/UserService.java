package com.expense.expensetracker.service;

import com.expense.expensetracker.dto.UserDto;
import com.expense.expensetracker.model.User;

public interface UserService {
    User registerUser(UserDto userDto);
    User getUser(String Id);
}
