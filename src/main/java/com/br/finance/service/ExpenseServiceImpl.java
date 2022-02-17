package com.br.finance.service;

import com.br.finance.dto.ExpenseRequestBody;
import com.br.finance.mapper.ExpenseMapper;
import com.br.finance.model.Expense;
import com.br.finance.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService{

    private final ExpenseRepository expenseRepository;

    @Override
    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    public Expense save(ExpenseRequestBody expenseRequestBody) {
        Expense expense = ExpenseMapper.INSTANCE.expenseRequestBodytoExpense(expenseRequestBody);
        return expenseRepository.save(expense);
    }
}
