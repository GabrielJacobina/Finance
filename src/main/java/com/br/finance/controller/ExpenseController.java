package com.br.finance.controller;

import com.br.finance.dto.ExpenseRequestBody;
import com.br.finance.model.Expense;
import com.br.finance.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<List<Expense>> findAll() {
        return new ResponseEntity<>(expenseService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Expense> save(@RequestBody ExpenseRequestBody expenseRequestBody) {
        return new ResponseEntity<>(expenseService.save(expenseRequestBody), HttpStatus.CREATED);
    }
}
