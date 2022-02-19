package com.br.finance.repository;

import com.br.finance.enumeration.StatusEnum;
import com.br.finance.enumeration.TypeExpenseEnum;
import com.br.finance.model.Expense;
import com.br.finance.util.ExpenseCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ExpenseRepositoryTest {

    @Autowired
    private ExpenseRepository expenseRepository;

    @BeforeEach
    void setUp() {
        expenseRepository.save(ExpenseCreator.createExpenseToBeSaved());
    }

    @Test
    void findAllByStatus_returnListExpense_whenSuccesful() {
        List<Expense> expenses = expenseRepository.findAllByStatus(StatusEnum.DUE);

        assertThat(expenses).isNotEmpty();
    }

    @Test
    void findAllByType_returnListExpense_whenSuccesful() {
        List<Expense> expenses = expenseRepository.findAllByType(TypeExpenseEnum.EXPENDITURE);

        assertThat(expenses).isNotEmpty();
    }

    @Test
    void findAllByDueDateBetween() {
        List<Expense> expenses = expenseRepository.findAllByDueDateBetween(LocalDate.of(2022, 2, 1),
                LocalDate.of(2022, 2, 28));

        assertThat(expenses).isNotEmpty();
    }
}
