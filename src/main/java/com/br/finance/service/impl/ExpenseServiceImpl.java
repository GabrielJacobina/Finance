package com.br.finance.service.impl;

import com.br.finance.model.Expense;
import com.br.finance.repository.ExpenseRepository;
import com.br.finance.requests.ExpenseRequestBody;
import com.br.finance.responses.ExpenseResponseBody;
import com.br.finance.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.br.finance.mapper.ExpenseMapper.INSTANCE;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Override
    public ExpenseResponseBody findAll() {
        return this.calculateExpenses(expenseRepository.findAll());
    }

    public Expense save(ExpenseRequestBody expenseRequestBody) {
        Expense expense = INSTANCE.expenseRequestBodytoExpense(expenseRequestBody);
        return expenseRepository.save(expense);
    }

    public ExpenseResponseBody calculateExpenses(List<Expense> expenses) {
        ExpenseResponseBody expensesResponseBody = new ExpenseResponseBody(new ArrayList<>(), 0D);
        for (Expense expense: expenses) {
            expensesResponseBody.setTotal(expensesResponseBody.getTotal() + expense.getValue());
            expensesResponseBody.getExpenses().add(INSTANCE.expensetoExpenseRequestBody(expense));
        }
        return expensesResponseBody;
    }
}
