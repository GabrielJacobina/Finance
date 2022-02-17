package com.br.finance.service;

import com.br.finance.dto.ExpenseRequestBody;
import com.br.finance.model.Expense;

import java.util.List;

public interface ExpenseService {

    List<Expense> findAll();

    Expense save(ExpenseRequestBody expenseRequestBody);
}
