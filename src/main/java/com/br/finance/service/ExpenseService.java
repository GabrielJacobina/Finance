package com.br.finance.service;

import com.br.finance.enumeration.StatusEnum;
import com.br.finance.enumeration.TypeExpenseEnum;
import com.br.finance.model.Expense;
import com.br.finance.requests.ExpenseRequestBody;
import com.br.finance.responses.ExpenseResponseBody;

import java.util.List;

public interface ExpenseService {

    ExpenseResponseBody findAll();

    ExpenseResponseBody findAllByStatus(StatusEnum status);

    ExpenseResponseBody findAllByType(TypeExpenseEnum type);

    Expense save(ExpenseRequestBody expenseRequestBody);

    void delete(Long id);

    ExpenseResponseBody calculateExpenses(List<Expense> expenses);
}
