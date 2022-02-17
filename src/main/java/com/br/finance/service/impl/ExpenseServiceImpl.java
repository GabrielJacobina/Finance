package com.br.finance.service.impl;

import com.br.finance.dto.ExpenseRequestBody;
import com.br.finance.model.Expense;
import com.br.finance.repository.ExpenseRepository;
import com.br.finance.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.br.finance.mapper.ExpenseMapper.INSTANCE;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Override
    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    public Expense save(ExpenseRequestBody expenseRequestBody) {
        Expense expense = INSTANCE.expenseRequestBodytoExpense(expenseRequestBody);
        return expenseRepository.save(expense);
    }
}
