package com.br.finance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RevenuesResponseBody {

    private List<RevenueRequestBody> revenues;
    private Double total;
}
