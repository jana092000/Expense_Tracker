package com.expense.expensetracker.Controller;


import com.expense.expensetracker.model.User;
import com.expense.expensetracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UsersController {
    private final UserService userService;

    @PostMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable String id)
    {
        return ResponseEntity.ok(userService.getUser(id));
    }

}
