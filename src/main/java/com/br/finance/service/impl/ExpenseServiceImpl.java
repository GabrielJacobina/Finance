package com.br.finance.service.impl;

import com.br.finance.enumeration.StatusEnum;
import com.br.finance.enumeration.TypeExpenseEnum;
import com.br.finance.model.Expense;
import com.br.finance.repository.ExpenseRepository;
import com.br.finance.requests.ExpenseRequestBody;
import com.br.finance.responses.ExpenseResponseBody;
import com.br.finance.service.ExpenseService;
import com.br.finance.exceptions.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    @Override
    public ExpenseResponseBody findAllByStatus(StatusEnum status) {
        return this.calculateExpenses(expenseRepository.findAllByStatus(status));
    }

    @Override
    public ExpenseResponseBody findAllByType(TypeExpenseEnum type) {
        return this.calculateExpenses(expenseRepository.findAllByType(type));
    }

    @Override
    public ExpenseResponseBody findAllByMonth(LocalDate date) {
        LocalDate dateInit = LocalDate.of(date.getYear(), date.getMonth(), 1);
        LocalDate dateFinal = LocalDate.of(date.getYear(), date.getMonth(), date.lengthOfMonth());
        return this.calculateExpenses(expenseRepository.findAllByDueDateBetween(dateInit, dateFinal));
    }

    private Expense findById(Long id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Expense not found"));
    }

    @Override
    public Expense save(ExpenseRequestBody expenseRequestBody) {
        Expense expense = INSTANCE.expenseRequestBodytoExpense(expenseRequestBody);
        return expenseRepository.save(expense);
    }

    @Override
    public void delete(Long id) {
        this.expenseRepository.delete(findById(id));
    }

    @Override
    public ExpenseResponseBody calculateExpenses(List<Expense> expenses) {
        ExpenseResponseBody expensesResponseBody = new ExpenseResponseBody(new ArrayList<>(), 0D);
        for (Expense expense: expenses) {
            expensesResponseBody.setTotal(expensesResponseBody.getTotal() + expense.getValue());
            expensesResponseBody.getExpenses().add(INSTANCE.expensetoExpenseRequestBody(expense));
        }
        return expensesResponseBody;
    }

    @Override
    public void updateStatus(Long id, StatusEnum status) {
        Expense expense = findById(id);
        expense.setStatus(status);
        expenseRepository.save(expense);
    }
}
