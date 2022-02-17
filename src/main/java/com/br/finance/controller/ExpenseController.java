package com.br.finance.controller;

import com.br.finance.enumeration.StatusEnum;
import com.br.finance.enumeration.TypeExpenseEnum;
import com.br.finance.model.Expense;
import com.br.finance.requests.ExpenseRequestBody;
import com.br.finance.responses.ExpenseResponseBody;
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
    public ResponseEntity<ExpenseResponseBody> findAll() {
        return new ResponseEntity<>(expenseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/list-status")
    public ResponseEntity<ExpenseResponseBody> findAllByStatus(@RequestParam StatusEnum status) {
        return new ResponseEntity<>(expenseService.findAllByStatus(status), HttpStatus.OK);
    }

    @GetMapping("/list-type")
    public ResponseEntity<ExpenseResponseBody> findAllByType(@RequestParam TypeExpenseEnum type) {
        return new ResponseEntity<>(expenseService.findAllByType(type), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Expense> save(@RequestBody ExpenseRequestBody expenseRequestBody) {
        return new ResponseEntity<>(expenseService.save(expenseRequestBody), HttpStatus.CREATED);
    }

    @PostMapping("/calculate")
    public ResponseEntity<ExpenseResponseBody> calculateExpenses(@RequestBody List<Expense> expenses) {
        return new ResponseEntity<>(expenseService.calculateExpenses(expenses), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        expenseService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
