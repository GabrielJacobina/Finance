package com.br.finance.service;

import com.br.finance.model.Expense;
import com.br.finance.requests.ExpenseRequestBody;
import com.br.finance.responses.ExpenseResponseBody;

import java.util.List;

public interface ExpenseService {

    ExpenseResponseBody findAll();

    Expense save(ExpenseRequestBody expenseRequestBody);

    ExpenseResponseBody calculateExpenses(List<Expense> expenses);
}
