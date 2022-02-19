package com.br.finance.service.impl;

import com.br.finance.enumeration.StatusEnum;
import com.br.finance.enumeration.TypeExpenseEnum;
import com.br.finance.model.Expense;
import com.br.finance.repository.ExpenseRepository;
import com.br.finance.responses.ExpenseResponseBody;
import com.br.finance.service.exceptions.BadRequestException;
import com.br.finance.util.ExpenseCreator;
import com.br.finance.util.ExpenseRequestBodyCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class ExpenseServiceImplTest {

    @InjectMocks
    private ExpenseServiceImpl expenseService;

    @Mock
    private ExpenseRepository expenseRepository;

    @BeforeEach
    void setUp() {
        BDDMockito.when(expenseRepository.findAll())
                .thenReturn(List.of(ExpenseCreator.createValidExpense()));

        BDDMockito.when(expenseRepository.findAllByStatus(ArgumentMatchers.any(StatusEnum.class)))
                .thenReturn(List.of(ExpenseCreator.createValidExpense()));

        BDDMockito.when(expenseRepository.findAllByType(ArgumentMatchers.any(TypeExpenseEnum.class)))
                .thenReturn(List.of(ExpenseCreator.createValidExpense()));

        BDDMockito.when(expenseRepository.findAllByDueDateBetween(ArgumentMatchers.any(LocalDate.class), ArgumentMatchers.any(LocalDate.class)))
                .thenReturn(List.of(ExpenseCreator.createValidExpense()));

        BDDMockito.when(expenseRepository.save(ArgumentMatchers.any(Expense.class)))
                .thenReturn(ExpenseCreator.createValidExpense());

        BDDMockito.doNothing().when(expenseRepository).delete(ArgumentMatchers.any(Expense.class));

        BDDMockito.when(expenseRepository.findById(1L))
                .thenReturn(Optional.ofNullable(ExpenseCreator.createValidExpense()));
    }

    @Test
    void findAll_returnListOfExpense_whenSuccesful() {
        ExpenseResponseBody expenses = expenseService.findAll();

        assertThat(expenses).isNotNull();
        assertThat(expenses.getExpenses()).isNotEmpty();
    }

    @Test
    void findAllByStatus_returnListOfExpense_whenSuccesful() {
        ExpenseResponseBody expenses = expenseService.findAllByStatus(StatusEnum.DUE);

        assertThat(expenses).isNotNull();
        assertThat(expenses.getExpenses()).isNotEmpty();
    }

    @Test
    void findAllByType_returnListOfExpense_whenSuccesful() {
        ExpenseResponseBody expenses = expenseService.findAllByType(TypeExpenseEnum.EXPENDITURE);

        assertThat(expenses).isNotNull();
        assertThat(expenses.getExpenses()).isNotEmpty();
    }

    @Test
    void findAllByMonth_returnListOfExpense_whenSuccesful() {
        ExpenseResponseBody expenses = expenseService.findAllByMonth(LocalDate.now());

        assertThat(expenses).isNotNull();
        assertThat(expenses.getExpenses()).isNotEmpty();
    }

    @Test
    void save_returnExpense_whenSucessful() {
        Expense expenseExpect = expenseService.save(ExpenseRequestBodyCreator.createExpenseRequestBody());

        assertThat(expenseExpect).isNotNull();
        assertThat(expenseExpect.getName()).isEqualTo(expenseExpect.getName());
    }

    @Test
    void delete_deleteExpense_whenSuccesful() {
        assertThatCode(() -> expenseService.delete(1L)).doesNotThrowAnyException();
    }

    @Test
    void updateStatus_updateStatusExpense_whenSuccesful() {
        assertThatCode(() -> expenseService.updateStatus(1L, StatusEnum.PAID))
                .doesNotThrowAnyException();
    }

    @Test
    void updateStatus_ThrowsBadRequestException_whenExpenseNotFound() {
        assertThatExceptionOfType(BadRequestException.class)
                .isThrownBy(() -> expenseService.updateStatus(2L, StatusEnum.PAID));
    }
}
