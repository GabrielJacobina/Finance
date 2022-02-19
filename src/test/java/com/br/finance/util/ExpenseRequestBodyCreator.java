package com.br.finance.util;

import com.br.finance.enumeration.StatusEnum;
import com.br.finance.enumeration.TypeExpenseEnum;
import com.br.finance.model.Expense;
import com.br.finance.requests.ExpenseRequestBody;

import java.time.LocalDate;

public class ExpenseRequestBodyCreator {

    public static ExpenseRequestBody createExpenseRequestBody() {
        return ExpenseRequestBody.builder()
                .name("Energia")
                .value(130.00)
                .type(TypeExpenseEnum.EXPENDITURE)
                .status(StatusEnum.DUE)
                .dueDate(LocalDate.of(2022, 2, 21))
                .build();
    }
}
