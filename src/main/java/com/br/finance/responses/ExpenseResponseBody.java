package com.br.finance.responses;

import com.br.finance.requests.ExpenseRequestBody;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExpenseResponseBody {

    private List<ExpenseRequestBody> expenses;
    private Double total;
}
