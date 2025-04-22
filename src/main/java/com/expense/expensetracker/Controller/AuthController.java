package com.expense.expensetracker.Controller;

import com.expense.expensetracker.dto.UserDto;
import com.expense.expensetracker.model.User;
import com.expense.expensetracker.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {
        private final UserService userService;

        @PostMapping("/register")
        public ResponseEntity<User> registerUser(@Valid @RequestBody UserDto userDto)
        {
            User created = userService.registerUser(userDto);
            return ResponseEntity.ok(created);
        }

        @GetMapping("/ping")
        public ResponseEntity<String> ping() {
            return ResponseEntity.ok("Registration service is up.");
        }
}
