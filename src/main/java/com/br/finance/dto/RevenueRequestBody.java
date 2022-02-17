package com.br.finance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class RevenueRequestBody {

    private String name;
    private Double value;
    private LocalDate date;
}
