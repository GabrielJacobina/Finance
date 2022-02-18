package com.br.finance.requests;

import com.br.finance.enumeration.StatusEnum;
import com.br.finance.enumeration.TypeExpenseEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@Builder
public class ExpenseRequestBody {

    private String name;
    private Double value;
    private LocalDate dueDate;
    private TypeExpenseEnum type;
    private StatusEnum status;
}
