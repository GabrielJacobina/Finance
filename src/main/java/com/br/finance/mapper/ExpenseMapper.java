package com.br.finance.mapper;

import com.br.finance.dto.ExpenseRequestBody;
import com.br.finance.model.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ExpenseMapper {

    public static final ExpenseMapper INSTANCE = Mappers.getMapper(ExpenseMapper.class);

    public abstract Expense expenseRequestBodytoExpense(ExpenseRequestBody expenseRequestBody);

}
