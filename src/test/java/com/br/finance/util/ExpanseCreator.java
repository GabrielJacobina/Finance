package com.br.finance.util;

import com.br.finance.enumeration.StatusEnum;
import com.br.finance.enumeration.TypeExpenseEnum;
import com.br.finance.model.Expense;

import java.time.LocalDate;

public class ExpanseCreator {

    public static Expense createExpenseToBeSaved() {
        return Expense.builder()
                .name("Energia")
                .value(130.00)
                .type(TypeExpenseEnum.EXPENDITURE)
                .status(StatusEnum.DUE)
                .dueDate(LocalDate.of(2022, 2, 21))
                .build();
    }

    public static Expense createValidExpense() {
        return Expense.builder()
                .id(1L)
                .name("Energia")
                .value(130.00)
                .type(TypeExpenseEnum.EXPENDITURE)
                .status(StatusEnum.DUE)
                .dueDate(LocalDate.of(2022, 2, 21))
                .build();
    }
}
