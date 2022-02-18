package com.br.finance.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@Builder
public class RevenueRequestBody {

    private String name;
    private Double value;
    private LocalDate date;
}
